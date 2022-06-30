import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;

import java.util.ArrayList;

public class prEKF3 {

    private WebDriver webDriver;
    private mainPage mainP;
    private JavascriptExecutor js;
    private categoryPage catPage;
    private ArrayList<String> tabs;

    @BeforeTest
    public void prep() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        mainP = new mainPage(webDriver);
        catPage = new categoryPage(webDriver);
        js = (JavascriptExecutor) webDriver;
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/");
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(mainP.getItemsBtn()));
    }


    @Test
    public void clickTest() throws Exception {
        mainP.clickItemsBtn();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(mainP.getBigItemHeader()));
        for(int i = 1; i < mainP.getAllItemsButtons().length; i++) {
            try {
                mainP.moveMouseToGroupHeader(mainP.getAllItemsButtons()[i]);
            } catch (MoveTargetOutOfBoundsException e) {
                js.executeScript("window.scrollBy(0,200)");
                mainP.moveMouseToGroupHeader(mainP.getAllItemsButtons()[i]);
            }
            Thread.sleep(600);
            new Actions(webDriver).keyDown(Keys.CONTROL).click(webDriver.findElement(mainP.getBigItemHeader()))
                    .keyUp(Keys.CONTROL).build().perform();
            tabs = new ArrayList<String>(webDriver.getWindowHandles());
            webDriver.switchTo().window(tabs.get(1));
            try {
                new WebDriverWait(webDriver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(catPage.getLandingPageLink()));
                new Actions(webDriver).keyDown(Keys.CONTROL).click(webDriver.findElement(catPage.getLandingPageLink()))
                        .keyUp(Keys.CONTROL).build().perform();
                tabs = new ArrayList<String>(webDriver.getWindowHandles());
                webDriver.switchTo().window(tabs.get(2));
                new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(
                        webDriver -> ((JavascriptExecutor) webDriver)
                                .executeScript("return document.readyState").equals("complete"));
                webDriver.close();
                webDriver.switchTo().window(tabs.get(1));
                webDriver.close();
                webDriver.switchTo().window(tabs.get(0));
            } catch (Exception e) {
                System.out.println("This page doesn't have landing page");
                webDriver.close();
                webDriver.switchTo().window(tabs.get(0));
            }

            mainP.clickItemsBtn();
        }
    }

    @AfterTest
    public void stopBrowser() {
        System.out.println("Test completed!");
        webDriver.quit();
    }
}
