package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.SampleForm;
import pages.SampleResult;

import static org.assertj.core.api.Assertions.assertThat;

public class FormStepDefs {
    @Given("^I open sample form$")
    public void iOpenSampleForm() throws Throwable {
        new SampleForm().open();
    }

    @And("^I fill out sample fields$")
    public void iFillOutSampleFields() throws Throwable {
        SampleForm form = new SampleForm();
        form.fillUsername("irina");
        form.fillName("Irina", "kochetkova");
        form.fillEmail("irina@gmail.com");
        form.fillPassword("123456fg");
        form.fillConfirmPassword("123456fg");
        form.agreedCheck();
        form.countrySelect("Russia");
        form.fillAddress("Rostov-on-don");
        form.checkGender();
        form.selectCar("Ford");
        form.dateBirth("Apr", "2", "1973");
        form.CheckAllowedContact();
        form.submitForm();

        Thread.sleep(5000);
    }

    @Then("^I verify sample result$")
    public void iVerifySampleResult() throws Throwable {

        SampleResult formResult = new SampleResult();

        assertThat(formResult.getPasswordResult()).doesNotContain("123456fg");
        assertThat((formResult.getNameResult())).contains("Irina kochetkova");
        assertThat((formResult.getAddressResult())).contains("Rostov-on-don");
        assertThat((formResult.getAllowedResult())).isEqualTo("true");
        assertThat((formResult.getCountryResult())).contains("Russia");
        assertThat((formResult.getbirthDayResult())).contains("04/02/1973");
    }

}
