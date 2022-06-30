import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectModel {

    private WebDriver driver;

    public PageObjectModel(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void webWait(By element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
