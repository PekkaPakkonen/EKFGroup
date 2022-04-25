import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class oEKF2 {

    private WebDriver webDriver;

    @BeforeTest
    public void prep() {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void getCompanyPage() {
        webDriver.get("https://ekfgroup.com/about/production");
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("h1.text-lg-center")));
    }

    @Test
    public void checkLink() {
        webDriver.findElement(By.cssSelector(".row.mb-n16 .btn")).click();
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions
                        .urlToBe("https://ekfgroup.com/about/esg"));
    }

    @AfterTest
    public void quitBrowser() {
        webDriver.quit();
    }

}
