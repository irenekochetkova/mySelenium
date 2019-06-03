package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.*;

public class Page {

    private String url;


    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void open() {
        getDriver().get(url);
    }

    protected void clickWithJS(WebElement element) {
        getExecutor().executeScript("arguments[0].click();", element);
    }

    protected void click(WebElement element) {
        waitForClickable(element);
        try {
            element.click();
        } catch (WebDriverException e) {
            clickWithJS(element);
        }
    }

    private void waitForClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElement(WebElement element) {
        getWait().until(driver -> element.getText().length() > 0);
    }

    public void forActionMove(WebElement element) {
        new Actions(getDriver()).moveToElement(element).perform();
    }

    public void forSelectByValue(WebElement element, String valueOption) {
        new Select(element).selectByValue(valueOption);
    }

    public void forSelectByText(WebElement element, String textOption) {
        new Select(element).selectByVisibleText(textOption);
    }

    public void waitForSelected(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitForPresent(WebElement element, String value) {
        getWait().until(ExpectedConditions.textToBePresentInElementValue(element, value));
    }

    public void waitVisibilityOfElement(By el) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(el));
    }



    private String oldUrl = getDriver().getCurrentUrl();

    public void waitForUrl() {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));
    }

    public void waitForElementIsNotEmpty(WebElement element) {
        getWait().until(driver -> !element.getText().isEmpty());
    }








}
