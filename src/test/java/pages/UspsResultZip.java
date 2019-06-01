package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsResultZip extends Page {

    @FindBy(xpath = "//div[@id='zipByAddressDiv']")
    private WebElement result;

    public void waitResultZip() {
        waitForElement(result);
    }

    public String getResultZip() {
        return result.getText();
    }

}
