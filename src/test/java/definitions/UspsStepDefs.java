package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class UspsStepDefs {

    @When("^I go to Lookup ZIP by address$")
    public void iGoToLookupZIPByAddress() {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'Zip')][@class='button--link']")).click();
        getDriver().findElement(By.xpath("//a[contains(@class,'zip-code-address')]")).click();
    }

    @And("^I fill out \"([^\"]*)\" street, \"([^\"]*)\" city, \"([^\"]*)\" state$")
    public void iFillOutStreetCityState(String street, String city, String state) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("^I validate \"([^\"]*)\" zip code exists in the result$")
    public void iValidateZipCodeExistsInTheResult(String zip) throws Throwable {
        WebElement resultBlock = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(driver -> resultBlock.getText().length() > 0);

        assertThat(resultBlock.getText()).contains(zip);

        List<WebElement> list = getDriver().findElements(By.xpath("//li[contains(@class,'list-group-item')]"));
        for (WebElement item : list) {
            if (item.isDisplayed()) {
                System.out.println(item.getText());
                assertThat(item.getText()).contains(zip);
            }
        }
    }

    @When("^I go to Calculate Price page$")
    public void iGoToCalculatePricePage() {
        WebElement header = getDriver().findElement(By.xpath("//li[contains(@class,'qt-nav')]"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(header).perform();
        getDriver().findElement(By.xpath("//li[contains(@class,'qt-nav')]//a[contains(@href,'postcalc')]")).click();

    }

    @And("^I select \"([^\"]*)\" with \"([^\"]*)\" shape$")
    public void iSelectWithShape(String country, String shape) throws Throwable {
        String countryCode;
        if (country.equals("United Kingdom")) {
            countryCode = "10142";
        } else if (country.equals("United States")) {
            countryCode = "0";
        } else {
            throw new RuntimeException("Unsupported country" + country);
        }
        getDriver().findElement(By.xpath("//select[@id='CountryID']//option[@value='" + countryCode + "']")).click();
        getDriver().findElement(By.xpath("//input[@value='" + shape + "']")).click();

    }


    @And("^I defined \"([^\"]*)\" quantity$")
    public void iDefinedQuantity(String quantity) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }


    @Then("^I calculate the price and validate cost is \"([^\"]*)\"$")
    public void iCalculateThePriceAndValidateCostIs(String expectedTotal) throws Throwable {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        String actualTotal = getDriver().findElement(By.xpath("//div[@id='total']")).getText();

        assertThat(actualTotal).isEqualTo(expectedTotal);
    }


    @And("^I define \"([^\"]*)\" quantity$")
    public void iDefineQuantity(String quantity) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    //Task3


    @When("^I click Postal Store tab$")
    public void iClickPostalStoreTab() {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'Postal Store')]")).click();

    }

    @Then("^I enter \"([^\"]*)\" into search the Postal Store$")
    public void iEnterIntoSearchThePostalStore(String keyword) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='store-search']")).sendKeys(keyword);
        getDriver().findElement(By.xpath("//input[@id='store-search-btn']")).click();

    }

    @And("^verify search \"([^\"]*)\"$")
    public void verifySearch(String message) throws Throwable {
        By line = By.xpath("//div[@class='page-wrapper']");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(line));
        assertThat(getDriver().findElement(line).getText()).contains(message);
    }


    // Task 4

    @When("^I go to \"([^\"]*)\" tab$")
    public void iGoToTab(String tab) throws Throwable {
            WebElement header = getDriver().findElement(By.xpath("//li[contains(@class,'menuheader')][2]"));
            Actions actions = new Actions(getDriver());
            actions.moveToElement(header).perform();
            getDriver().findElement(By.xpath("//a[contains(text(),'Stamps & Supplies')]")).click();
    }

    @Then("^go to Stamps$")
    public void goToStamps() {
        getDriver().findElement(By.xpath("//li[contains(@class,'stamps-navigation')]//a")).click();
    }

    @And("^I select Mail Priority Mail$")
    public void iSelectMailPriorityMail() {
        getDriver().findElement(By.xpath("//label[contains(@for,'checkbox-type-Mail Service-Priority Mail-')]")).click();
    }

    @Then("^I verify (\\d+) item on the page$")
    public void iVerifyItemOnThePage(int amount) {
        By section = By.xpath("//div[@class='result-products-holder']");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(section));

        List<WebElement> stamps = getDriver().findElements(section);
        System.out.println(stamps.size());
        assertThat(stamps.size()).isEqualTo(amount);
    }



    //    Task5

    @And("^I unselect \"([^\"]*)\" checkbox$")
    public void iUnselectCheckbox(String arg0) throws Throwable {
        getDriver().findElement(By.xpath("//label[@for='checkbox-type-Category-Stamps']")).click();
    }

    @Then("^I select Size \"([^\"]*)\"$")
    public void iSelectSize(String size) throws Throwable {
        getDriver().findElement(By.xpath("//div[6]//p[7]//a[1]")).click();
        getDriver().findElement(By.xpath("//label[contains(text(),'"+ size +"')]")).click();
    }

    @And("^I click pink color$")
    public void iClickPinkColor() {
        getDriver().findElement(By.xpath("//div[contains(@class,'grid-color')]//div[3]")).click();
    }


    @Then("^I verify \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iVerifyAnd(String color, String size) throws Throwable {
        WebElement pinkX = getDriver().findElement(By.xpath("//span[contains(text(), 'Pink')][contains(@onclick, '24-months')]"));
        WebElement monthsX = getDriver().findElement(By.xpath("//span[contains(@onclick, 'pink')][contains(text(),'24 Months')]"));

        assertThat(pinkX.getText()).contains(color);
        assertThat(monthsX.getText()).contains(size);
    }

    @And("^verify \"([^\"]*)\" text$")
    public void verifyText(String name) throws Throwable {
        WebElement nameText = getDriver().findElement(By.xpath("//div[@class='results-product-desc']"));

        assertThat(nameText.getText()).contains(name);
    }

    @When("^I go to PO Boxes under Track & Manage$")
    public void iGoToPOBoxesUnderTrackManage() {
        WebElement header = getDriver().findElement(By.xpath("//a[contains(text(),'Track & Manage')]"));
        new Actions(getDriver()).moveToElement(header).perform();
        getDriver().findElement(By.xpath("//a[contains(@href,'po-boxes')][@role='menuitem']")).click();


    }

    @And("^I reserve new PO box for \"([^\"]*)\"$")
    public void iReserveNewPOBoxFor(String zip) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='searchInput']")).sendKeys(zip);
        getDriver().findElement(By.xpath("//span[@class='icon-search']")).click();
        Thread.sleep(5000);


    }

    @Then("^I verify that \"([^\"]*)\" present$")
    public void iVerifyThatPresent(String expected) throws Throwable {
        String actual = getDriver().findElement(By.xpath("//div[contains(@class, 'scrollingResults')]")).getText();
        assertThat(actual).contains(expected);
    }

    @And("^I verify that \"([^\"]*)\" PO Box is available in \"([^\"]*)\"$")
    public void iVerifyThatPOBoxIsAvailableIn(String expectedBox, String locationText) throws Throwable {
        getDriver().findElement(By.xpath("//h2[contains(string(),'" + locationText + "')]")).click();
        String actualBoxes = getDriver().findElement(By.xpath("//div[@id='availableboxes']")).getText();
        assertThat(actualBoxes).contains(expectedBox);
    }
}
