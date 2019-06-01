package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsHome extends Page {
    public UspsHome() {
        setUrl("https://www.usps.com/");
    }

    @FindBy(xpath = "//a[@id='stampButton']")
    private WebElement stamps;

    @FindBy(xpath = "//a[@id='orderButton']")
    private WebElement boxes;

    @FindBy(xpath = "//li[@class='qt-nav menuheader']//a[contains(@href,'ZipLookup')]")
    private WebElement lookUpZip;

    @FindBy(xpath = "//a[@class='menuitem'][contains(text(),'Postal Store')]")
    private WebElement postal;

    @FindBy(xpath = "//a[@id='mail-ship-width']")
    private WebElement mailAndShip;

    @FindBy(xpath = "//li[contains(@class,'qt-nav')]")
    private WebElement quickTools;

    @FindBy(xpath = "//li[contains(@class,'qt-nav')]//a[contains(@href,'postcalc')]")
    private WebElement calculatePrice;

    @FindBy(xpath = "//a[contains(@class,'zip-code-address')]")
    private WebElement findByAddress;


    public void clickStamps() {
        stamps.click();
    }

    public void clickBoxes() {
        boxes.click();
    }

    public void moveToLink() {
        forActionMove(quickTools);
    }

    public void clickCalculatePrice() {
        click(calculatePrice);
    }

    public void clickLookUpZip() {
       lookUpZip.click();
    }

    public void clickByAddress() {
        findByAddress.click();
    }

    public void clickPostal() {
        click(postal);
    }

}
