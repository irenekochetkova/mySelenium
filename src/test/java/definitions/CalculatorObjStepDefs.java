package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CalculatorAutoLoan;
import pages.CalculatorHome;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorObjStepDefs {
    @When("^I go to \"([^\"]*)\" calculator page$")
    public void iGoToCalculatorPage(String link) throws Throwable {
        switch (link) {
            case "Auto Loan Calculator":
                new CalculatorHome().getAutoLoan();
                break;
            default:
                throw new RuntimeException("Unrecognized link: " + link);
        }
    }

    @And("^I clear all calculator fields on the page$")
    public void iClearAllCalculatorFieldsOnThePage() throws Throwable {
        new CalculatorAutoLoan().clearForm();

    }

    @And("^I click calculate$")
    public void iClickCalculate() throws Throwable {
        new CalculatorAutoLoan().clickCalculate();
    }

    @Then("^I verify \"([^\"]*)\" calculator error on the page$")
    public void iVerifyCalculatorErrorOnThePage(String error) throws Throwable {
        CalculatorAutoLoan result =  new CalculatorAutoLoan();
        assertThat(result.getError()).contains(error);
    }

    @And("^I enter \"([^\"]*)\" price, \"([^\"]*)\" months, \"([^\"]*)\" interest, \"([^\"]*)\"  downpayment, \"([^\"]*)\" trade-in, \"([^\"]*)\" state, \"([^\"]*)\" percent tax, \"([^\"]*)\" fees on the calculate page$")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFeesOnTheCalculatePage(String price, String months, String interest, String downpayment, String trade, String state, String tax, String fees) throws Throwable {
        CalculatorAutoLoan form =  new CalculatorAutoLoan();
        form.loanPrice(price);
        form.loanMonths(months);
        form.loaninterest(interest);
        form.loanDownpayment(downpayment);
        form.loanTrade(trade);
        form.loanState(state);
        form.loanTax(tax);
        form.loanFees(fees);
    }

    @Then("^I verify monthly pay is \"([^\"]*)\" on the page$")
    public void iVerifyMonthlyPayIsOnThePage(String monthly) throws Throwable {
        CalculatorAutoLoan result =  new CalculatorAutoLoan();
        assertThat(result.getError()).contains(monthly);
    }
}
