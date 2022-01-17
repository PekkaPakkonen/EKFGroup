import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF14 {

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
        webDriver.findElement(By.cssSelector(".header-locale-dropdown .nav-link")).click();
        String[] windows = webDriver.getWindowHandles().toArray(new String[0]);
        webDriver.switchTo().window(windows[1]);
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.urlToBe("https://en.ekfgroup.com/"));
    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
