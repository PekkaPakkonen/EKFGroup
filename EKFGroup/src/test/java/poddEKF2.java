import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class poddEKF2 {

    private WebDriver webDriver;
    private supportPresentationsPage presentationsPage;

    @BeforeTest
    public void prep() {
        webDriver = new FirefoxDriver();
        presentationsPage = new supportPresentationsPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/support/presentations");
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(presentationsPage.getPresentationsBtn()));
    }

    @Test
    public void click() {
        WebElement[] buttons = presentationsPage.getAllPresentationsBtn();
        for(int i = 0; i < buttons.length; i++) {
            if(i > 0) {
                buttons[i].click();
            }
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.elementToBeClickable(presentationsPage.getOpenTabPresentations()));
            WebElement[] presentations = presentationsPage.getAllOpenTabPresentations();

            for(WebElement presentation : presentations) {
                String link = presentation.getAttribute("href");
                presentation.click();
                String[] windows = webDriver.getWindowHandles().toArray(new String[0]);
                webDriver.switchTo().window(windows[1]);
                new WebDriverWait(webDriver, 10)
                        .until(ExpectedConditions.urlToBe(link));
                webDriver.close();
                webDriver.switchTo().window(windows[0]);
            }
        }
    }
}
