package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UpsDestinationShipment;
import pages.UpsHome;
import pages.UpsOriginShipment;
import pages.UpsPackaging;

import static org.assertj.core.api.Assertions.assertThat;


public class UpsObjStepDefs {
    @And("^I open Shipping menu on the page$")
    public void iOpenShippingMenuOnThePage() throws Throwable {
        UpsHome menuShipping = new UpsHome();
        menuShipping.getShipping();
        
    }

    @And("^I go to Create a Shipment on the page$")
    public void iGoToCreateAShipmentOnThePage() throws Throwable {
        new UpsHome().getShipment();
    }

    @When("^I fill out origin shipment fields on the page$")
    public void iFillOutOriginShipmentFieldsOnThePage() throws Throwable {
        UpsOriginShipment form = new UpsOriginShipment();
        form.sendNameOrigin();
        form.sendStreetOrigin();
        form.sendZipOrigin();
        form.getOriginCity();
        form.selectState();
        form.sendEmail();
        form.sendPhone();
    }

    @And("^I submit the shipment form of the page$")
    public void iSubmitTheShipmentFormOfThePage() throws Throwable {
        UpsOriginShipment form = new UpsOriginShipment();
        form.getCurrentUrl("payment");
    }

    @Then("^I verify origin shipment fields on the page submitted$")
    public void iVerifyOriginShipmentFieldsOnThePageSubmitted() throws Throwable {
        UpsDestinationShipment result = new UpsDestinationShipment();
        String actualResult = result.actualResultOrigin();

        assertThat(actualResult).contains(result.verifyResultOrigin("name"));
        assertThat(actualResult).contains(result.verifyResultOrigin("street"));
        assertThat(actualResult).contains(result.verifyResultOrigin("zip"));
        assertThat(actualResult).contains(result.verifyResultOrigin("email"));
        assertThat(actualResult).contains(result.verifyResultOrigin("phone"));
    }

    @When("^I fill out destination shipment fields on the page$")
    public void iFillOutDestinationShipmentFieldsOnThePage() throws Throwable {
        UpsDestinationShipment form = new UpsDestinationShipment();
        form.sendDestinationName();
        form.sendDestinationStreet();
        form.sendDestinationZip();
        form.getDestinCity();
        form.selectStateDestin();
    }

    @Then("^I verify total charges appear on the page$")
    public void iVerifyTotalChargesAppearOnThePage() throws Throwable {
        new UpsDestinationShipment().verifyTotalCharges();
    }

    @And("^I set packaging type on the page$")
    public void iSetPackagingTypeOnThePage() throws Throwable {
        new UpsPackaging().selectPackage();
    }

    @Then("^I verify total charges changed on the page$")
    public void iVerifyTotalChargesChangedOnThePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
