import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF4 {

    private WebDriver webDriver;
    private mainPage mainP;

    @BeforeTest
    public void prep() {
        webDriver = new FirefoxDriver();
        mainP = new mainPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/");
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mainP.getCalculatorsBtn()));
    }

    @Test
    public void click() {

        webDriver.findElement(mainP.getCalculatorsBtn()).click();
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown-menu.show")));

        WebElement[] menus = webDriver
                .findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"]"))
                .toArray(new WebElement[0]);

        for(WebElement menu: menus) {
            menu.click();
            new WebDriverWait(webDriver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".h2.d-flex")));
            webDriver.navigate().back();
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(mainP.getCalculatorsBtn()));
            webDriver.findElement(mainP.getCalculatorsBtn()).click();
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown-menu.show")));
        }

    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }
}
