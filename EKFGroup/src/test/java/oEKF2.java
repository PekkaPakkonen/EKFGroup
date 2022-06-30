import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.net.MalformedURLException;

public class oEKF2 {

    private WebDriver webDriver;

    @BeforeTest
    public void prep() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        webDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void getCompanyPage() {
        webDriver.get("https://ekfgroup.com/about/production");
        new WebDriverWait(webDriver,Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("h1.text-lg-center")));
    }

    @Test
    public void checkLink() {
        webDriver.findElement(By.cssSelector(".row.mb-n16 .btn")).click();
        new WebDriverWait(webDriver,Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .urlToBe("https://ekfgroup.com/about/esg"));
    }

    @AfterTest
    public void quitBrowser() {
        webDriver.quit();
    }

}
