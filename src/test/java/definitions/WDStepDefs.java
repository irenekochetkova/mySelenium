package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class WDStepDefs {
    @Given("^I open workday careers$")
    public void iOpenWorkdayCareers() {
        getDriver().get("https://workday.wd5.myworkdayjobs.com/Workday");
    }

    @When("^I select any position$")
    public void iSelectAnyPosition() {

        List<WebElement> jobs = getDriver().findElements(By.xpath("//*[@data-automation-id='promptOption']"));
        int jobIndex = new Random().nextInt(jobs.size());
        jobs.get(jobIndex).click();
    }

    @And("^I go to apply with LinkedIn$")
    public void iGoToApplyWithLinkedIn() throws InterruptedException {
        WebElement outerFrame = getDriver().findElement(By.xpath("(//iframe[@data-automation-id='applyWithLinkedinFrame'])[1]"));
        getDriver().switchTo().frame(outerFrame);

        WebElement linkedInFrame = getDriver().findElement(By.xpath("//iframe[contains(@src,'linkedin.com')]"));
        getDriver().switchTo().frame(linkedInFrame);

        By linkedInButton = By.xpath("//button[contains(@name,'awli-button-member')]");
        Thread.sleep(1000);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(linkedInButton));
        getDriver().findElement(linkedInButton).click();
    }

    @Then("^I verify Oauth page opens$")
    public void iVerifyOauthPageOpens() {
        String originalHandle = getDriver().getWindowHandle();
        System.out.println("originalHandle: " + originalHandle);

        for(String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
            System.out.println("handle: " + handle);
        }

        String title = getDriver().getTitle();
        assertThat(title).contains("LinkedIn");

        getDriver().switchTo().window(originalHandle);
    }
}
