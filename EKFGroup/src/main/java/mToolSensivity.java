import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolSensivity {

    private WebDriver driver;
//.form-group:first-of-type .col-sm-2 .form-control
    private By TransformCoeffBtn = By.cssSelector(".form-group:first-of-type .col-sm-2 .form-control");
    private By powerCoeffBtn = By.cssSelector(".form-group:nth-of-type(2) .col-sm-2 .form-control");
    private By powerField = By.cssSelector(".form-group:nth-of-type(3) .col-sm-2 .form-control");
    private By currentMaxField = By.cssSelector(".form-group:nth-of-type(4) .col-sm-2 .form-control");
    private By powerMinField = By.cssSelector(".form-group:nth-of-type(5) .col-sm-2 .form-control");
    private By currentMinField = By.cssSelector(".form-group:nth-of-type(6) .col-sm-2 .form-control");

    private By saveToPdfBtn = By.cssSelector(".col-sm-offset-4 .btn");


    public mToolSensivity(WebDriver driver) {
        this.driver = driver;
    }

    public void TransformCoeffBtnClick() {
       driver.findElement(TransformCoeffBtn).click();
    }

    public void powerCoeffBtnClick() {
       driver.findElement(powerCoeffBtn).click();
    }

    public void saveToPdfBtnClick() {
       driver.findElement(saveToPdfBtn).click();
    }

    public void powerFieldInput(String str) {
        driver.findElement(powerField).sendKeys(str);
    }

    public void currentMaxFieldInput(String str) {
        driver.findElement(currentMaxField).sendKeys(str);
    }

    public void powerMinFieldInput(String str) {
        driver.findElement(powerMinField).sendKeys(str);
    }

    public void currentMinFieldInput(String str) {
        driver.findElement(currentMinField).sendKeys(str);
    }

}