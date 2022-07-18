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

import java.time.Duration;
import java.util.ArrayList;

public class elbkEKF1 {

    private mainPage mainP;
    private WebDriver driver;

    @BeforeTest
    public void link() {
        driver = new FirefoxDriver();
        mainP = new mainPage(driver);
        driver.manage().window().maximize();

    }


    @BeforeMethod
    public void getCompanyPage() {
        driver.get("https://ekfgroup.com/");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(mainP.getItemsBtn()));
    }

    @Test
    public void checkCatalogLinks() throws InterruptedException {
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<String> subCategories = new ArrayList<>();
        mainP.clickItemsBtn();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(mainP.getItemHeader()));
        mainP.moveMouseToGroupHeader(driver.findElement(mainP.getItemHeader()));
        for (WebElement element : mainP.getAllCollapseButton()) {
            element.click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.attributeContains(element, "class","not-collapsed"));
        }

        Thread.sleep(1000);

        for(WebElement element: mainP.getAllSubItemButtons()) {
            categories.add( element.getAttribute("href"));
        }

        for(WebElement element: mainP.getAllSubCategoryHeaders()) {
            subCategories.add( element.getAttribute("href"));
        }


        for(String str: categories) {
            driver.get(str);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".row.flex-nowrap .mb-12 .h2")));
        }

        for(String str: subCategories) {
            driver.get(str);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".row.flex-nowrap .mb-12 .h2")));
        }

    }

    @Test
    public void checkCatalogInteraction() throws InterruptedException {
        mainP.clickItemsBtn();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(mainP.getItemHeader()));

        for(WebElement element: mainP.getAllItemsButtons()) {
            mainP.moveMouseToGroupHeader(element);
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions
                            .textToBePresentInElementLocated(mainP.getBigItemHeader(), element.getText()));
        }

    }



    @AfterTest
    public void stop() {
        driver.quit();
    }


}
