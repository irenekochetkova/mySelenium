package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;

import static support.TestContext.*;

public class UpsDestinationShipment extends Page {

    @FindBy(xpath = "//agent-summary")
    private WebElement actualOrigin;

    @FindBy(xpath = "//input[@id='destinationname']")
    private WebElement nameDestin;

    @FindBy(xpath = "//input[@id='destinationaddress1']")
    private WebElement streetDestin;

    @FindBy(xpath = "//input[@id='destinationpostal']")
    private WebElement zipDestin;

    @FindBy(xpath = "//input[@id='destinationcity']")
    private WebElement cityDestin;

    @FindBy(xpath = "//input[@id='destinationcity']")
    private WebElement stateDestin;

//    @FindBy(xpath = "//span[@id='total-charges-spinner']")
//    private By totalCharges;

    public String actualResultOrigin() {
        waitForElementIsNotEmpty(actualOrigin);
        return actualOrigin.getText();
    }

    public String verifyResultOrigin(String element) throws FileNotFoundException {
        return getSender().get(element);
    }

    public void sendDestinationName() throws FileNotFoundException {
        nameDestin.sendKeys(getReceiver().get("name"));
    }

    public void sendDestinationStreet() throws FileNotFoundException {
        streetDestin.sendKeys(getReceiver().get("street"));
    }

    public void sendDestinationZip() throws FileNotFoundException {
        zipDestin.sendKeys(getReceiver().get("zip"));
    }

    public void getDestinCity() throws FileNotFoundException {
        waitForPresent(cityDestin, getReceiver().get("city"));
    }

    private WebElement getStateDestin() throws FileNotFoundException {
        return getDriver().findElement(By.xpath("//select[@id='destinationstate']/option[text()='" + getReceiver().get
                ("state")
                + "']"));
    }

    public void selectStateDestin() throws FileNotFoundException {
        waitForSelected(getStateDestin());
    }

    public void verifyTotalCharges() {
        waitVisibilityOfElement(By.xpath("//span[@id='total-charges-spinner']"));
    }
}
