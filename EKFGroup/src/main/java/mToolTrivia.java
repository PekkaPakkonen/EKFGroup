import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolTrivia extends PageObjectModel{

    private By heightBtn = By.cssSelector(".form-group .form-group:first-of-type .col-xs-5");
    private By widthBtn = By.cssSelector(".form-group .form-group:nth-of-type(2) .col-xs-5");
    private By depthBtn = By.cssSelector(".form-group .form-group:nth-of-type(3) .col-xs-5");
    private By ipBtn = By.cssSelector(".form-group .form-group:nth-of-type(4) .col-xs-7");
    private By topPanelBtn = By.cssSelector(".form-group .form-group:nth-of-type(5) .col-xs-7");
    private By sidePanelBtn = By.cssSelector(".form-group .form-group:nth-of-type(6) .col-xs-7");
    private By frontDoorBtn = By.cssSelector(".form-group .form-group:nth-of-type(7) .col-xs-7");
    private By backDoorBtn = By.cssSelector(".form-group .form-group:nth-of-type(8) .col-xs-7");
    private By downPanelBtn = By.cssSelector(".form-group .form-group:nth-of-type(9) .col-xs-7");
    private By foundationBtn = By.cssSelector(".form-group .form-group:nth-of-type(10) .col-xs-7");
    private By BoltBtn = By.cssSelector(".form-group .form-group:nth-of-type(11) .col-xs-7");

    private By manualBtn = By.cssSelector(".bs-toggle-buttons .btn-default:first-child");
    private By recommendedBtn = By.cssSelector(".bs-toggle-buttons .btn-default:nth-child(2)");

    public mToolTrivia(WebDriver driver) {
        super(driver);
    }

    public void heightBtnClick() {
       super.getDriver().findElement(heightBtn).click();
    }

    public void widthBtnClick() {
        super.getDriver().findElement(widthBtn).click();
    }

    public void depthBtnClick() {
        super.getDriver().findElement(depthBtn).click();
    }

    public void ipBtnClick() {
        super.getDriver().findElement(ipBtn).click();
    }

    public void topPanelBtnClick() {
        super.getDriver().findElement(topPanelBtn).click();
    }

    public void sidePanelBtnClick() {
        super.getDriver().findElement(sidePanelBtn).click();
    }

    public void frontDoorBtnClick() {
        super.getDriver().findElement(frontDoorBtn).click();
    }

    public void backDoorBtnClick() {
        super.getDriver().findElement(backDoorBtn).click();
    }

    public void downPanelBtnClick() {
        super.getDriver().findElement(downPanelBtn).click();
    }

    public void foundationBtnClick() {
        super.getDriver().findElement(foundationBtn).click();
    }

    public void BoltBtnClick() {
        super.getDriver().findElement(BoltBtn).click();
    }

    public void manualBtnClick() {
        super.getDriver().findElement(manualBtn).click();
    }

    public void recommendedBtnClick() {
        super.getDriver().findElement(manualBtn).click();
    }







}
