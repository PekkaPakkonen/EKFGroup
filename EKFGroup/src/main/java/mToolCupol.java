import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolCupol {

    private WebDriver driver;

    private By buildingLengthField = By.cssSelector(".form-group:first-of-type .col-sm-2 .form-control");
    private By buildingWidthField = By.cssSelector(".form-group:nth-of-type(2) .col-sm-2 .form-control");
    private By buildingHeightField = By.cssSelector(".form-group:nth-of-type(3) .col-sm-2 .form-control");

    private By protectionLevelBtn = By.cssSelector(".form-group:nth-of-type(4) .col-sm-6 .form-control");
    private By soilTypeBtn = By.cssSelector(".form-group:nth-of-type(5) .col-sm-6 .form-control");
    private By climaticZoneBtn = By.cssSelector(".form-group:nth-of-type(6) .col-sm-6 .form-control");

    private By addToCartBtn = By.cssSelector(".panel .btn-danger");
    private By downloadBtn = By.cssSelector(".panel .btn-default");

    public mToolCupol(WebDriver driver) {
        this.driver = driver;
    }


    public void buildingLengthFieldInput(String str) {
        driver.findElement(buildingLengthField).sendKeys(str);
    }

    public void buildingWidthFieldInput(String str) {
        driver.findElement(buildingWidthField).sendKeys(str);
    }

    public void buildingHeightFieldInput(String str) {
        driver.findElement(buildingHeightField).sendKeys(str);
    }

    public void protectionLevelBtnClick() {
       driver.findElement(protectionLevelBtn).click();
    }

    public void soilTypeBtnClick() {
       driver.findElement(soilTypeBtn).click();
    }

    public void climaticZoneBtnClick() {
       driver.findElement(climaticZoneBtn).click();
    }

    public void addToCartBtnClick() {
       driver.findElement(addToCartBtn).click();
    }

    public void downloadBtnClick() {
       driver.findElement(downloadBtn).click();
    }

}