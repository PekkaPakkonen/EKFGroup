import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class allDocsCheck {

    private WebDriver webDriver;
    private productPage productP;
    private BufferedReader reader;
    private OutputStreamWriter writer;

    @BeforeTest
    public void prep() throws IOException {
        reader = new BufferedReader(new FileReader("links.csv"));
        writer = new OutputStreamWriter(new FileOutputStream("output.csv"), Charset.forName("cp1251"));
        webDriver = new FirefoxDriver();
        productP = new productPage(webDriver);
        webDriver.manage().window().maximize();
    }

    @Test
    public void checkLinks() throws IOException{
        while(reader.ready()) {
            String link = reader.readLine().trim();
            try {
                webDriver.get(link);
                new WebDriverWait(webDriver, 10)
                        .until(ExpectedConditions.presenceOfElementLocated(productP.getProductName()));
            } catch (Exception e) {
                writer.write(link + ";" + "страница не отображается\n");
                writer.flush();
            }

            try {
                new WebDriverWait(webDriver, 2)
                        .until(ExpectedConditions.elementToBeClickable(productP.getDocumentationBtn()));
                productP.clickDocumentationBtn();
            } catch (Exception e) {
                writer.write(link + ";" + "нет вкладки \"Документация\"\n");
                writer.flush();
            }

            try {
                new WebDriverWait(webDriver, 2)
                        .until(ExpectedConditions.elementToBeClickable(productP.getDownloadLink()));
            } catch (Exception e) {
                writer.write(link + ";" + "\"нет элементов для скачивания\"\n");
                writer.flush();
            }
        }


    }

    @AfterTest
    public void stopBrowser() {
        webDriver.quit();
    }

}
