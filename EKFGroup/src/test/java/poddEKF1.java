import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class poddEKF1 {

    private WebDriver webDriver;
    private mainPage mainP;
    private JavascriptExecutor js;

    @BeforeTest
    public void prep() {
        webDriver = new FirefoxDriver();
        mainP = new mainPage(webDriver);
        js = (JavascriptExecutor) webDriver;
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.elementToBeClickable(mainP.getItemsBtn()));
        Actions action = new Actions(webDriver);

    }
}
