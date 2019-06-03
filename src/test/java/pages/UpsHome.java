package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsHome extends Page {
    public UpsHome() {
        setUrl("https://www.ups.com/us/en/Home.page");
    }

    @FindBy(xpath = "//a[@id='ups-menuLinks1']")
    private WebElement shipping;

    @FindBy(xpath = "//a[contains(@href,'ship?loc')][not(@id='ups-quickStartShip')]")
    private WebElement shipment;

    public void getShipping() {
        click(shipping);
    }

    public void getShipment() {
        click(shipment);
    }


}
