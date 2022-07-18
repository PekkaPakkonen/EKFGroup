import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class mainPage {

    private final WebDriver driver;

    //main page headers
    private By distributor = By.cssSelector(".nav.nav-visible .nav-item:first-child");
    private By cabinetAssembler = By.cssSelector(".nav.nav-visible .nav-item:nth-child(2)");
    private By designer = By.cssSelector(".nav.nav-visible .nav-item:nth-child(3)");
    private By industrial = By.cssSelector(".collapse-right .nav .nav-item:first-child");
    private By civilBuilding = By.cssSelector(".collapse-right .nav .nav-item:nth-child(2)");
    private By electricalAssembler = By.cssSelector(".collapse-right .nav .nav-item:nth-child(3)");
    private By retail = By.cssSelector(".collapse-right .nav .nav-item:nth-child(4)");
    private By houseOwner = By.cssSelector(".collapse-right .nav .nav-item:nth-child(5)");

    private By itemsBtn = By.cssSelector(".btn.header-catalog-toggle");
    private By solutionsBtn = By.cssSelector(".nav.header-menu-main .nav-item:first-of-type");
    private By supportBtn = By.cssSelector(".nav.header-menu-main .nav-item:nth-of-type(2)");
    private By calculatorsBtn = By.cssSelector(".nav.header-menu-main .nav-item:nth-of-type(3) .dropdown");
    private By whereToBuyBtn = By.cssSelector(".nav.header-menu-main .nav-item:nth-of-type(4)");
    private By aboutUsBtn = By.cssSelector(".nav.header-menu-main .nav-item:nth-of-type(5)");

    //.menu-catalog
    private By itemHeader = By.cssSelector(".menu-catalog-nav:not(.mb-24) .nav-item");
    private By subItemHeader = By.cssSelector(".nav-item.nav-item-header .nav-link");
    private By subCategoryHeader = By.cssSelector(".menu-catalog-panel:not(.menu-catalog-panel-root) .nav-item:not(.nav-item-header) .nav-link");
    private By bigItemHeader = By.cssSelector(".menu-catalog-panel .text-hover-primary");
    private By closeButton = By.cssSelector(".btn.btn-close .icon");
    private By collapseBtn = By.cssSelector(".menu-catalog-nav .btn.collapse-toggle");
    private By catalogDownload = By.cssSelector(".menu-catalog .row.mx-n8 .px-8:first-child .btn-link");
    private By priceListDownload = By.cssSelector(".menu-catalog .row.mx-n8 .px-8:nth-child(2) .btn-link");
    private By etimLink = By.cssSelector(".menu-catalog .row.mx-n8 .px-8:nth-child(3) .btn-link");

    //buttons
    private By collapseButton = By.cssSelector(".collapse-right .icon.sprite-icons");



    public mainPage(WebDriver driver) {
        this.driver = driver;
    }

//GETTERS

    public By getSubCategoryHeader() { return subCategoryHeader; }

    public By getSolutionsBtn() {
        return solutionsBtn;
    }

    public By getCollapseBtn() { return collapseBtn; }

    public By getSupportBtn() {
        return supportBtn;
    }

    public By getWhereToBuyBtn() {
        return whereToBuyBtn;
    }

    public By getAboutUsBtn() {
        return aboutUsBtn;
    }

    public By getItemsBtn() {
        return itemsBtn;
    }

    public By getDistributor() {
        return distributor;
    }

    public By getCabinetAssembler() {
        return cabinetAssembler;
    }

    public By getDesigner() {
        return designer;
    }

    public By getIndustrial() {
        return industrial;
    }

    public By getCivilBuilding() {
        return civilBuilding;
    }

    public By getElectricalAssembler() {
        return electricalAssembler;
    }

    public By getRetail() {
        return retail;
    }

    public By getHouseOwner() {
        return houseOwner;
    }

    public By getItemHeader() {
        return itemHeader;
    }

    public By getSubItemHeader() {
        return subItemHeader;
    }

    public By getBigItemHeader() {
        return bigItemHeader;
    }

    public By getCalculatorsBtn() {
        return calculatorsBtn;
    }

    public By getCloseButton() {
        return closeButton;
    }

    public By getCatalogDownload() {
        return catalogDownload;
    }

    public By getPriceListDownload() {
        return priceListDownload;
    }

    public By getEtimLink() {
        return etimLink;
    }

//BUTTON AND LINK CLICKERS

    public void clickItemsBtn() {
        driver.findElement(itemsBtn).click();
    }

//    public void clickSolutionsBtn() {
//        driver.findElement(solutionsBtn).click();
//    }
//
//    public void clickSupportBtn() {
//        driver.findElement(supportBtn).click();
//    }

    public void clickCalculatorsBtn() {
        driver.findElement(calculatorsBtn).click();
    }

    public void clickCatalogDownload() {
        driver.findElement(catalogDownload).click();
    }

    public void clickPriceListDownload() {
        driver.findElement(priceListDownload).click();
    }

    public void clickEtimLink() {
        driver.findElement(etimLink).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeButton).click();
    }

    public void clickCollapseBtn() {
        driver.findElement(collapseButton).click();
    }

    public void clickItemHeader() { driver.findElement(itemHeader).click(); }

//OTHER STUFF
    public void moveMouseToGroupHeader(WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
    }

    public WebElement[] getAllItemsButtons() {
        return driver.findElements(itemHeader).toArray(new WebElement[0]);
    }
    public WebElement[] getAllSubItemButtons() {
        return driver.findElements(subItemHeader).toArray(new WebElement[0]);
    }
    public WebElement[] getAllCollapseButton() { return driver.findElements(collapseBtn).toArray(new WebElement[0]); }
    public WebElement[] getAllSubCategoryHeaders() { return driver.findElements(subCategoryHeader).toArray(new WebElement[0]); }
    //subItemHeader
}
