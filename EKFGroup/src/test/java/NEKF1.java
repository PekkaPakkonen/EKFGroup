import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.net.MalformedURLException;


public class NEKF1 {

    private WebDriver webDriver;
    private mainPage mainP;


    @BeforeTest
    public void prep() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(new URL("http://172.17.0.3:4444"), caps);
        mainP = new mainPage(webDriver);
        webDriver.navigate().back();
        webDriver.manage().window().maximize();
        webDriver.get("https://ekfgroup.com/");
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
    }

    @Test
    public void click() {
        By[] buttons = {mainP.getDistributor(),mainP.getCabinetAssembler(),mainP.getDesigner()};
        By[] collapsedButtons = {mainP.getIndustrial(),mainP.getCivilBuilding(),mainP.getElectricalAssembler(),
        mainP.getRetail(), mainP.getHouseOwner()};
        String[] links = {"distributor", "nku", "project", "industry","civil-construction", "smo", "retail", "homeowner"};
        String linkEKF = "https://ekfgroup.com/view/";

        for(int i = 0; i < buttons.length; i++) {
            webDriver.findElement(buttons[i]).click();
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlToBe(linkEKF + links[i]));
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
        }

        mainP.clickCollapseBtn();
        for(int i = 0; i < collapsedButtons.length; i++) {
            webDriver.findElement(collapsedButtons[i]).click();
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlToBe(linkEKF + links[i+3]));
            new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(mainP.getDistributor()));
        }

    }

    @AfterTest
    public void stopBrowser() {
        System.out.println("Test completed!");
        webDriver.quit();
    }
}
