import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mToolLightning {

    private WebDriver driver;

    private By buildingTypeLeftBtn = By.cssSelector(".panel-body > .bs-toggle-buttons .btn:first-child");
    private By buildingTypeRightBtn = By.cssSelector(".panel-body > .bs-toggle-buttons .btn:nth-child(2)");

    private By lengthField = By.cssSelector(".panel:first-child .form-group:first-child .form-control");
    private By widthField = By.cssSelector(".panel:first-child .form-group:nth-child(2) .form-control");
    private By heightField = By.cssSelector(".panel:first-child .form-group:nth-child(3) .form-control");
    private By lightningDensitySelect = By.cssSelector(".panel:first-child .col-sm-2.col-xs-8 #mh_lp_b_density");

    private By lightingRodTypeSelect = By.cssSelector(".panel:nth-child(2) select.form-control");
    private By rodHeightField = By.cssSelector(".panel:nth-child(2) .col-sm-2 .form-control");

    private By buildingClassBtn = By.cssSelector(".panel:nth-child(3) #LPKindsContent");
    private By placesBtn = By.cssSelector(".panel:nth-child(3) #LPLocationsContent");

    private By leftProtectionTypeBtn = By.cssSelector(".panel:nth-child(3) hr + .form-group .btn:first-child");
    private By rightProtectionTypeBtn = By.cssSelector(".panel:nth-child(3) hr + .form-group .btn:nth-child(2)");

    private By ProtectionCategoryFirstBtn = By.cssSelector(".panel:nth-child(3) div + .form-group .btn:first-child");
    private By ProtectionCategorySecondBtn = By.cssSelector(".panel:nth-child(3) hr + .form-group .btn:nth-child(2)");
    private By ProtectionCategoryThirdBtn = By.cssSelector(".panel:nth-child(3) hr + .form-group .btn:nth-child(3)");

    private By saveToPdfBtn = By.cssSelector(".col-sm-offset-4 .btn");

    public mToolLightning(WebDriver driver) {
        this.driver = driver;
    }

    public void buildingTypeLeftBtnClick() {
        driver.findElement(buildingTypeLeftBtn).click();
    }

    public void buildingTypeRightBtnClick() {
        driver.findElement(buildingTypeRightBtn).click();
    }
}
