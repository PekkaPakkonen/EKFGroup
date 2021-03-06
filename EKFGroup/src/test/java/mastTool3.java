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

public class mastTool3 {

    private WebDriver driver;
    private mToolCapacitor page;

    @BeforeTest
    public void link() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        driver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        driver.manage().window().maximize();
        page = new mToolCapacitor(driver);
        driver.get("https://ekfgroup.com/calculators/mastertool/motor-capacitor");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.w-100")));
    }

    @Test
    public void check() throws InterruptedException {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.w-100"));
        driver.switchTo().frame(iframe);
        String capacitorFirst = page.getTextCapacitorOperating();
        String capacitorSecond = page.getTextCapacitorStarting();

        page.efficiencyTextFieldInput("2000");
        compareCapacitors(capacitorFirst, capacitorSecond);

        page.voltageTextFieldInput("400");
        compareCapacitors(capacitorFirst, capacitorSecond);

        page.powerCoeffTextFieldInput("0,88");
        compareCapacitors(capacitorFirst, capacitorSecond);

        page.efficiencyTextFieldInput("0,97");
        compareCapacitors(capacitorFirst, capacitorSecond);

        page.deltaConnectBtnClick();
        compareCapacitors(capacitorFirst, capacitorSecond);

        page.starConnectBtnClick();
        compareCapacitors(capacitorFirst, capacitorSecond);
    }

    @AfterTest
    public void exit() {
        driver.quit();
    }

    public void compareCapacitors (String value1, String value2) {
        System.out.println(value1 + ", " + value2);
        System.out.println(page.getTextCapacitorOperating() + ", " + page.getTextCapacitorStarting());
        Assert.assertNotEquals(value2, page.getTextCapacitorStarting());
    }
}
