package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class UspsPostalStore extends Page {

    @FindBy(xpath = "//div[text()='Price']/..")
    private WebElement price;

    @FindBy(xpath = "//select[@id='Ns']")
    private WebElement sortBy;

    @FindBy(xpath = "//div[@class='result-page-stamps-holder '][1]")
    private WebElement firstFoundItem;

    private WebElement getFoundItem(int position) {
        return getDriver().findElement(By.xpath("//div[@class='result-page-stamps-holder '][" + position + "]"));
    }

    public String getPriceFilters() {
        return price.getText();
    }

    public void sortBy(String how) {
        new Select(sortBy).selectByVisibleText(how);
    }

    public String getFirstFoundItem() {
        return getFoundItem(1).getText();
    }

}
