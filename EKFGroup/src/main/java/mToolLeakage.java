import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolLeakage {

    private WebDriver driver;

    private By lengthWireField = By.cssSelector(".form-horizontal .form-group:first-child .form-control");
    private By currentLoadField = By.cssSelector(".form-horizontal .form-group:nth-child(2) .form-control");



    public mToolLeakage(WebDriver driver) {
        this.driver = driver;
    }

    public void lengthWireFieldInput(String str) {
        driver.findElement(lengthWireField).sendKeys(str);
    }

    public void currentLoadFieldInput(String str) {
        driver.findElement(currentLoadField).sendKeys(str);
    }

}