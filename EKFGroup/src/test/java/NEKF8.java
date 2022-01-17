import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF8 {

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
        String[] links = {"cirkulyaciya-v-konture",
                "udalennoe-upravlenie-i-monitoring",
                "osveshhenie",
                "molniezashhita-zhily-i-obshhestvenny-zdanij",
                "podderzhanie-davleniya",
                "molniezashhita-promyshlenny-obektov",
                "ventilyaciya",
                "zapolnenie-i-osushenie-rezervuarov",
                "avr"};
        WebElement[] elements = webDriver
                .findElements(By.cssSelector(".row .mb-24:nth-child(2) .footer-links-collapse li .footer-links-item"))
                .toArray(new WebElement[0]);
        for (int i = 0; i < elements.length; i++) {
            elements[i].click();
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.urlContains(links[i]));
            webDriver.navigate().back();
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.urlToBe("https://ekfgroup.com/"));
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.elementToBeClickable(elements[i]));
        }
    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
