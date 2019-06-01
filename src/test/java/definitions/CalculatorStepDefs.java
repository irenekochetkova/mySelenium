package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class CalculatorStepDefs {
    @When("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String calc) throws Throwable {
        getDriver().findElement(By.xpath("//a[contains(text(),'"+ calc +"')]")).click();
    }

    @And("^I clear all calculator fields$")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();
    }

    @And("^I calculate$")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//body//input[@value='Calculate']")).click();
    }

    @Then("^I verify \"([^\"]*)\" calculator error$")
    public void iVerifyCalculatorError(String error) throws Throwable {
        WebElement line = getDriver().findElement(By.xpath("//td[@valign='top'][2]"));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@valign='top'][2]")));
        assertThat(line.getText()).contains(error);
    }

    @And("^I enter \"([^\"]*)\" price, \"([^\"]*)\" months, \"([^\"]*)\" interest, \"([^\"]*)\"  downpayment, \"([^\"]*)\" trade-in, \"([^\"]*)\" state, \"([^\"]*)\" percent tax, \"([^\"]*)\" fees$")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downpayment, String tradeIn, String state, String tax, String fees) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(months);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradeIn);

        WebElement item = getDriver().findElement(By.xpath("//select[@name='cstate']"));
        new Select(item).selectByVisibleText(state);

        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(tax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);

    }

    @Then("^I verify monthly pay is \"([^\"]*)\"$")
    public void iVerifyMonthlyPayIs(String monthlyPay) throws Throwable {
        By section = By.xpath("//td[@valign='top'][2]");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(section));

        String monthly = getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText();
        assertThat(monthly).contains(monthlyPay);

    }
}

