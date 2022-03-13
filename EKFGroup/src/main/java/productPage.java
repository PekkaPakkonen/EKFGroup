import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class productPage {

    private WebDriver driver;

    private By documentationBtn = By.xpath("//section/div/div/ul/li/a[text()=\"Документация\"]");
    private By productName = By.cssSelector(".mb-32 .h2.mb-32");
    private By downloadLink = By.cssSelector(".media.text-reset");


    public productPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getDocumentationBtn() {
        return documentationBtn;
    }

    public By getDownloadLink() {
        return downloadLink;
    }

    public By getProductName() {
        return productName;
    }

    public void clickDocumentationBtn() {
        driver.findElement(documentationBtn).click();
    }

}
