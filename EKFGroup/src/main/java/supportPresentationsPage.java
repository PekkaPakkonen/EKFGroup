import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class supportPresentationsPage {

    private final WebDriver driver;

    public supportPresentationsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By openTabPresentations = By.cssSelector(".show .card.card-pos");
    private By presentationsBtn = By.cssSelector(".btn.card-header");


    public By getPresentationsBtn() {
        return presentationsBtn;
    }

    public By getOpenTabPresentations() {
        return openTabPresentations;
    }


    public WebElement[] getAllPresentationsBtn() {
        return driver.findElements(presentationsBtn).toArray(new WebElement[0]);
    }

    public WebElement[] getAllOpenTabPresentations() {
        return driver.findElements(openTabPresentations).toArray(new WebElement[0]);
    }
}
