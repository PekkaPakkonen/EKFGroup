import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;



public class cartEKF4 {

    private WebDriver webDriver;
    private mainPage mainP;

    @BeforeTest
    public void prep() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        mainP = new mainPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/cart");
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
        webDriver.findElement(By.cssSelector(".row .px-4 .form-control[placeholder=\"Артикул\"]"))
                .sendKeys("mcb6-1-10C-av");
        webDriver.findElement(By.cssSelector(".row .px-4.col-md-auto")).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".col-md-2.col-4 .img-fluid")));
    }

    @Test
    public void click() throws Exception {
        String str = webDriver.findElement(By.cssSelector(".col-md-2.col-4 .img-fluid")).getAttribute("alt");
        webDriver.findElement(By.cssSelector(".btn.btn-outline-primary.btn-xl-lg")).click();
        Thread.sleep(1000);
        webDriver.switchTo().window(webDriver.getWindowHandles().toArray(new String[0])[1]);
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("electrobaza"));
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".font-size-sm.text-gray-500")));
        boolean flag = webDriver.findElement(By.cssSelector(".font-size-sm.text-gray-500")).getText().contains(str);
        Assert.assertTrue(flag);
    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }

}
