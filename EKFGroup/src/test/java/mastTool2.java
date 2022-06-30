import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.net.MalformedURLException;


public class mastTool2 {

    private WebDriver driver;
    private mToolGroundResistance page;

    @BeforeTest
    public void link() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        driver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        driver.manage().window().maximize();
        page = new mToolGroundResistance(driver);
        driver.get("https://ekfgroup.com/calculators/mastertool/grounding-resistance");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.w-100")));


    }

    @Test
    public void checkFields() throws InterruptedException {
        WebElement iframe = driver.findElement(By.cssSelector("iframe.w-100"));
        driver.switchTo().frame(iframe);
        //set calculation parameters
        page.upperLayerDepthFieldInput("2");
        Thread.sleep(100);
        page.bondLengthFieldInput("3");
        Thread.sleep(100);
        page.bondDiameterFieldInput("0.016");
        Thread.sleep(100);
        page.bondDepthFieldInput("0.5");
        Thread.sleep(100);
        page.gridBondDiameterFieldInput("2");
        Thread.sleep(100);
        page.bondLengthToBuildingFieldInput("5");


        page.upperLayerSelect(2);
        page.lowerLayerSelect(2);
        page.bondAmountFieldSelect(4);
        page.climCoefSelect(1);


        Assert.assertEquals("498.11", page.getTextResult_1());
        Assert.assertEquals("167.04", page.getTextResult_2());
        Assert.assertEquals("105.7", page.getTextResult_3());
        Assert.assertEquals("17", page.getTextResult_4());
        Assert.assertEquals("33.88", page.getTextResult_5());

    }

    @AfterTest
    public void exit() {
        driver.quit();
    }



}
