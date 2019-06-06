package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;


import static support.TestContext.*;

public class UpsOriginShipment extends Page {



    @FindBy(xpath = "//input[@id='originname']")
    private WebElement nameOrigin;

    @FindBy(xpath = "//input[@id='originaddress1']")
    private WebElement streetOrigin;

    @FindBy(xpath = "//input[@id='originpostal']")
    private WebElement zipOrigin;

    @FindBy(xpath = "//input[@id='origincity']")
    private WebElement cityOrigin;

    @FindBy(xpath = "//input[@id='originemail']")
    private WebElement emailOrigin;

    @FindBy(xpath = "//input[@id='originphone']")
    private WebElement phoneOrigin;

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationReviewPrimaryButton']")
    private WebElement buttonPayment;

    @FindBy(xpath = "//button[@id='nbsBackForwardNavigationContinueButton']")
    private WebElement buttonContinue;

    public void sendNameOrigin() throws FileNotFoundException {
        nameOrigin.sendKeys(getSender().get("name"));
    }

    public void sendStreetOrigin() throws FileNotFoundException {
        streetOrigin.sendKeys(getSender().get("street"));
    }

    public void sendZipOrigin() throws FileNotFoundException {
        zipOrigin.sendKeys(getSender().get("zip"));
    }

    public void getOriginCity() throws FileNotFoundException {
        waitForPresent(cityOrigin, getSender().get("city"));
    }

    public void selectState() throws FileNotFoundException {
        waitForSelected(getState());
    }

    private WebElement getState() throws FileNotFoundException {
        return getDriver().findElement(By.xpath("//select[@id='originstate']/option[text()='" + getSender().get("state") + "']"));
    }

    public void sendEmail() throws FileNotFoundException {
        emailOrigin.sendKeys(getSender().get("email"));
    }

    public void sendPhone() throws FileNotFoundException {
        phoneOrigin.sendKeys(getSender().get("phone"));
    }

    public void getCurrentUrl(String keyWord) throws InterruptedException {
        if (getDriver().getCurrentUrl().contains(keyWord)) {
            Thread.sleep(1000);
            click(buttonPayment);
        } else {
            click(buttonContinue);
        }

        waitForUrl();
    }


}

