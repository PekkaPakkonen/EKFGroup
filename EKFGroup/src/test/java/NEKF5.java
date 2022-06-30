import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import java.time.Duration;
import java.net.MalformedURLException;

public class NEKF5 {

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

        webDriver.findElement(By.cssSelector(".header-menu-main .nav-item:nth-child(5)")).click();
        WebElement[] elements = webDriver
                .findElements(By.cssSelector(".header-menu-main .nav-item:nth-child(5) [role=\"presentation\"]"))
                .toArray(new WebElement[0]);
        String[] links = {"company",
                "production",
                "career",
                "news",
                "articles",
                "video",
                "esg",
                "fair-position",
                "qms",
                "contacts"};
        String linkEKF = "https://ekfgroup.com/about/";

        for (int i = 0; i < elements.length; i++) {
            elements[i].click();
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlToBe(linkEKF + links[i]));
            webDriver.findElement(By.cssSelector(".header-menu-main .nav-item:nth-child(5)")).click();
        }


    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }
}
