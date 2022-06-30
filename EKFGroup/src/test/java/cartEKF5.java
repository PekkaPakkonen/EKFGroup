import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.net.MalformedURLException;

public class cartEKF5 {


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
        String[] values = {"Vasya", "88005553535", "vasya@mail.ru", "Москва"};
        String comment = "Тестовый заказ, оформлять не нужно";

        //push "Order from distributor
        webDriver.findElement(By.cssSelector(".btn-xl-lg.btn-primary")).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://ekfgroup.com/cart/checkout"));
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mb-8.col-lg-6")));
        webDriver.findElement(By.cssSelector(".btn-group-tabs .btn.btn-gray-200:not(.active)")).click();
        webDriver.findElement(By.cssSelector(".mb-8.col-12 .form-autocomplete .form-control")).sendKeys("616");
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .cssSelector(".dropdown.show .w-100 [role=\"presentation\"]:first-child")));
        webDriver.findElement(By.cssSelector(".dropdown.show .w-100 [role=\"presentation\"]:first-child")).click();
        WebElement[] elements = webDriver.findElements(By.cssSelector(".mb-8.col-lg-6 .form-control"))
                .toArray(new WebElement[0]);

        for(int i = 0; i < elements.length - 1; i++) {
            elements[i].sendKeys(values[i]);
            webDriver.findElement(By.cssSelector(".btn.btn-lg-lg")).click();
            Assert.assertEquals(webDriver.getCurrentUrl(), "https://ekfgroup.com/cart/checkout");
        }

        elements[3].sendKeys(values[3]);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown-menu.w-100.show [role=\"presentation\"]")));
        webDriver.findElement(By.cssSelector(".dropdown-menu.w-100.show [role=\"presentation\"]")).click();

        webDriver.findElement(By.cssSelector(".form-control[rows=\"2\"]")).sendKeys(comment);
//        webDriver.findElement(By.cssSelector(".btn.btn-lg-lg")).click();
//        new WebDriverWait(webDriver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.urlToBe("https://ekfgroup.com/cart/order-confirm"));

    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }

}
