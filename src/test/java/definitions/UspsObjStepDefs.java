package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UspsObjStepDefs {
    @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String page) throws Throwable {
        switch (page) {
            case "usps":
                new UspsHome().open();
                break;
            default:
                throw new RuntimeException("Unrecognized page " + page);
        }
    }

    @When("^I go to \"([^\"]*)\"$")
    public void iGoTo(String link) throws Throwable {
        switch (link) {
            case "stamps":
                new UspsHome().clickStamps();
                break;
            case "boxes":
                new UspsHome().clickBoxes();
                break;
            case "Lookup ZIP":
                new UspsHome().moveToLink();
                new UspsHome().clickLookUpZip();
                new UspsHome().clickByAddress();
                break;
            case "Calculate Price":
                new UspsHome().moveToLink();
                new UspsHome().clickCalculatePrice();
                break;
            case "Postal Store":
                new UspsHome().clickPostal();
                break;
            default:
                throw new RuntimeException("Unrecognized link: " + link);
        }
    }

    @Then("^I verify \"([^\"]*)\" section exists$")
    public void iVerifySectionExists(String filterText) throws Throwable {
        String priceFilters = new UspsPostalStore().getPriceFilters();
        assertThat(priceFilters).contains(filterText); 
    }

    @When("^I sort by \"([^\"]*)\"$")
    public void iSortBy(String how) throws Throwable {
        new UspsPostalStore().sortBy(how);
    }

    @Then("^I verify that \"([^\"]*)\" is cheapest$")
    public void iVerifyThatIsCheapest(String item) throws Throwable {
        String firstFound = new UspsPostalStore().getFirstFoundItem();
        assertThat(firstFound).contains(item);
    }

    // Task usps_obj3  Validate ZIP code page object

    @And("^I fill out \"([^\"]*)\" street, \"([^\"]*)\" city, \"([^\"]*)\" state page object$")
    public void iFillOutStreetCityStatePageObject(String street, String city, String valueState) throws Throwable {
        UspsZipCode fillForm = new UspsZipCode();
        fillForm.sendStreet(street);
        fillForm.sendCity(city);
        fillForm.selectState(valueState);
        fillForm.clickFindButton();
    }

    @Then("^I validate \"([^\"]*)\" zip code exists in the result page object$")
    public void iValidateZipCodeExistsInTheResultPageObject(String zip) throws Throwable {
        UspsResultZip resultZip = new UspsResultZip();
        resultZip.waitResultZip();
        String rez = resultZip.getResultZip();
        assertThat(rez).contains(zip);
        System.out.println("rez" + rez);
    }

    // Task usps_obj4  Calculate price logic page object

    @And("^I select \"([^\"]*)\" with \"([^\"]*)\" shape page object$")
    public void iSelectWithShapePageObject(String country, String shape) throws Throwable {
        UspsPostcalc postCalc = new UspsPostcalc();

        switch (country) {
            case "United Kingdom":
                postCalc.selectCountry("10142");
                break;
            case "United States":
                postCalc.selectCountry("0");
                break;
            default:
                throw new RuntimeException("Unrecognized link: " + country);
        }

        postCalc.selectShape(shape);

    }

    @And("^I define \"([^\"]*)\" quantity page object$")
    public void iDefineQuantityPageObject(String quantity) throws Throwable {
        UspsPrice total = new UspsPrice();
        total.defineQuantity(quantity);
    }

    @Then("^I calculate the price and validate cost is \"([^\"]*)\" page object$")
    public void iCalculateThePriceAndValidateCostIsPageObject(String expectedTotal) throws Throwable {
        new UspsPrice().getCalculate();
        assertThat(new UspsPrice().getTotal()).contains(expectedTotal);
    }


    // Task usps_obj5  Wrong store id does not match page object

    @And("^I enter \"([^\"]*)\" into store search page object$")
    public void iEnterIntoStoreSearchPageObject(String keyword) throws Throwable {
        new UspsPostalSearch().getSearch(keyword);
    }

    @Then("^I search and validate no products found page object$")
    public void iSearchAndValidateNoProductsFoundPageObject() throws Throwable {
        new UspsPostalSearch().getSearchButton();
        assertThat(new UspsPostalSearch().getNoResult()).isTrue();
    }
}
