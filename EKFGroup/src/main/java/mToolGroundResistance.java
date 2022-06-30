import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mToolGroundResistance {

    private final WebDriver driver;

    private final By upperLayerBtn = By.cssSelector(".form-horizontal .form-group:first-child .form-control");
    private final By lowerLayerBtn = By.cssSelector(".form-horizontal .form-group:nth-child(2) .form-control");
    private final By bondAmountField = By.cssSelector(".form-horizontal .form-group:nth-child(3) .form-control");
    private final By climCoefBtn = By.cssSelector(".form-horizontal .form-group:nth-child(4) .form-control");

    private final By upperLayerDepthField = By.cssSelector(".form-horizontal .form-group:nth-child(5) .form-control");
    private final By bondLengthField = By.cssSelector(".form-horizontal .form-group:nth-child(6) .form-control");
    private final By bondDiameterField= By.cssSelector(".form-horizontal .form-group:nth-child(7) .form-control");
    private final By bondDepthField = By.cssSelector(".form-horizontal .form-group:nth-child(8) .form-control");
    private final By gridBondDiameterField = By.cssSelector(".form-horizontal .form-group:nth-child(9) .form-control");
    private final By bondLengthToBuildingField = By.cssSelector(".form-horizontal .form-group:nth-child(10) .form-control");

    private final By textResult_1 = By.cssSelector(".form-horizontal .form-group:nth-child(11) .form-control-static");
    private final By textResult_2 = By.cssSelector(".form-horizontal .form-group:nth-child(12) .form-control-static");
    private final By textResult_3 = By.cssSelector(".form-horizontal .form-group:nth-child(13) .form-control-static");
    private final By textResult_4 = By.cssSelector(".form-horizontal .form-group:nth-child(14) .form-control-static");
    private final By textResult_5 = By.cssSelector(".form-horizontal .form-group:nth-child(15) .form-control-static");


    public mToolGroundResistance(WebDriver driver) {
        this.driver = driver;
    }

    public By getUpperLayerBtn() {
        return upperLayerBtn;
    }

    public void upperLayerBtnClick() {
        driver.findElement(upperLayerBtn).click();
    }

    public void lowerLayerBtnClick() {
       driver.findElement(lowerLayerBtn).click();
    }

    public void climCoefBtnClick() {
       driver.findElement(climCoefBtn).click();
    }

    public void upperLayerDepthFieldInput(String str) {
        driver.findElement(upperLayerDepthField).clear();
        driver.findElement(upperLayerDepthField).sendKeys(str);

    }

    public void bondLengthFieldInput(String str) {
        driver.findElement(bondLengthField).clear();
        driver.findElement(bondLengthField).sendKeys(str);
    }

    public void bondDiameterFieldInput(String str) {
        driver.findElement(bondDiameterField).clear();
        driver.findElement(bondDiameterField).sendKeys(str);
    }

    public void bondDepthFieldInput(String str) {
        driver.findElement(bondDepthField).clear();
        driver.findElement(bondDepthField).sendKeys(str);
    }

    public void gridBondDiameterFieldInput(String str) {
        driver.findElement(gridBondDiameterField).clear();
        driver.findElement(gridBondDiameterField).sendKeys(str);
    }

    public void bondLengthToBuildingFieldInput(String str) {
        driver.findElement(bondLengthToBuildingField).clear();
        driver.findElement(bondLengthToBuildingField).sendKeys(str);
    }

    public void upperLayerSelect(int value) {
        Select dropdown = new Select(driver.findElement(upperLayerBtn));
        dropdown.selectByIndex(value);
    }

    public void lowerLayerSelect(int value) {
        Select dropdown = new Select(driver.findElement(lowerLayerBtn));
        dropdown.selectByIndex(value);
    }

    public void bondAmountFieldSelect(int value) {
        Select dropdown = new Select(driver.findElement(bondAmountField));
        dropdown.selectByIndex(value);
    }

    public void climCoefSelect(int value) {
        Select dropdown = new Select(driver.findElement(climCoefBtn));
        dropdown.selectByIndex(value);
    }
    //Calculation results
    public String getTextResult_1() {
        return driver.findElement(textResult_1).getText();
    }

    public String getTextResult_2() {
        return driver.findElement(textResult_2).getText();
    }

    public String getTextResult_3() {
        return driver.findElement(textResult_3).getText();
    }

    public String getTextResult_4() {
        return driver.findElement(textResult_4).getText();
    }

    public String getTextResult_5() {
        return driver.findElement(textResult_5).getText();
    }







}
