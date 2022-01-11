import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class cartEKF1 {

    private WebDriver webDriver;
    private mainPage mainP;

    @BeforeTest
    public void prep() {

        webDriver = new FirefoxDriver();
        mainP = new mainPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/cart");
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
    }

    @Test
    public void click() {
        String cb = "mcb6-1-10C-av";
        webDriver.findElement(By.cssSelector(".row .px-4 .form-control[placeholder=\"Артикул\"]"))
                .sendKeys(cb);
        webDriver.findElement(By.cssSelector(".row .px-4.col-md-auto")).click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".col-md-2.col-4 .img-fluid")));
        Assert.assertEquals(cb, webDriver.findElement(By.cssSelector(".col-md-2.col-4 .img-fluid")).getAttribute("alt"));
    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }

}
