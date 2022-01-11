import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class prEKF1 {

    private WebDriver webDriver;
    private mainPage mainP;
    private JavascriptExecutor js;

    @BeforeTest
    public void prep() {
        webDriver = new FirefoxDriver();
        mainP = new mainPage(webDriver);
        js = (JavascriptExecutor) webDriver;
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(mainP.getItemsBtn()));
        Actions action = new Actions(webDriver);

    }


    @Test
    public void clickTest() throws Exception {
        mainP.clickItemsBtn();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mainP.getBigItemHeader()));
        for(int i = 0; i < mainP.getAllItemsButtons().length; i++) {
            try {
                mainP.moveMouseToGroupHeader(mainP.getAllItemsButtons()[i]);
            } catch (MoveTargetOutOfBoundsException e) {
                js.executeScript("window.scrollBy(0,100)");
                mainP.moveMouseToGroupHeader(mainP.getAllItemsButtons()[i]);
            }
            Thread.sleep(600);
            mainP.moveMouseToGroupHeader(webDriver.findElement(mainP.getBigItemHeader()));
        }

        js.executeScript("window.scrollTo(0,0)");
        new WebDriverWait(webDriver,1)
                .until(ExpectedConditions.elementToBeClickable(mainP.getCloseButton()));
        mainP.clickCloseButton();
        try {
            mainP.clickCloseButton();
        } catch (ElementNotInteractableException e) {
            System.out.println("Menu has been closed");
        }

        mainP.clickItemsBtn();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions
                .elementToBeClickable(mainP.getBigItemHeader()));
        mainP.clickItemsBtn();
        try {
            mainP.clickCloseButton();
        } catch (ElementNotInteractableException e) {
            System.out.println("Menu has been closed");
        }
    }

    @AfterTest
    public void stopBrowser() {
        System.out.println("Test completed!");
        webDriver.quit();
    }
}
