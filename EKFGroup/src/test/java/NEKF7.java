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

public class NEKF7 {

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

        String[] links = {"feedback", "project", "report","question"};
        webDriver.findElement(By.cssSelector(".header-dropdowns .dropdown:first-child .btn")).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown-menu.show")));
        WebElement[] elements = webDriver.findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"]"))
                .toArray(new WebElement[0]);
        for(int i = 0; i < elements.length; i++) {
            elements[i].click();
            new WebDriverWait(webDriver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.urlContains(links[i]));
            webDriver.get("https://ekfgroup.com/");
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
            webDriver.findElement(By.cssSelector(".header-dropdowns .dropdown:first-child .btn")).click();
            new WebDriverWait(webDriver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown-menu.show")));
            elements = webDriver.findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"]"))
                    .toArray(new WebElement[0]);
        }
    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
