import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF7 {

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

        String[] links = {"feedback", "project", "report","question"};
        webDriver.findElement(By.cssSelector(".header-dropdowns .dropdown:first-child .btn")).click();
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown-menu.show")));
        WebElement[] elements = webDriver.findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"]"))
                .toArray(new WebElement[0]);
        for(int i = 0; i < elements.length; i++) {
            elements[i].click();
            new WebDriverWait(webDriver, 5)
                    .until(ExpectedConditions.urlContains(links[i]));
            webDriver.get("https://ekfgroup.com/");
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
            webDriver.findElement(By.cssSelector(".header-dropdowns .dropdown:first-child .btn")).click();
            new WebDriverWait(webDriver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".dropdown-menu.show")));
            elements = webDriver.findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"]"))
                    .toArray(new WebElement[0]);
        }
    }

    @AfterTest
    public void stop() {
        webDriver.quit();
    }
}
