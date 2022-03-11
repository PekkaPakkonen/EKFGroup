import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.*;


public class allPassortsCheck {

    private WebDriver webDriver;
    private productPage productP;
    private BufferedReader reader;

    @BeforeTest
    public void prep() throws IOException {
        reader = new BufferedReader(new FileReader("links.csv"));
        webDriver = new FirefoxDriver();
        productP = new productPage(webDriver);
        webDriver.manage().window().maximize();
    }

    @Test
    public void checkLinks() throws IOException{
        while(reader.ready()) {
           webDriver.get(reader.readLine().trim());
           new WebDriverWait(webDriver, 10)
                   .until(ExpectedConditions.elementToBeClickable(productP.getDocumentationBtn()));
           productP.clickDocumentationBtn();
        }


    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }

}
