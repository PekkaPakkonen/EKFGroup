import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class oEKF78 {

    private WebDriver webDriver;

    @BeforeTest
    public void prep() {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
    }



    @Test
    public void checkESGLink() {
        webDriver.get("https://ekfgroup.com/about/esg");
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".h2.mb-lg-64")));
        webDriver.findElement(By.cssSelector(".mb-16 .btn-link")).click();
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions
                        .urlToBe("https://ekfgroup.com/about/fair-position"));

    }

    @Test
    public void checkLink() {
        webDriver.get("https://ekfgroup.com/about/contacts");
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("h1.mb-32")));
        WebElement[] elements = webDriver.findElements(
                By.cssSelector(".col-lg-5 .card")).toArray(new WebElement[0]);
        for (WebElement element : elements) {
            element.click();
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions
                            .presenceOfElementLocated(
                                    By.cssSelector(".col-lg-5 .card .collapse.show p")));
            element.click();
        }


    }

    @AfterTest
    public void quitBrowser() {
        webDriver.quit();
    }
}
