import org.openqa.selenium.WebDriver;
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

import java.awt.*;
import java.awt.event.KeyEvent;

public class prEKF2 {

    private WebDriver webDriver;
    private mainPage mainP;
    private String mainWindow;

    @BeforeTest
    public void prep() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        mainP = new mainPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/");
        mainWindow= webDriver.getWindowHandle();
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(mainP.getItemsBtn()));
    }

    @Test
    public void clickTest() throws Exception {
        mainP.clickItemsBtn();

        new WebDriverWait(webDriver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(mainP.getBigItemHeader()));
        mainP.clickCatalogDownload();
        webDriver.switchTo().window(webDriver.getWindowHandles().toArray(new String[0])[1]);
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe("https://api.ekfgroup.com/storage/mc-30-2021.pdf"));
        webDriver.close();
        webDriver.switchTo().window(mainWindow);

        mainP.clickPriceListDownload();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        mainP.clickEtimLink();
        webDriver.switchTo().window(webDriver.getWindowHandles().toArray(new String[0])[1]);
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe("https://etim.ekfgroup.com/"));
        webDriver.close();
        webDriver.switchTo().window(mainWindow);

    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }

}
