package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

import static support.TestContext.getDriver;

public class ConverterHome extends Page {
    public ConverterHome() {
        setUrl("https://www.unitconverters.net/");
    }

    @FindBy(xpath = "//select[@id='calFrom']")
    private WebElement calFrom;

    @FindBy(xpath = "//select[@id='calTo']")
    private WebElement calTo;

    @FindBy(xpath = "//input[@name='fromVal']")
    private WebElement fieldFrom;

    @FindBy(xpath = "//input[@name='toVal']")
    private WebElement fieldTo;

    private WebElement getTab(String tab) {
        return getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'"+ tab +"')]"));
    }

    public void getTabToConvert(String tab) {
        getTab(tab).click();
    }

    public void setCalFrom(String tabFrom) {
        forSelectByText(calFrom, tabFrom);
    }

    public void setCalTo(String tabTo) {
        forSelectByText(calTo, tabTo);
    }

    public void getFieldFrom(String from) {
        fieldFrom.sendKeys(from);
    }

    public String getFieldTo() {
        return fieldTo.getAttribute("value");
    }


}
