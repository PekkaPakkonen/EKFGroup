import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolSelectivity {

    private WebDriver driver;

    private By singlePhaseBtn = By.cssSelector(".form-group:first-of-type .col-sm-8 .btn:first-child");
    private By threePhaseBtn = By.cssSelector(".form-group:first-of-type .col-sm-8 .btn:nth-child(2)");

    private By IndustrialApplicationBtn = By.cssSelector(".form-group:nth-of-type(2) .col-sm-8 .btn:first-child");
    private By OtherApplicationBtn = By.cssSelector(".form-group:nth-of-type(2) .col-sm-8 .btn:nth-child(2)");

    private By optionBtn = By.cssSelector(".checkbox");

    private By breakerTypeBtn = By.cssSelector(".panel-primary .form-group:first-child .form-control");
    private By curveTypeBtn = By.cssSelector(".panel-primary .form-group:nth-child(2) .btn-group");
    private By caseTypeBtn = By.cssSelector(".panel-primary .form-group:nth-child(3) .form-control");
    private By ratedCurrentBtn = By.cssSelector(".panel-primary .form-group:nth-child(4) .form-control");
    private By phaseBtn = By.cssSelector(".panel-primary .form-group:nth-child(5) .form-control");
    private By currentBtn = By.cssSelector(".panel-primary .form-group:nth-child(6) .form-control");
    private By capacityUltimateBtn = By.cssSelector(".panel-primary .form-group:nth-child(7) .form-control");

    private By calculateBtn = By.cssSelector(".row .text-center:first-child .btn-block");
    private By addBreakerBtn = By.cssSelector(".row .text-center:nth-child(2) .btn-block");


    public mToolSelectivity(WebDriver driver) {
        this.driver = driver;
    }


    public void singlePhaseBtnClick() {
       driver.findElement(singlePhaseBtn).click();
    }

    public void threePhaseBtnClick() {
       driver.findElement(threePhaseBtn).click();
    }

    public void IndustrialApplicationBtnClick() {
       driver.findElement(IndustrialApplicationBtn).click();
    }

    public void OtherApplicationBtnClick() {
       driver.findElement(OtherApplicationBtn).click();
    }

    public void optionBtnClick() {
       driver.findElement(optionBtn).click();
    }

    public void breakerTypeBtnClick() {
       driver.findElement(breakerTypeBtn).click();
    }

    public void curveTypeBtnClick() {
       driver.findElement(curveTypeBtn).click();
    }

    public void caseTypeBtnClick() {
       driver.findElement(caseTypeBtn).click();
    }

    public void ratedCurrentBtnClick() {
       driver.findElement(ratedCurrentBtn).click();
    }

    public void phaseBtnClick() {
       driver.findElement(phaseBtn).click();
    }

    public void currentBtnClick() {
       driver.findElement(currentBtn).click();
    }

    public void capacityUltimateBtnClick() {
       driver.findElement(capacityUltimateBtn).click();
    }

    public void calculateBtnClick() {
       driver.findElement(calculateBtn).click();
    }

    public void addBreakerBtnClick() {
       driver.findElement(addBreakerBtn).click();
    }

}