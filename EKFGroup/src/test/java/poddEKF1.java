import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class poddEKF1 {

    private WebDriver webDriver;
    private mainPage mainP;
    private supportPosPage suppPP;
    private FirefoxProfile profile;
    @BeforeTest
    public void prep() {
        profile = new FirefoxProfile();
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", " text/plain, application/octet-stream doc xls pdf txt");
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv, text/csv, text/plain,application/octet-stream doc xls pdf txt");
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
        profile.setPreference("pdfjs.disabled", true);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
        webDriver = new FirefoxDriver(capabilities);
        mainP = new mainPage(webDriver);
        suppPP = new supportPosPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/support/pos");
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
    }

    @Test
    public void test() {
        suppPP.clickCataloguesTab();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(suppPP.getFileCard()));
        WebElement[] cardElements = suppPP.getActiveCards();
        for(int i = 0; i < cardElements.length; i++) {
            String link = cardElements[i].getAttribute("href");
            cardElements[i].click();
            String[] windows = webDriver.getWindowHandles().toArray(new String[0]);
            webDriver.switchTo().window(windows[1]);
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.urlToBe(link));
            webDriver.close();
            webDriver.switchTo().window(windows[0]);
        }
    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
