package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;

import static support.TestContext.getDriver;
import static support.TestContext.getSender;

public class UpsPackaging extends Page {

    @FindBy(xpath = "//select[@id='nbsPackagePackagingTypeDropdown0']")
    private WebElement typePackage;

    public void selectPackage() throws FileNotFoundException {
        forSelectByText(typePackage, getSender().get("typeOfPackage"));
    }

    private By spinner = By.xpath("//span[@id='total-charges-spinner']");

    private String getSpinner() {
        return getDriver().findElement(spinner).getText();
    }

    public void verifyChangesOfTotal() {
        waitForNotPresent(spinner, getSpinner());
    }
}
