package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UspsPostcalc extends Page {
    @FindBy(xpath = "//select[@id='CountryID']")
    private WebElement country;

    private WebElement getShape(String value) {
        return getDriver().findElement(By.xpath("//input[@value='" + value + "']"));
    }

    public void selectCountry(String valueCountry) {
        forSelectByValue(country, valueCountry);
    }

    public void selectShape(String valueShape) {
        getShape(valueShape).click();
    }

}
