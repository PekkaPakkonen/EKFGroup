import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class mToolThermalResistance {

    private WebDriver driver;

    private By cableCrossSectionBtn = By.cssSelector(".form-group:first-of-type .col-sm-2 .form-control");
    private By currentMaxBtn = By.cssSelector(".form-group:nth-of-type(2) .col-sm-2 .form-control");

    private By groundTNBtn = By.cssSelector(".form-group:nth-of-type(3) .col-sm-2 .btn:first-child");


    private By groundTTBtn = By.cssSelector(".form-group:nth-of-type(3) .col-sm-2 .btn:nth-child(2)");

    private By voltageField = By.cssSelector(".form-group:nth-of-type(4) .col-sm-2 .form-control");
    private By shutDownTimeField = By.cssSelector(".form-group:nth-of-type(5) .col-sm-2 .form-control");

    private By saveToPdfBtn = By.cssSelector(".col-sm-offset-4 .btn");

    private By currentAllowed = By.cssSelector(".form-group:nth-of-type(6) .form-control-static");
    private By currentThermal = By.cssSelector(".form-group:nth-of-type(67) .form-control-static");

    public mToolThermalResistance(WebDriver driver) {
        this.driver = driver;
    }

    public By getGroundTNBtn() {
        return groundTNBtn;
    }

    public By getGroundTTBtn() {
        return groundTTBtn;
    }

    public String getTextCurrentAllowed() {
        return driver.findElement(currentAllowed).getText();
    }

    public String getTextCurrentThermal() {
        return driver.findElement(currentThermal).getText();
    }

    public void cableCrossSectionBtnSelect(int value) {
        Select dropdown = new Select(driver.findElement(cableCrossSectionBtn));
        dropdown.selectByIndex(value);
    }

    public void currentMaxBtnClick() {
       driver.findElement(currentMaxBtn).click();
    }

    public void groundTNBtnClick() {
       driver.findElement(groundTNBtn).click();
    }

    public void groundTTBtnClick() {
       driver.findElement(groundTTBtn).click();
    }

    public void voltageFieldInput(String str) {
        driver.findElement(voltageField).clear();
        driver.findElement(voltageField).sendKeys(str);

    }

    public void shutDownTimeFieldInput(String str) {
        driver.findElement(shutDownTimeField).clear();
        driver.findElement(shutDownTimeField).sendKeys(str);
    }

    public void saveToPdfBtnClick() {
       driver.findElement(saveToPdfBtn).click();
    }

}