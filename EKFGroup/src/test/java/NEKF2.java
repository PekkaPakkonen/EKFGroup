import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;



public class NEKF2 {

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
        String[] links = {"distributor", "nku", "project", "industry","civil-construction", "smo", "retail", "homeowner"};
        String linkEKF = "https://ekfgroup.com/view/";

        webDriver.findElement(mainP.getSolutionsBtn()).click();

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://old.ekfgroup.com/resheniya"));//link to old EKF site
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".filter-group .btn.active")));
        webDriver.navigate().back();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));

        By[] headers = {mainP.getSupportBtn(), mainP.getCalculatorsBtn(),
                mainP.getWhereToBuyBtn(), mainP.getAboutUsBtn()};
        WebElement[] menus = webDriver.findElements(By.cssSelector(".dropdown-menu.menu-dropdown"))
                .toArray(new WebElement[0]);

        for(int i = 0; i < headers.length; i++) {
            webDriver.findElement(headers[i]).click();
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfAllElements(menus[i]));
            webDriver.findElement(headers[i]).click();
        }
    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }
}
