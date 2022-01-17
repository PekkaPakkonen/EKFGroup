import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NEKF3 {

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
    public void click() throws Exception {
        boolean flag = false;
        webDriver.findElement(mainP.getSupportBtn()).click();
        WebElement[] droprightMenus = webDriver
                .findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"] .dropdown.dropright"))
                .toArray(new WebElement[0]);
        for(int i = 0; i < droprightMenus.length; i++) {
            mainP.moveMouseToGroupHeader(droprightMenus[i]);
            new WebDriverWait(webDriver, 3)
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By
                                    .cssSelector(".dropdown.dropright.show [role=\"presentation\"]")));
            WebElement[] showElements = webDriver
                    .findElements(By.cssSelector(".dropdown.dropright.show [role=\"presentation\"]"))
                    .toArray(new WebElement[0]);
            for(int j = 0; j < showElements.length; j++) {
                showElements[j].click();
                Thread.sleep(2000);
                webDriver.navigate().back();
                new WebDriverWait(webDriver, 10)
                        .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
                webDriver.findElement(mainP.getSupportBtn()).click();
                droprightMenus = webDriver
                        .findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"] .dropdown.dropright"))
                        .toArray(new WebElement[0]);
                mainP.moveMouseToGroupHeader(droprightMenus[i]);
                new WebDriverWait(webDriver, 3)
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By
                                        .cssSelector(".dropdown.dropright.show [role=\"presentation\"]")));
//                String line = showElements[j].getText();
//                System.out.println(line);
//                showElements[j].click();
//                new WebDriverWait(webDriver, 5)
//                        .until(ExpectedConditions.visibilityOf(webDriver.findElement(By.cssSelector(".pb-lg-64 .h2"))));
//                System.out.println(webDriver.findElement(By.cssSelector(".pb-lg-64 .h2")).getText());
//                webDriver.findElement(mainP.getSupportBtn()).click();
//                droprightMenus = webDriver
//                        .findElements(By.cssSelector(".dropdown-menu.show [role=\"presentation\"] .dropdown.dropright"))
//                        .toArray(new WebElement[0]);
//                mainP.moveMouseToGroupHeader(droprightMenus[i]);
            }
            //showElements[i].click();
        }

//        for(int i = 0; i < droprightMenus.length; i++) {
//            webDriver.findElement(droprightMenus[i]).click();
//            new WebDriverWait(webDriver, 10)
//                    .until(ExpectedConditions.visibilityOfAllElements(droprightMenus[i]));
//            webDriver.findElement(headers[i]).click();
//        }
    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }
}
