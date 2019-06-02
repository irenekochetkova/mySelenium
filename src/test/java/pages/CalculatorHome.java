package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorHome extends Page {
    public CalculatorHome() {
        setUrl("https://www.calculator.net/");
    }

    @FindBy(xpath = "//a[contains(text(),'Auto Loan Calculator')]")
    private WebElement autoLoan;

    public void getAutoLoan() {
        autoLoan.click();
    }
}
