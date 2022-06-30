import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.net.MalformedURLException;



public class mastTool1 {

    private WebDriver driver;
    private mToolCurrent page;

    @BeforeTest
    public void link() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        driver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        page = new mToolCurrent(driver);
        driver.get("https://ekfgroup.com/calculators/mastertool/current-in-circuit");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.w-100")));
    }

    @Test
    public void click() throws InterruptedException {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.w-100"));
        driver.switchTo().frame(iframe);
        String current = page.getCalculatedCurrentText();

        page.threePhaseBtnClick();
        Assert.assertNotEquals(current, page.getCalculatedCurrentText());

        page.powerTextFieldInput("1000");
        Assert.assertNotEquals(current, page.getCalculatedCurrentText());

        page.voltageTextFieldInput("240");
        Assert.assertNotEquals(current, page.getCalculatedCurrentText());

        page.powerCoefficientTextFieldInput("0,83");
        Assert.assertNotEquals(current, page.getCalculatedCurrentText());

        page.reactiveLoadTypeBtnClick();
        Assert.assertNotEquals(current, page.getCalculatedCurrentText());

        page.singlePhaseBtnClick();
        Assert.assertNotEquals(current, page.getCalculatedCurrentText());
    }

    @AfterTest
    public void exit() {
        driver.quit();
    }



}
