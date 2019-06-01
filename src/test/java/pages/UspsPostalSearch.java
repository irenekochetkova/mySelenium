package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsPostalSearch extends Page {
    @FindBy(xpath = "//input[@id='store-search']")
    private WebElement search;

    @FindBy(xpath = "//input[@id='store-search-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='no-results-found']")
    private WebElement noResult;

    @FindBy(xpath = "//div[@class='result-products-holder']")
    private WebElement foundResult;

    public void getSearch(String el) {
        search.sendKeys(el);
    }

    public void getSearchButton() {
        click(searchButton);
    }

    public boolean getNoResult() {
         return noResult.isDisplayed();
    }

    public boolean getFoundResult() {
        return foundResult.isDisplayed();
    }


}
