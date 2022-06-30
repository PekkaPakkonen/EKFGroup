import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolCableTray {

    private WebDriver driver;

    private By heightCableBtn = By.cssSelector(".panel:first-child .col-sm-4:first-child .form-control");
    private By widthCableBtn = By.cssSelector(".panel:first-child .col-sm-4:nth-child(2) .form-control");

    private By closeCableBtn = By.cssSelector(".panel .btn-danger");

    private By cableTypeBtn = By.cssSelector(".panel:nth-child(2) .form-group:first-child .col-sm-4");
    private By cableCrossSectionBtn = By.cssSelector(".panel:nth-child(2) .form-group:nth-child(2) .col-sm-4");
    private By lineNumberField = By.cssSelector(".panel:nth-child(2) .form-group:nth-child(3) .col-sm-4");

    private By addCableBtn = By.cssSelector(".btn-toolbar .btn-danger");
    private By downloadBtn = By.cssSelector(".btn-toolbar .btn-default");

    public mToolCableTray(WebDriver driver) {
        this.driver = driver;
    }


    public void heightCableBtn() {
       driver.findElement(heightCableBtn).click();
    }

    public void widthCableBtnClick() {
       driver.findElement(widthCableBtn).click();
    }

    public void cableTypeBtnClick() {
       driver.findElement(cableTypeBtn).click();
    }

    public void cableCrossSectionBtnClick() {
       driver.findElement(cableCrossSectionBtn).click();
    }

    public void closeCableBtnClick() {
       driver.findElement(closeCableBtn).click();
    }

    public void addCableBtnClick() {
       driver.findElement(addCableBtn).click();
    }

    public void downloadBtnClick() {
       driver.findElement(downloadBtn).click();
    }

    public void lineNumberFieldInput(String str) {
        driver.findElement(lineNumberField).sendKeys(str);
    }




}