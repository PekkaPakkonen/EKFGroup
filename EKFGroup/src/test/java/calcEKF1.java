import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class calcEKF1 {

    private WebDriver webDriver;
    private masterCostPage masterCostP;

    @BeforeTest
    public void prep() {
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions opts = new FirefoxOptions();
        profile.setPreference("browser.download.folderList",2);
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("browser.download.dir","D:\\Downloads");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/xlsb");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/xlsx");
        opts.setProfile(profile);
        webDriver = new FirefoxDriver(opts);
        masterCostP = new masterCostPage(webDriver);
        webDriver.manage().window().maximize();

    }

    @BeforeMethod
    public void refreshPage(){
        webDriver.get("https://ekfgroup.com/calculators/mastercost");
        masterCostP.waitForBTN(masterCostP.getDownloadBtn());
    }

    @Test
    public void checkSaveFile() {
        masterCostP.downloadBtnClick();
        File file = new File("D:\\Downloads\\master-cost.xlsb");
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.isFile());
        file.delete();
    }

    @Test
    public void checkSaveSheet() {
        masterCostP.UploadExcelTabClick();
        masterCostP.waitForBTN(masterCostP.getDownloadExcelSheet());
        masterCostP.downloadExcelSheetClick();
        File file = new File("D:\\Downloads\\mastercost-template.xlsx");
        Assert.assertTrue(file.exists());
        Assert.assertTrue(file.isFile());
        file.delete();
    }

    @Test
    public void checkTabs() {
        masterCostP.UploadExcelTabClick();
        masterCostP.waitForBTN(masterCostP.getDownloadExcelSheet());

        masterCostP.manualSearchTabClick();
        masterCostP.waitForBTN(masterCostP.getDownloadBtn());

        masterCostP.searchByListTabClick();
        masterCostP.waitForBTN(masterCostP.getSearchTextField());
    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }
}
