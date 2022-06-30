import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class oEKF78 {

    private WebDriver webDriver;

    @BeforeTest
    public void prep() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        webDriver.manage().window().maximize();
    }



    @Test
    public void checkESGLink() {
        webDriver.get("https://ekfgroup.com/about/esg");
        new WebDriverWait(webDriver,Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".h2.mb-lg-64")));
        webDriver.findElement(By.cssSelector(".mb-16 .btn-link")).click();
        new WebDriverWait(webDriver,Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .urlToBe("https://ekfgroup.com/about/fair-position"));

    }

    @Test
    public void checkLink() {
        webDriver.get("https://ekfgroup.com/about/contacts");
        new WebDriverWait(webDriver,Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("h1.mb-32")));
        WebElement[] elements = webDriver.findElements(
                By.cssSelector(".col-lg-5 .card")).toArray(new WebElement[0]);
        for (WebElement element : elements) {
            element.click();
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(
                                    By.cssSelector(".col-lg-5 .card .collapse.show p")));
            element.click();
        }


    }

    @AfterTest
    public void quitBrowser() {
        webDriver.quit();
    }
}
