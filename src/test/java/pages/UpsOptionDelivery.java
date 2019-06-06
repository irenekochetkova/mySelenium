package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import static support.TestContext.getDriver;

public class UpsOptionDelivery extends Page {

    @FindAll({
            @FindBy(xpath = "//fieldset//p/strong")
    })
    private List<WebElement> options;

    Locale locale = new Locale("en", "US");
    NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);



    private double getCheapestValue() throws ParseException {
        double cheapestValue = Double.MAX_VALUE;
        for (WebElement option : options) {
            if (option.isDisplayed()) {
                double currentValue = formatter.parse(option.getText()).doubleValue();
                if (currentValue < cheapestValue) {
                    cheapestValue = currentValue;

                }
            }
        }

        return cheapestValue;
    }

    public void getCheapestElement() throws ParseException {
        WebElement cheapestElement = getDriver().findElement(By.xpath("//fieldset//p/strong[contains(text(),'" +
                formatter.format(getCheapestValue()) + "')]"));
//        System.out.println(cheapestElement);
        click(cheapestElement);
    }
}


//getLocale("en", "US")