package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

//import static org.openqa.selenium.By.xpath;

public class WebDriverStepDefs {
    @Given("^I go to \"([^\"]*)\" page$")
    public void iGoToPage(String page) throws Throwable {
        if (page.equalsIgnoreCase("sample")) {
            getDriver().get("https://skryabin.com/webdriver/html/sample.html");
        } else if (page.equalsIgnoreCase("google")) {
            getDriver().get("https://www.google.com/");
        } else if (page.equalsIgnoreCase("yahoo")) {
            getDriver().get("https://www.yahoo.com/");
        } else if (page.equalsIgnoreCase("usps")) {
            getDriver().get("https://www.usps.com/");
        } else if (page.equalsIgnoreCase("ups")) {
            getDriver().get("https://www.ups.com/us/en/Home.page");
        } else if (page.equalsIgnoreCase("workday")) {
            getDriver().get("https://workday.wd5.myworkdayjobs.com/Workday");
        } else if (page.equalsIgnoreCase("converter")) {
            getDriver().get("https://www.unitconverters.net");
        } else if (page.equalsIgnoreCase("calculator")) {
            getDriver().get("https://www.calculator.net");
        } else {
            throw new RuntimeException("Not supported page: " + page);
        }
    }

    @And("^I print page details$")
    public void iPrintPageDetails() {
        System.out.println("Url: " + getDriver().getCurrentUrl());
        System.out.println("Title: " + getDriver().getTitle());
        System.out.println("Handles: " + getDriver().getWindowHandles());
        System.out.println("Source: " + getDriver().getPageSource());
    }

    @And("^I go back and forward, then refresh the page$")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("^I print logs to the console$")
    public void iPrintLogsToTheConsole() {
        LogEntries logs = getDriver().manage().logs().get("browser");


        for(LogEntry log : logs) {
            System.out.println(log);
        }
    }

    @And("^I fill out required fields$")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Irina");
        getDriver().findElement(By.xpath("//input[@id='middleName']")).sendKeys("Nikolaevna");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kochetkova");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("irenekochetkova");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("irenekochetkova@gmail.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("veterok");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("veterok");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("^I fill out other fields$")
    public void iFillOutOtherFields() {
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']/option[@value='Russia']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("Rostov-on-Don");
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("6508344848");
        getDriver().findElement(By.xpath("//label[3]//input[1]")).click();
        getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='Toyota']")).click();
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//select[@data-handler='selectMonth']/option[4]")).click();
        getDriver().findElement(By.xpath("//select[@data-handler='selectYear']/option[@value='1973']")).click();
        getDriver().findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='2']")).click();

        WebElement allowedToContact = getDriver().findElement(By.xpath("//input[@name='allowedToContact']"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", allowedToContact);

        getDriver().switchTo().frame(0);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys("3546263434");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys("Irina");
        getDriver().switchTo().defaultContent();

        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        getDriver().switchTo().alert().accept();

//        getDriver().findElement(xpath("//input[@id='relatedDocuments']")).click();
//        getDriver().switchTo().window();

    }


    // From Slava code
//    @And("^I fill out required fields$")
//    public void iFillOutRequiredFields() throws Throwable {
//        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("skryabin");
//        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("slava@skryabin.com");
//        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("welcome");
//        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("welcome");
//        iFillNameAs("Slava", "Skryabin");
//        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
//    }
//
//    @When("^I fill name as \"([^\"]*)\" \"([^\"]*)\"$")
//    public void iFillNameAs(String firstName, String lastName) throws InterruptedException {
//        getDriver().findElement(By.xpath("//input[@id='name']")).click();
//        getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
//        getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
//        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
//    }


    @And("^I submit the page$")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @When("^I verify email field behavior$")
    public void iVerifyEmailFieldBehavior() {
        WebElement str = getDriver().findElement(By.xpath("//input[@name='email']"));

        str.clear();
        str.sendKeys("kochetkova");
        str.sendKeys("\u0008");
        str.clear();
        str.sendKeys("irenekochetkova@gmail.com");
    }

    @Then("^I verify required fields$")
    public void iVerifyRequiredFields() {
//        By section = By.xpath("//div[@id='samplePageResult ']//section");
//
//        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(section));
//
//        String result = getDriver().findElement(section).getText();
//        System.out.println(result);
//
//        assertThat(result).containsIgnoringCase("Irina");
////        assertThat(result).containsIgnoringCase("Kochetkova");
////        assertThat(result).containsIgnoringCase("Nikolaevna");
////        assertThat(result).doesNotContain("veterok");

        By section = By.xpath("//div[@id='samplePageResult']//section");

        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(section));

        String result = getDriver().findElement(section).getText();
        System.out.println(result);
        assertThat(result).containsIgnoringCase("Irina");

        String agreed = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(agreed).contains("true");
    }
}
