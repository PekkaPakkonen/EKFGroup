import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class categoryPage {

    private final WebDriver driver;

    public By landingPageLink = By.cssSelector(".mb-12 .btn");
    public By downloadCatalogBtn = By.cssSelector(".mb-8 .btn-outline-primary.btn-sm-sm");
    public By downloadPriceList = By.cssSelector(".mb-8 .btn-gray-200");

    public categoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLandingPageLink() {
        return landingPageLink;
    }

    public void landingPageClick() {
        driver.findElement(getLandingPageLink()).click();
    }


}
