import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.time.Duration;

public class calcEKF2 {

    private WebDriver webDriver;
    private masterCostPage masterCostP;

    @BeforeTest
    public void prep() throws MalformedURLException {
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions opts = new FirefoxOptions();
        profile.setPreference("browser.download.folderList",2);
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("browser.download.dir","D:\\Downloads");
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
    public void uploadArticleTest() throws Exception {
        masterCostP.searchTextFieldInput("MVA20-1-D05-C");
        masterCostP.priceTextFieldInput("400");
        masterCostP.findAnalogueBtnClick();
        masterCostP.waitForBTN(masterCostP.getTableEkfArticle());
        Assert.assertFalse(masterCostP.getTableEkfArticleText().isEmpty());
        Assert.assertTrue(masterCostP.getPriceDiff());
        masterCostP.waitForBTN(masterCostP.getDownloadExcelSheet());
        masterCostP.saveAnalogueSheetBtnClick();
        Thread.sleep(2000);
        File dir = new File("D:\\Downloads\\");
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains("ekf-master-cost");
            }
        });
        Assert.assertTrue(files.length > 0);
        masterCostP.deleteArticleBtn();
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOf(webDriver.findElement(masterCostP.getTableEkfArticle())));
        } catch (NoSuchElementException e) {
            System.out.println("element is invisible");
        }
    }

    @Test
    public void uploadWrongArticleTest() {
        masterCostP.searchTextFieldInput("MVA20-1-D07-C");
        masterCostP.findAnalogueBtnClick();
        masterCostP.waitForBTN(masterCostP.getTableEkfArticle());
        Assert.assertEquals(masterCostP.getTableEkfArticleText(), "Аналог не найден");
        masterCostP.deleteArticleBtn();
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.visibilityOf(webDriver.findElement(masterCostP.getTableEkfArticle())));
        } catch (NoSuchElementException e) {
            System.out.println("element is invisible");
        }
    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }


}
