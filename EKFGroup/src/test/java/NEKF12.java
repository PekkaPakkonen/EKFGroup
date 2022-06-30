import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.net.MalformedURLException;

public class NEKF12 {

    //.mb-12 .lh-120:first-child .text-reset

    private WebDriver webDriver;
    private mainPage mainP;

    @BeforeTest
    public void prep() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        mainP = new mainPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/");
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
    }

    @Test
    public void click() {
        webDriver.findElement(By.cssSelector(".mb-12 .lh-120:first-child .text-reset")).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("user-agreement"));
        webDriver.navigate().back();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector(".mb-12 .lh-120:first-child .text-reset")));
        webDriver.findElement(By.cssSelector(".mb-12 .lh-120:nth-child(2) .text-reset")).click();
        String[] windows = webDriver.getWindowHandles().toArray(new String[0]);
        webDriver.switchTo().window(windows[1]);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("https://www.e-disclosure.ru"));
    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
