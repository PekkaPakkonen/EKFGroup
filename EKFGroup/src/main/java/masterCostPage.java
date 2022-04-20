import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class masterCostPage {

    private final WebDriver driver;

    private By downloadBtn = By.cssSelector(".ml-lg-auto .btn-outline-primary");
    private By downloadExcelSheet = By.cssSelector(".row.mx-n4 .mb-xl-0:first-child .btn");

    private By manualSearchTab = By.cssSelector(".mastercost-wrapper .nav-item:nth-child(1)");
    private By uploadExcelTab = By.cssSelector(".mastercost-wrapper .nav-item:nth-child(2)");
    private By searchByListTab = By.cssSelector(".mastercost-wrapper .nav-item:nth-child(3)");

    private By searchTextField = By.cssSelector(".mb-8.col-xl-9 .form-control");


    public By getDownloadBtn() {
        return downloadBtn;
    }

    public By getDownloadExcelSheet() {
        return downloadExcelSheet;
    }

    public By getSearchTextField() {
        return searchTextField;
    }

    public masterCostPage(WebDriver driver) {
        this.driver = driver;
    }

    public void downloadBtnClick() {
        driver.findElement(downloadBtn).click();
    }

    public void downloadExcelSheetClick() {
        driver.findElement(downloadExcelSheet).click();
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


    public void waitForBTN(By element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(element));
    }

}
