import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF3 {

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
    public void click() throws Exception {

        webDriver.findElement(mainP.getSupportBtn()).click();
        WebElement[] droprightMenus = webDriver
                .findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"] .dropdown.dropright"))
                .toArray(new WebElement[0]);

        for(int i = 0; i < droprightMenus.length; i++) {
            mainP.moveMouseToGroupHeader(droprightMenus[i]);
            WebElement[] showElements = webDriver
                    .findElements(By.cssSelector(".dropdown.dropright.show [role=\"presentation\"]"))
                    .toArray(new WebElement[0]);
            for (int j = 0; j < showElements.length; j++) {
                mainP.moveMouseToGroupHeader(showElements[j]);
                showElements[j].click();
                Thread.sleep(5000);
                webDriver.navigate().back();
                Thread.sleep(5000);
                webDriver.findElement(mainP.getSupportBtn()).click();
                Thread.sleep(2000);
                mainP.moveMouseToGroupHeader(droprightMenus[i]);
            }

//        }
        }
    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }
}
