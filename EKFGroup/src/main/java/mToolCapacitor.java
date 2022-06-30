import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolCapacitor {

    private WebDriver driver;

    private By starConnectBtn = By.cssSelector(".form-group:first-child .btn:first-child");
    private By deltaConnectBtn = By.cssSelector(".form-group:first-child .btn:nth-child(2)");
    private By powerTextField = By.cssSelector(".form-group:nth-child(2) .form-control");
    private By voltageTextField = By.cssSelector(".form-group:nth-child(3) .form-control");
    private By powerCoeffTextField = By.cssSelector(".form-group:nth-child(4) .form-control");
    private By efficiencyTextField = By.cssSelector(".form-group:nth-child(5) .form-control");
    private By saveToPdfBtn = By.cssSelector(".col-sm-offset-4 .btn");

    private By capacitorOperating = By.cssSelector(".form-group:nth-child(6) .form-control-static");
    private By capacitorStarting = By.cssSelector(".form-group:nth-child(7) .form-control-static");



    public mToolCapacitor(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextCapacitorOperating() {
        return driver.findElement(capacitorOperating).getText();
    }

    public String getTextCapacitorStarting() {
        return driver.findElement(capacitorStarting).getText();
    }

    public void starConnectBtnClick() {
       driver.findElement(starConnectBtn).click();
    }

    public void deltaConnectBtnClick() {
       driver.findElement(deltaConnectBtn).click();
    }

    public void saveToPdfBtnClick() {
       driver.findElement(saveToPdfBtn).click();
    }

    public void powerTextFieldInput(String str) throws InterruptedException {
        driver.findElement(powerTextField).clear();
        driver.findElement(powerTextField).sendKeys(str);
        Thread.sleep(100);
    }

    public void voltageTextFieldInput(String str) throws InterruptedException {
        driver.findElement(voltageTextField).clear();
        driver.findElement(voltageTextField).sendKeys(str);
        Thread.sleep(100);
    }

    public void powerCoeffTextFieldInput(String str) throws InterruptedException {
        driver.findElement(powerCoeffTextField).clear();
        driver.findElement(powerCoeffTextField).sendKeys(str);
        Thread.sleep(100);
    }

    public void efficiencyTextFieldInput(String str) throws InterruptedException {
        driver.findElement(efficiencyTextField).clear();
        driver.findElement(efficiencyTextField).sendKeys(str);
        Thread.sleep(100);
    }

}