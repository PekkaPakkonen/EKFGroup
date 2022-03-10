import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productPage {

    private WebDriver driver;

    private By documentationBtn = By.cssSelector(".nav-tabs .nav-item:nth-child(3)");


    public productPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getDocumentationBtn() {
        return documentationBtn;
    }

    public void clickDocumentationBtn() {
        driver.findElement(documentationBtn).click();
    }
}
