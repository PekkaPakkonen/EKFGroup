import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolVoltage {

    private WebDriver driver;

    private By singlePhaseBtn = By.cssSelector(".form-group:first-child .btn:first-child");
    private By threePhaseBtn = By.cssSelector(".form-group:first-child .btn:nth-child(2)");

    private By copperWireBtn = By.cssSelector(".form-group:nth-child(2) .btn:first-child");
    private By aluminiumWireBtn = By.cssSelector(".form-group:nth-child(2) .btn:nth-child(2)");

    private By cableCrossSectionField = By.cssSelector(".form-group:nth-child(3) .form-control");
    private By powerLoadTextField = By.cssSelector(".form-group:nth-child(4) .form-control");
    private By powerCoefTextField = By.cssSelector(".form-group:nth-child(5) .form-control");
    private By lineLengthField = By.cssSelector(".form-group:nth-child(6) .form-control");
    private By temperatureTextField = By.cssSelector(".form-group:nth-child(7) .form-control");


    public mToolVoltage(WebDriver driver) {
        this.driver = driver;
    }

    public void singlePhaseBtnClick() {
       driver.findElement(singlePhaseBtn).click();
    }

    public void threePhaseBtnClick() {
       driver.findElement(threePhaseBtn).click();
    }

    public void copperWireBtnClick() {
       driver.findElement(copperWireBtn).click();
    }

    public void aluminiumWireBtnClick() {
       driver.findElement(aluminiumWireBtn).click();
    }

    public void cableCrossSectionFieldInput(String str) {
        driver.findElement(cableCrossSectionField).sendKeys(str);
    }

    public void powerLoadTextFieldInput(String str) {
        driver.findElement(powerLoadTextField).sendKeys(str);
    }

    public void powerCoefTextFieldInput(String str) {
        driver.findElement(powerCoefTextField).sendKeys(str);
    }

    public void lineLengthFieldnput(String str) {
        driver.findElement(lineLengthField).sendKeys(str);
    }

    public void temperatureTextFieldInput(String str) {
        driver.findElement(temperatureTextField).sendKeys(str);
    }

}