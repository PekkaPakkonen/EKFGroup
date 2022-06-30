import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.net.MalformedURLException;

public class oEKF6 {

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
        webDriver.get("https://ekfgroup.com/about/video");
        new WebDriverWait(webDriver,Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("h2.mb-0")));
    }

    @Test
    public void checkLink() {
        WebElement[] elements = webDriver.findElements(
                By.cssSelector(".row .text-right .btn")).toArray(new WebElement[0]);
        for (int i = 0; i < elements.length; i++) {
            elements[i].click();
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .elementToBeClickable(
                                    By.cssSelector(".card-img .embed-responsive-item")));
            webDriver.get("https://ekfgroup.com/about/video");
            new WebDriverWait(webDriver,Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.cssSelector("h2.mb-0")));
            elements = webDriver.findElements(
                    By.cssSelector(".row .text-right .btn")).toArray(new WebElement[0]);
        }
    }

    @AfterTest
    public void quitBrowser() {
        webDriver.quit();
    }

}
