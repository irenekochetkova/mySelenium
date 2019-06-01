package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleResult extends Page {
    public SampleResult() {}

    @FindBy(xpath = "//div[@id='samplePageResult']")
    private WebElement result;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement passwordResult;

    @FindBy(xpath = "//b[@name='name']")
    private WebElement nameResult;

    @FindBy(xpath = "//b[@name='address']")
    private WebElement addressResult;

    @FindBy(xpath = "//b[@name='allowedToContact']")
    private WebElement allowedResult;

    @FindBy(xpath = "//b[@name='countryOfOrigin']")
    private WebElement originCountryResuly;

    @FindBy(xpath = "//b[@name='dateOfBirth']")
    private WebElement birthDayResult;

    public String getResult() {
        return result.getText();
    }

    public String getLocatorPage() {
        return String.valueOf(this.result);
    }

    public String getPasswordResult() {
        return passwordResult.getText();
    }

    public String getNameResult() {
        return nameResult.getText();
    }

    public String getAddressResult() {
        return addressResult.getText();
    }

    public String getAllowedResult() {
        return allowedResult.getText();
    }

    public String getCountryResult() {
        return originCountryResuly.getText();
    }

    public String getbirthDayResult() {
        return birthDayResult.getText();
    }


}
