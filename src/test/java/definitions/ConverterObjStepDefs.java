package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ConverterHome;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterObjStepDefs {
    @When("^I click on \"([^\"]*)\" tab$")
    public void iClickOnTab(String tab) throws Throwable {
        new ConverterHome().getTabToConvert(tab);
    }

    @And("^I set from \"([^\"]*)\"  to \"([^\"]*)\"$")
    public void iSetFromTo(String from, String to) throws Throwable {
        new ConverterHome().setCalFrom(from);
        new ConverterHome().setCalTo(to);
    }

    @Then("^I enter into From field \"([^\"]*)\" and verify \"([^\"]*)\" result of conversion$")
    public void iEnterIntoFromFieldAndVerifyResultOfConversion(String from, String to) throws Throwable {
        ConverterHome result = new ConverterHome();
        result.getFieldFrom(from);
        assertThat(result.getFieldTo()).contains(to);
    }

}
