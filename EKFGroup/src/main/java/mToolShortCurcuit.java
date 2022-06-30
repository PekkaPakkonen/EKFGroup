import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolShortCurcuit {

    private WebDriver driver;

    private By cableTypeBtn = By.cssSelector(".form-horizontal .form-group:first-child .form-control");
    private By coreNumberBtn = By.cssSelector(".form-horizontal .form-group:nth-child(2) .form-control");
    private By cableLengthField = By.cssSelector(".form-horizontal .form-group:nth-child(3) .form-control");

    public mToolShortCurcuit(WebDriver driver) {
        this.driver = driver;
    }

    public void cableLengthFieldInput(String str) {
        driver.findElement(cableLengthField).sendKeys(str);
    }

    public void cableTypeBtnClick() {
       driver.findElement(cableTypeBtn).click();
    }

    public void coreNumberBtnClick() {
       driver.findElement(coreNumberBtn).click();
    }

}