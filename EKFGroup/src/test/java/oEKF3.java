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

public class oEKF3 {

    private WebDriver webDriver;

    @BeforeTest
    public void prep() {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void getCompanyPage() {
        webDriver.get("https://ekfgroup.com/about/career");
        new WebDriverWait(webDriver,10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("h2.mb-0")));
    }

    @Test
    public void checkLink() {
        WebElement[] elements = webDriver.findElements(
                By.cssSelector(".career-accordion .career-collapse-toggle")).toArray(new WebElement[0]);
        for (WebElement element : elements) {
            element.click();
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions
                            .elementToBeClickable(
                                    By.cssSelector(".career-accordion .collapse.show .pt-32:first-of-type")));
            element.click();
        }
    }

    @AfterTest
    public void quitBrowser() {
        webDriver.quit();
    }

}
