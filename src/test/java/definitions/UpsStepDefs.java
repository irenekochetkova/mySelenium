package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;


public class UpsStepDefs {

    @Given("^I navigate to UPS page$")
    public void iNavigateToUPSPage() {

        getDriver().get("https://www.ups.com/us/en/Home.page");
    }

    @And("^I open Shipping menu$")
    public void iOpenShippingMenu() {

        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks1']")).click();
    }

    @And("^I go to Create a Shipment$")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//a[contains(@href,'ship?loc')][not(@id='ups-quickStartShip')]")).click();
    }

    @When("^I fill out origin shipment fields$")
    public void iFillOutOriginShipmentFields() throws InterruptedException, FileNotFoundException {
        HashMap<String, String> sender = getSender();

        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys(sender.get("name"));
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys(sender.get("street"));

        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys(sender.get("zip"));

        getWait().until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='origincity']"), sender.get("city")));
        getWait().until(ExpectedConditions.elementToBeSelected(By.xpath("//select[@id='originstate']/option[text()='" + sender.get("state") + "']")));

        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys(sender.get("email"));
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys(sender.get("phone"));
        Thread.sleep(1000);

    }

    @And("^I submit the shipment form$")
    public void iSubmitTheShipmentForm() throws InterruptedException {

        String oldUrl = getDriver().getCurrentUrl();
        if (getDriver().getCurrentUrl().contains("payment")) {
            Thread.sleep(1000);
            getExecutor().executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']")));
        } else {
            getExecutor().executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")));
        }
       new WebDriverWait(getDriver(), 10).until(ExpectedConditions.not(ExpectedConditions.urlToBe(oldUrl)));

        // My code
//        if (getDriver().findElements(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']")).size() > 0) {
//            WebElement buttonContinue = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationContinueButton']"));
//            getExecutor().executeScript("arguments[0].click();", buttonContinue);
//        } else if (getDriver().findElements(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']")).size() > 0) {
//            WebElement buttonReview = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']"));
//            getExecutor().executeScript("arguments[0].click();", buttonReview);
//        } else {
//            System.out.println("No such button");
//        }
    }

    @Then("^I verify origin shipment fields submitted$")
    public void iVerifyOriginShipmentFieldsSubmitted() throws FileNotFoundException, InterruptedException {
        WebElement fromFields = getDriver().findElement(By.xpath("//agent-summary"));
        getWait().until(driver -> !fromFields.getText().isEmpty());
        String actualText = fromFields.getText();

        assertThat(actualText).contains(getSender().get("name"));
        assertThat(actualText).contains(getSender().get("street"));
        assertThat(actualText).contains(getSender().get("zip"));
        assertThat(actualText).contains(getSender().get("email"));
        assertThat(actualText).contains(getSender().get("phone"));
        System.out.println(actualText);
        System.out.println("");
        Thread.sleep(2000);
    }

    @And("^I cancel the shipment form$")
    public void iCancelTheShipmentForm() {
        //code Slava
//        getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']")).click();
//        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();

     // My code
        WebElement buttonCancel = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationCancelShipmentButton']"));
        getExecutor().executeScript("arguments[0].click();", buttonCancel);
        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();


    }

    @Then("^I verify shipment form is reset$")
    public void iVerifyShipmentFormIsReset() throws InterruptedException {
        String name = getDriver().findElement(By.xpath("//input[@id='originname']")).getAttribute("value");
        assertThat(name).isEmpty();
    }

    // Part 2


    @When("^I fill out destination shipment fields$")
    public void iFillOutDestinationShipmentFields() throws FileNotFoundException {
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys(getReceiver().get("name"));
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys(getReceiver().get("street"));
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys(getReceiver().get("zip"));

        getWait().until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//input[@id='destinationcity']"), getReceiver().get("city").toUpperCase()));
        getWait().until(ExpectedConditions.elementToBeSelected(By.xpath("//select[@id='destinationstate']/option[text()='" + getReceiver().get("state") + "']")));

    }

    @Then("^I verify total charges appear$")
    public void iVerifyTotalChargesAppear() {
        //my code
//        WebElement charge = getDriver().findElement(By.xpath("//h2[@class='ng-tns-c1-0']"));
//        getWait().until(driver -> !charge.getText().isEmpty());
//        String actualText = charge.getText();
//
//        assertThat(actualText).contains("Total Charges");
//        System.out.println(actualText);

        By spinner = By.xpath("//span[@id='total-charges-spinner']");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(spinner));
    }

    @And("^I set packaging type$")
    public void iSetPackagingType() throws InterruptedException {
        //my code
//        By packaging = By.xpath("//section[@class='ups-section']");
//        getWait().until(ExpectedConditions.visibilityOfElementLocated(packaging));
//        getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']/option[contains(text(),'Small')]")).click();
//        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("1");

        WebElement element = getDriver().findElement(By.xpath("//select[@id='nbsPackagePackagingTypeDropdown0']"));
        new Select(element).selectByVisibleText("UPS Letter");
    }

    @Then("^I verify total charges changed$")
    public void iVerifyTotalChargesChanged() {
        // my code does not work
//        WebElement charge = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']"));
//        getWait().until(driver -> !charge.getText().isEmpty());
//        String actualText = charge.getText();
//
//        assertThat(actualText).contains("Total Charges");
//        System.out.println(actualText);

        By spinner = By.xpath("//span[@id='total-charges-spinner']");
        String oldText = getDriver().findElement(spinner).getText();
        getWait().until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(spinner, oldText)));
        getWait().until(driver -> !driver.findElement(spinner).getText().equals(oldText));


    }


    @And("^I select cheapest delivery option$")
    public void iSelectCheapestDeliveryOption() throws InterruptedException, ParseException {
        //my code
//        By section = By.xpath("//div[contains(@class,'ups-shipping_schedule_row')]");
//        getWait().until(ExpectedConditions.visibilityOfElementLocated(section));
//
//        List<WebElement> charges = getDriver().findElements(By.xpath("//p[contains(@id,'nbsServiceTileTotalCharge')]/strong"));
//
//        Double[] arrPrices = new Double[charges.size()];
//
//        double minPrice = Integer.MAX_VALUE;
//        System.out.println("MINIMUM" + minPrice);
//
//        for (int i = 0; i < charges.size(); i++) {
//            arrPrices[i] = Double.parseDouble(charges.get(i).getText().substring(1));
//            System.out.println("");
//            System.out.println(charges.get(i).getText().substring(1));
//            System.out.println("");
//            if (arrPrices[i] < minPrice) {
//                minPrice = arrPrices[i];
//            }
//        }
//
//        System.out.println("MINIMUM PRICE" + minPrice);
//        System.out.println("");
//        System.out.println("PRICE" + arrPrices);
//
//        WebElement element = getDriver().findElement(By.xpath("//strong[text()='$"+minPrice+"']"));
//        System.out.println("Element" + element);
//        getExecutor().executeScript("arguments[0].click();", element);

        List<WebElement> prices = getDriver().findElements(By.xpath("//fieldset//p/strong"));
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);

        double cheapestValue = Double.MAX_VALUE;
        for (WebElement price : prices) {
            if (price.isDisplayed()) {
                double currentValue = formatter.parse(price.getText()).doubleValue();
                if (currentValue < cheapestValue) {
                    cheapestValue = currentValue;
                }
            }
        }
        System.out.println(cheapestValue);
        WebElement cheapestElement = getDriver().findElement(By.xpath("//fieldset//p/strong[contains(text(),'" + formatter.format(cheapestValue) + "')]"));
        getExecutor().executeScript("arguments[0].click();", cheapestElement);
        System.out.println();

    }

    @And("^I set Saturday Delivery type$")
    public void iSetSaturdayDeliveryType() {
        By section = By.xpath("//div[contains(@class,'ups-toggle_list')]");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(section));

        WebElement element = getDriver().findElement(By.xpath("//saturday-delivery-option//span[contains(@class,'lever_switch_no')]"));
        getExecutor().executeScript("arguments[0].click();", element);
    }

    @And("^I select Paypal payment type$")
    public void iSelectPaypalPaymentType() {
        By section = By.xpath("//section[@class='ups-section']");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(section));

        getDriver().findElement(By.xpath("//div[@id='tile-4']//label[contains(@class,'ups-tile_button_content')]")).click();


    }

    @Then("^I review all recorded details on the review page$")
    public void iReviewAllRecordedDetailsOnTheReviewPage() throws FileNotFoundException {

        WebElement fromFields = getDriver().findElement(By.xpath("//section[@class='ups-group']"));
        getWait().until(driver -> !fromFields.getText().isEmpty());
        String actualText = fromFields.getText();

        assertThat(actualText).contains(getSender().get("name"));
        assertThat(actualText).contains(getSender().get("street"));
        assertThat(actualText).contains(getSender().get("zip"));
        assertThat(actualText).contains(getSender().get("email"));
        assertThat(actualText).contains(getSender().get("phone"));
        assertThat(actualText).contains(getReceiver().get("name"));
        assertThat(actualText).contains(getReceiver().get("street"));
        assertThat(actualText).contains(getReceiver().get("zip"));
//        assertThat(actualText).contains(("box"));
//        assertThat(actualText).contains("1 lbs");
        assertThat(actualText).contains("Saturday Delivery");
        assertThat(actualText).contains("PayPal");
    }


}
