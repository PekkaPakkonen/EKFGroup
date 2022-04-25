import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class oEKF1 {


    private WebDriver webDriver;

    @BeforeTest
    public void prep() {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void getCompanyPage() {
        webDriver.get("https://ekfgroup.com/about/company");
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".container h1.text-lg-center.text-primary")));
    }


    @Test
    public void checkPage() {
        webDriver.findElement(By.cssSelector(".mb-32.youtube-embed .embed-thumbnail")).click();
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions
                        .invisibilityOf(webDriver.findElement(By.cssSelector(".mb-32.youtube-embed .embed-thumbnail"))));
    }

    @Test
    public void checkCatalogLink() {
        webDriver.findElement(By.cssSelector(".section-about.container .row:first-child .btn")).click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions
                .urlToBe("https://ekfgroup.com/catalog"));
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://ekfgroup.com/catalog");
    }

    @Test
    public void checkSolutionsLink() {
        webDriver.findElement(By.cssSelector(".section-about.container .row:nth-child(2) .btn")).click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions
                .urlToBe("https://ekfgroup.com/solutions"));
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://ekfgroup.com/solutions");
    }

    @Test
    public void checkEnglishVersionLink() {
        webDriver.findElement(By.cssSelector(".section-about.container .row:nth-child(3) .btn")).click();
        String[] windows = webDriver.getWindowHandles().toArray(new String[0]);
        webDriver.switchTo().window(windows[1]);
        new WebDriverWait(webDriver, 10).until(ExpectedConditions
                .urlToBe("https://en.ekfgroup.com/"));
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://en.ekfgroup.com/");
    }

    @Test
    public void checkProductionLink() {
        webDriver.findElement(By.cssSelector(".section-about.container .row:nth-child(4) .btn")).click();
        new WebDriverWait(webDriver, 10).until(ExpectedConditions
                .urlToBe("https://ekfgroup.com/about/production"));
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://ekfgroup.com/about/production");
    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }

}
