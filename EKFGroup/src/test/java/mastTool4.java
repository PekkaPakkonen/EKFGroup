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

public class mastTool4 {

    private WebDriver driver;
    private mToolThermalResistance page;

    @BeforeTest
    public void link() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        driver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        driver.manage().window().maximize();
        page = new mToolThermalResistance(driver);
        driver.get("https://ekfgroup.com/calculators/mastertool/thermal-stability");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.w-100")));
    }

    @Test
    public void check() throws InterruptedException {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.w-100"));
        driver.switchTo().frame(iframe);
        String current = page.getTextCurrentAllowed();
        page.groundTTBtnClick();
        driver.findElement(page.getGroundTTBtn()).getAttribute("active");
        page.groundTNBtnClick();
        driver.findElement(page.getGroundTNBtn()).getAttribute("active");
        page.cableCrossSectionBtnSelect(2);
        Thread.sleep(100);
        Assert.assertNotEquals(current, page.getTextCurrentAllowed());
        page.shutDownTimeFieldInput("0,5");
        Assert.assertNotEquals(current, page.getTextCurrentAllowed());

    }

    @AfterTest
    public void exit() {
        driver.quit();
    }



}
