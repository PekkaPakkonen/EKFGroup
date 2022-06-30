import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolCurrent {

    private WebDriver driver;

    private final By singlePhaseBtn = By.cssSelector(".form-group:first-child .btn:first-child");
    private final By threePhaseBtn = By.cssSelector(".form-group:first-child .btn:nth-child(2)");
    private final By powerTextField = By.cssSelector(".form-group:nth-child(2) .form-control");
    private final By voltageTextField = By.cssSelector(".form-group:nth-child(3) .form-control");
    private final By activeLoadTypeBtn = By.cssSelector(".form-group:nth-child(4) .btn:first-child");
    private final By reactiveLoadTypeBtn = By.cssSelector(".form-group:nth-child(4) .btn:nth-child(2)");
    private final By powerCoefficientTextField = By.cssSelector(".form-group:nth-child(5) .form-control");
    private final By calculatedCurrentText = By.cssSelector(".form-group:nth-child(6) .form-control-static");

    public mToolCurrent(WebDriver driver) {
        this.driver = driver;
    }

    public void singlePhaseBtnClick() {
        driver.findElement(singlePhaseBtn).click();
    }

    public void threePhaseBtnClick() {
        driver.findElement(threePhaseBtn).click();
    }

    public void activeLoadTypeBtnClick() {
        driver.findElement(activeLoadTypeBtn).click();
    }

    public void reactiveLoadTypeBtnClick() {
        driver.findElement(reactiveLoadTypeBtn).click();
    }

    public void powerTextFieldInput(String text) {
        driver.findElement(powerTextField).clear();
        driver.findElement(powerTextField).sendKeys(text);
    }

    public void voltageTextFieldInput(String text) {
        driver.findElement(voltageTextField).clear();
        driver.findElement(voltageTextField).sendKeys(text);
    }

    public void powerCoefficientTextFieldInput(String text) {
        driver.findElement(powerCoefficientTextField).clear();
        driver.findElement(powerCoefficientTextField).sendKeys(text);
    }

    public String getCalculatedCurrentText() {
        return driver.findElement(calculatedCurrentText).getText();
    }

}
