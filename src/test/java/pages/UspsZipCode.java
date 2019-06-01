package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsZipCode extends Page {
    @FindBy(xpath = "//input[@id='tAddress']")
    private WebElement street;

    @FindBy(xpath = "//input[@id='tCity']")
    private WebElement city;

    @FindBy(xpath = "//select[@id='tState']")
    private WebElement state;

    @FindBy(xpath = "//a[@id='zip-by-address']")
    private WebElement findButton;

    public void sendStreet(String value) {
        street.sendKeys(value);
    }

    public void sendCity(String value) {
        city.sendKeys(value);
    }

    public void selectState(String valueState) {
         forSelectByValue(state, valueState);
    }

    public void clickFindButton() {
        findButton.click();
    }

}
