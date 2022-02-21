import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class NEKF3 {

    private WebDriver webDriver;
    private mainPage mainP;

    @BeforeSuite
    public void preps() {
        webDriver = new FirefoxDriver();
        mainP = new mainPage(webDriver);
        webDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void openMainPage() {
        webDriver.get("https://ekfgroup.com/");
        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
    }

    @Test
    public void clickDropdownMenus() {

         String[] webpageNames = {"pos", "presentations", "video", "api", "csv", "bitrix", "feedback",
         "project", "report", "question"};
         int counter = 0;

        webDriver.findElement(mainP.getSupportBtn()).click();
        WebElement[] droprightMenus = webDriver
                .findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"] .dropdown.dropright"))
                .toArray(new WebElement[0]);

        for (WebElement droprightMenu : droprightMenus) {
            mainP.moveMouseToGroupHeader(droprightMenu);
            WebElement[] showElements = webDriver
                    .findElements(By.cssSelector(".dropdown.dropright.show [role=\"presentation\"]"))
                    .toArray(new WebElement[0]);
            for (WebElement showElement : showElements) {
                mainP.moveMouseToGroupHeader(showElement);
                showElement.click();
                new WebDriverWait(webDriver, 5)
                        .until(ExpectedConditions.urlContains(webpageNames[counter]));
                counter++;
                webDriver.navigate().back();
                new WebDriverWait(webDriver, 10)
                        .until(ExpectedConditions.presenceOfElementLocated(mainP.getSupportBtn()));
                webDriver.findElement(mainP.getSupportBtn()).click();
                new WebDriverWait(webDriver, 10)
                        .until(ExpectedConditions.elementToBeClickable(droprightMenu));
                mainP.moveMouseToGroupHeader(droprightMenu);
            }

        }
    }

    @Test
    public void clickMenus() {

        String[] webpageNames = {"libraries", "calculators", "software", "epro", "estimates", "documentation",
        "warranty"};

        webDriver.findElement(mainP.getSupportBtn()).click();
        WebElement[] droprightMenus = webDriver
                .findElements(By.cssSelector(".dropdown-menu.show > [role=\"presentation\"] > a"))
                .toArray(new WebElement[0]);

        for (int i = 0; i < droprightMenus.length; i++) {
            droprightMenus[i].click();
            new WebDriverWait(webDriver, 5)
                    .until(ExpectedConditions.urlContains(webpageNames[i]));
            webDriver.navigate().back();
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(mainP.getSupportBtn()));
            webDriver.findElement(mainP.getSupportBtn()).click();
            new WebDriverWait(webDriver, 10)
                    .until(ExpectedConditions.elementToBeClickable(droprightMenus[i]));
        }
    }

    @AfterSuite
    public void stopBrowser() {
        webDriver.quit();
    }
}
