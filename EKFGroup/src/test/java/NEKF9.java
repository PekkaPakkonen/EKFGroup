import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF9 {

    //Change location doesn't work, wait for the functional to be implemented.

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
    public void click() {
        String cityName = webDriver.findElement(By.cssSelector(".header-location-select .caption")).getText();
        String newCityName;
        webDriver.findElement(By.cssSelector(".header-location-select .caption")).click();
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".modal-body .list-unstyled .mb-8:nth-child(2)")));
        webDriver.findElement(By.cssSelector(".modal-body .list-unstyled .mb-8:nth-child(2) .text-reset")).click();
        newCityName = webDriver.findElement(By.cssSelector(".header-location-select .caption")).getText();
        Assert.assertNotEquals(cityName,newCityName);
        webDriver.navigate().refresh();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
        newCityName = webDriver.findElement(By.cssSelector(".header-location-select .caption")).getText();
        Assert.assertNotEquals(cityName, newCityName);
    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
