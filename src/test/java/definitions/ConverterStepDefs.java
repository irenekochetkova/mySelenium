package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ConverterStepDefs {
    @When("^I click on \"([^\"]*)\"$")
    public void iClickOn(String tab) throws Throwable {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'" + tab + "')]")).click();


    }

    @And("^I set \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iSetTo(String from, String to) throws Throwable {
        WebElement fromUnit = getDriver().findElement(By.xpath("//select[@id='calFrom']"));
        new Select(fromUnit).selectByVisibleText(from);
        WebElement toUnit = getDriver().findElement(By.xpath("//select[@id='calTo']"));
        new Select(toUnit).selectByVisibleText(to);
    }

    @Then("^I enter into From field \"([^\"]*)\" and verify \"([^\"]*)\" result$")
    public void iEnterIntoFromFieldAndVerifyResult(String from, String to) throws Throwable {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(from);
        String result = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        System.out.println("RESULT" +result);
        assertThat(result).contains(to);

    }

}
