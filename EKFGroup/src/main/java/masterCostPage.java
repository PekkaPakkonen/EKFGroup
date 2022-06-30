import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.net.MalformedURLException;


public class masterCostPage {

    private final WebDriver driver;

    private By downloadBtn = By.cssSelector(".ml-lg-auto .btn-outline-primary");
    private By deleteArticleBtn = By.cssSelector(".cell-form-control .btn.rounded-pill");
    private By downloadExcelSheetBtn = By.cssSelector(".row.mx-n4 .mb-xl-0:first-child .btn");
    private By saveAnalogueSheetBtn = By.cssSelector(".mx-n4 .ml-lg-auto .btn");

    private By manualSearchTab = By.cssSelector(".mastercost-wrapper .nav-item:nth-child(1)");
    private By uploadExcelTab = By.cssSelector(".mastercost-wrapper .nav-item:nth-child(2)");
    private By searchByListTab = By.cssSelector(".mastercost-wrapper .nav-item:nth-child(3)");

    private By searchTextField = By.cssSelector(".mb-8.col-lg-4 .form-control"); //manual search tab
    private By searchListField = By.cssSelector(".mb-8.col-lg-8 .form-control"); //search by list tab
    private By priceTextField = By.cssSelector(".mb-8.col-lg-2 .form-control");

    private By tableEkfArticle = By.cssSelector("[role=\"rowgroup\"]:not(.thead-light) [aria-colindex=\"4\"]");
    private By tablePrice = By.cssSelector("[role=\"rowgroup\"]:not(.thead-light) [aria-colindex=\"2\"]");
    private By tableEkfPrice = By.cssSelector("[role=\"rowgroup\"]:not(.thead-light) [aria-colindex=\"6\"]");


    public masterCostPage(WebDriver driver) {
        this.driver = driver;
    }


//GETTERS
    public By getDownloadBtn() {
        return downloadBtn;
    }

    public By getDownloadExcelSheet() {
        return downloadExcelSheetBtn;
    }

    public By getSearchTextField() {
        return searchTextField;
    }

    public By getTableEkfArticle() {
        return tableEkfArticle;
    }

    public By getSaveAnalogueSheetBtn() {
        return saveAnalogueSheetBtn;
    }

    public By getSearchListField() {
        return searchListField;
    }

    //BUTTON AND TAB CLICKERS
    public void downloadBtnClick() {
        driver.findElement(downloadBtn).click();
    }

    public void downloadExcelSheetClick() {
        driver.findElement(downloadExcelSheetBtn).click();
    }

    public void UploadExcelTabClick() {
        driver.findElement(uploadExcelTab).click();
    }

    public void manualSearchTabClick() {
        driver.findElement(manualSearchTab).click();
    }

    public void searchByListTabClick() {
        driver.findElement(searchByListTab).click();
    }

    public void findAnalogueBtnClick() {
        //driver.findElement(findAnalogueBtn).click();
    }

    public void deleteArticleBtn() {
        driver.findElement(deleteArticleBtn).click();
    }

    public void saveAnalogueSheetBtnClick() {
        driver.findElement(saveAnalogueSheetBtn).click();
    }

//TEXT FIELD INPUT
    public void searchTextFieldInput (String text) {
        driver.findElement(searchTextField).sendKeys(text);
    }

    public void searchListFieldInput (String text) {
        driver.findElement(searchListField).sendKeys(text);
    }

    public void priceTextFieldInput (String text) {
        driver.findElement(priceTextField).sendKeys(text);
    }



//WAITFOR elements
    public void waitForBTN(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(element));
    }

//OTHER
    public String getTableEkfArticleText() {
        return driver.findElement(tableEkfArticle).getText();
    }

    public Boolean getPriceDiff() {
        double price = Double.parseDouble(driver.findElement(tablePrice)
                .getText().trim().split(" ")[0].replaceAll(",","."));
        double priceEkf = Double.parseDouble(driver.findElement(tableEkfPrice)
                .getText().trim().split(" ")[0].replaceAll(",","."));

        return (price - priceEkf) >=0;
    }
}
