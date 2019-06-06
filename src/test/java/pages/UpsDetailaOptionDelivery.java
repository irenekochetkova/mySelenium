package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UpsDetailaOptionDelivery extends Page {

    private By section = By.xpath("//div[contains(@class,'ups-toggle_list')]");

     @FindBy(xpath = "//saturday-delivery-option//span[contains(@class,'lever_switch_no')]")
     private WebElement day;

     public void setDay() {
         waitVisibilityOfElement(section);
         click(day);
     }



}
