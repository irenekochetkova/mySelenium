package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

public class CalculatorAutoLoan extends Page {

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculate;

    @FindBy(xpath = "//td[@valign='top'][2]")
    private WebElement error;

    @FindBy(xpath = "//input[@id='cloanamount']")
    private WebElement price;

    @FindBy(xpath = "//input[@id='cloanterm']")
    private WebElement months;

    @FindBy(xpath = "//input[@id='cinterestrate']")
    private WebElement interest;

    @FindBy(xpath = "//input[@id='cdownpayment']")
    private WebElement downpayment;

    @FindBy(xpath = "//input[@id='ctradeinvalue']")
    private WebElement trade;

    @FindBy(xpath = "//select[@name='cstate']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='csaletax']")
    private WebElement tax;

    @FindBy(xpath = "//input[@id='ctitlereg']")
    private WebElement fees;

    @FindBy(xpath = "//h2[@class='h2result']")
    private WebElement monthlyPay;


    public void clearForm() {
        List<WebElement> list = getDriver().findElements(By.xpath("//tbody//td//input[@type='text'][not(@id='cmonthlypay')]"));
        for (WebElement item : list) {
            item.clear();
        }
    }

    public void clickCalculate() {
        click(calculate);
    }

    public String getError() {
        return error.getText();
    }

    public void loanPrice(String el) {
        price.sendKeys(el);
    }

    public void loanMonths(String el) {
        months.sendKeys(el);
    }

    public void loaninterest(String el) {
        interest.sendKeys(el);
    }

    public void loanDownpayment(String el) {
        downpayment.sendKeys(el);
    }

    public void loanTrade(String el) {
        trade.sendKeys(el);
    }

    public void loanState(String valueState) {
        forSelectByText(state, valueState);
    }

    public void loanTax(String el) {
        tax.sendKeys(el);
    }

    public void loanFees(String el) {
        fees.sendKeys(el);
    }

    public String getMonthlyPay(String payment) {
        return monthlyPay.getText();
    }

}
