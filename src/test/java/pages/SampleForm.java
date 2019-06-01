package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class SampleForm extends Page {
    public SampleForm() {
        setUrl("https://skryabin.com/webdriver/html/sample.html");
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement agreedOpton;

    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement address;

    @FindBy(xpath = "//select[@name='countryOfOrigin']")
    private WebElement countryOfOrigin;

    @FindBy(xpath = "//input[@value='female']")
    private WebElement gender;

    @FindBy(xpath = "//select[@name='carMake']")
    private WebElement car;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    private WebElement monthBirth;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    private WebElement yearBirth;

    @FindBy(xpath = "//input[@name='allowedToContact']")
    private WebElement checkContact;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submitButton;

    // dialog

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        click(saveButton);
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        click(saveButton);
    }


    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.sendKeys(value);
    }

    public void fillConfirmPassword(String value) {
        confirmPassword.sendKeys(value);
    }

    public void agreedCheck() {
        agreedOpton.click();
    }

    public void countrySelect(String value) {
        new Select(countryOfOrigin).selectByVisibleText(value);
    }

    public void fillAddress(String value) {
        address.sendKeys(value);
    }

    public void checkGender() {
        gender.click();
    }

    public void selectCar(String value) {
        new Select(car).selectByVisibleText(value);
    }

    public void dateBirth(String valueMonth, String valueDay, String valueYear) {
        dateOfBirth.click();
        new Select(monthBirth).selectByVisibleText(valueMonth);
        new Select(yearBirth).selectByVisibleText(valueYear);
        WebElement element = getDriver().findElement(By.xpath("//a[contains(text(),'"+ valueDay +"')]"));
        element.click();
    }

    public void CheckAllowedContact() {
        clickWithJS(checkContact);

    }
    public void submitForm() {
        click(submitButton);
    }






}
