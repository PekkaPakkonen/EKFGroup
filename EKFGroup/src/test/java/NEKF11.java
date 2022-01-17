import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF11 {

    //.footer-social-links .btn-social .icon

    private WebDriver webDriver;
    private mainPage mainP;

    @BeforeTest
    public void prep() {

        webDriver = new FirefoxDriver();
        mainP = new mainPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/");
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
    }

    @Test
    public void click() {
        String[] links = {"instagram", "youtube", "facebook", "twitter", "vk.com"};
        WebElement[] elements = webDriver
                .findElements(By.cssSelector(".footer-social-links .btn-social .icon"))
                .toArray(new WebElement[0]);
        for(int i = 1; i < elements.length; i++) {
            elements[i].click();
            String[] windows = webDriver.getWindowHandles().toArray(new String[0]);
            webDriver.switchTo().window(windows[1]);
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.urlContains(links[i]));
            webDriver.close();
            webDriver.switchTo().window(windows[0]);
        }
    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
