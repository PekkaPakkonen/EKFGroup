import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class cartEKF2 {

    private WebDriver webDriver;
    private mainPage mainP;

    @BeforeTest
    public void prep() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(new URL("http://172.17.0.2:4444"), caps);
        mainP = new mainPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/cart");
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
        webDriver.findElement(By.cssSelector(".row .px-4 .form-control[placeholder=\"Артикул\"]"))
                .sendKeys("mcb6-1-10C-av");
        webDriver.findElement(By.cssSelector(".row .px-4.col-md-auto")).click();
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".col-md-2.col-4 .img-fluid")));
    }

    @Test
    public void click() throws Exception {
        int value = Integer.parseInt(
                webDriver.findElement(By.cssSelector(".flex-grow-1.align-self-center")).getAttribute("aria-valuenow"));
        webDriver.findElement(By.cssSelector(".btn.border-0[aria-keyshortcuts=\"ArrowUp\"]")).click();

        int newValue = Integer.parseInt(
                webDriver.findElement(By.cssSelector(".flex-grow-1.align-self-center")).getAttribute("aria-valuenow"));
        Assert.assertEquals(value,newValue-1);
        webDriver.findElement(By.cssSelector(".btn.border-0[aria-keyshortcuts=\"ArrowDown\"]")).click();

        newValue = Integer.parseInt(
                webDriver.findElement(By.cssSelector(".flex-grow-1.align-self-center")).getAttribute("aria-valuenow"));

        Thread.sleep(300);
        Assert.assertEquals(value, newValue);

        webDriver.findElement(By.cssSelector(".text-center.d-none .btn")).click();

        try {
            new WebDriverWait(webDriver, 2)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".col-md-2.col-4 .img-fluid")));
        } catch (TimeoutException e) {
            System.out.println("Element disappeared");
        }

    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }

}
