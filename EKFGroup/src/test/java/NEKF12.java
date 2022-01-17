import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF12 {

    //.mb-12 .lh-120:first-child .text-reset

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
        webDriver.findElement(By.cssSelector(".mb-12 .lh-120:first-child .text-reset")).click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.urlContains("user-agreement"));
        webDriver.navigate().back();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(By
                        .cssSelector(".mb-12 .lh-120:first-child .text-reset")));
        webDriver.findElement(By.cssSelector(".mb-12 .lh-120:nth-child(2) .text-reset")).click();
        String[] windows = webDriver.getWindowHandles().toArray(new String[0]);
        webDriver.switchTo().window(windows[1]);
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.urlContains("https://www.e-disclosure.ru"));
    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
