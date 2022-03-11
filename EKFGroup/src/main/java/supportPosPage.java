import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class supportPosPage {

    private final WebDriver driver;

    public supportPosPage(WebDriver driver) {
        this.driver = driver;
    }

    //main page headers
    private By cataloguesTab = By.cssSelector(".nav-tabs .nav-item:first-child .nav-link.px-16");
    private By leafletsTab = By.cssSelector(".nav-tabs .nav-item:nth-child(2) .nav-link.px-16");
    private By bookletsTab = By.cssSelector(".nav-tabs .nav-item:nth-child(3) .nav-link.px-16");
    private By fileCard = By.cssSelector(".card.card-pos");

    public By getFileCard() {
        return fileCard;
    }


    public void clickCataloguesTab() {
        driver.findElement(cataloguesTab).click();
    }

    public void clickLeafletsTab() {
        driver.findElement(cataloguesTab).click();
    }

    public void clickBookletsTab() {
        driver.findElement(cataloguesTab).click();
    }

    public WebElement[] getActiveCards() {
        return driver.findElements(By.cssSelector(".active .card.card-pos")).toArray(new WebElement[0]);
    }


}
