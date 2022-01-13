import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF6 {

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

        String selector = ".ml-auto.header-menu-secondary .nav-item:nth-child(";
        String[] links = {"ims3.ekf.su", "univer.ekfgroup.com", "electrobaza.ru","old.ekfgroup.com"};
        for(int i = 1; i <= 3; i++) {
            webDriver.findElement(By.cssSelector(selector + i + ")")).click();
            webDriver.switchTo().window(webDriver.getWindowHandles().toArray(new String[0])[1]);
            new WebDriverWait(webDriver, 5).until(ExpectedConditions.urlContains(links[i-1]));
            webDriver.close();
            webDriver.switchTo().window(webDriver.getWindowHandles().toArray(new String[0])[0]);
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
        }
        webDriver.findElement(By.cssSelector(selector + 4 + ")")).click();
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.urlContains(links[3]));
       // "old.ekfgroup.com"

    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
