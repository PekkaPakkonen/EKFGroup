import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class mToolMicroclimate {

    private WebDriver driver;

    private By boxHeightField = By.cssSelector(".panel:first-child .form-group:first-child .form-control");
    private By boxWidthField = By.cssSelector(".panel:first-child .form-group:nth-child(2) .form-control");
    private By boxDepthField = By.cssSelector(".panel:first-child .form-group:nth-child(3) .form-control");
    private By boxMaterialSelect = By.cssSelector(".panel:first-child .form-group:nth-child(4) .form-control");
    private By heatTransferCoeffField = By.cssSelector(".panel:first-child .form-group:nth-child(5) .form-control");

    private By installationTypesBtn = By.cssSelector(".panel:first-child .form-group:nth-of-type(6) .row .col-md-4");

    private By heatGenerationField = By.cssSelector(".panel:first-child .form-group:nth-of-type(7) .form-control");
    private By installationEnviromentSelect = By.cssSelector(".panel:first-child .form-group:nth-of-type(8) .form-control");

    private By temperatureMaxField = By.cssSelector(".panel:nth-child(2) .form-group:nth-of-type(1) .form-control");
    private By temperatureMinField = By.cssSelector(".panel:nth-child(2) .form-group:nth-of-type(2) .form-control");
    private By altitudeSelect = By.cssSelector(".panel:nth-child(2) .form-group:nth-of-type(3) .form-control");

    private By operationalTempMaxField = By.cssSelector(".panel:nth-child(3) .form-group:nth-of-type(1) .form-control");
    private By operationalTempMinField = By.cssSelector(".panel:nth-child(3) .form-group:nth-of-type(2) .form-control");

    private By calculateBtn = By.cssSelector(".panel:nth-child(4)  .form-group .btn:nth-child(1)");
    private By cancelBtn = By.cssSelector(".panel:nth-child(4)  .form-group .btn:nth-child(2)");

    public mToolMicroclimate(WebDriver driver) {
        this.driver = driver;
    }

    public void boxHeightFieldInput(String str) {
        driver.findElement(boxHeightField).clear();
        driver.findElement(boxHeightField).sendKeys(str);
    }

    public void boxWidthFieldInput(String str) {
        driver.findElement(boxWidthField).clear();
        driver.findElement(boxWidthField).sendKeys(str);
    }

    public void boxDepthFieldInput(String str) {
        driver.findElement(boxDepthField).clear();
        driver.findElement(boxDepthField).sendKeys(str);
    }

    public void heatTransferCoeffFieldInput(String str) {
        driver.findElement(heatTransferCoeffField).clear();
        driver.findElement(heatTransferCoeffField).sendKeys(str);
    }

    public void heatGenerationFieldInput(String str) {
        driver.findElement(heatGenerationField).clear();
        driver.findElement(heatGenerationField).sendKeys(str);
    }

    public void temperatureMaxFieldInput(String str) {
        driver.findElement(temperatureMaxField).clear();
        driver.findElement(temperatureMaxField).sendKeys(str);
    }

    public void temperatureMinFieldInput(String str) {
        driver.findElement(temperatureMinField).clear();
        driver.findElement(temperatureMinField).sendKeys(str);
    }

    public void operationalTempMaxFieldInput(String str) {
        driver.findElement(operationalTempMaxField).clear();
        driver.findElement(operationalTempMaxField).sendKeys(str);
    }

    public void operationalTempMinFieldInput(String str) {
        driver.findElement(operationalTempMinField).clear();
        driver.findElement(operationalTempMinField).sendKeys(str);
    }

    public void boxMaterialSelect(int value) {
        Select dropdown = new Select(driver.findElement(boxMaterialSelect));
        dropdown.selectByIndex(value);
    }

    public void installationEnviromentSelect(int value) {
        Select dropdown = new Select(driver.findElement(installationEnviromentSelect));
        dropdown.selectByIndex(value);
    }

    public void altitudeSelectSelect(int value) {
        Select dropdown = new Select(driver.findElement(altitudeSelect));
        dropdown.selectByIndex(value);
    }

    public void installationTypesBtnClick() {
       driver.findElement(installationTypesBtn).click();
    }

    public void calculateBtnClick() {
       driver.findElement(calculateBtn).click();
    }

    public void cancelBtnClick() {
       driver.findElement(cancelBtn).click();
    }

}