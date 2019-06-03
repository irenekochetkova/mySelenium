package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import pages.CalculatorHome;
import pages.ConverterHome;
import pages.UpsHome;
import pages.UspsHome;

public class GoToHomePageStepDefs {
    @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String page) throws Throwable {
        switch (page) {
            case "usps":
                new UspsHome().open();
                break;
            case "converter":
                new ConverterHome().open();
                break;
            case "calculator":
                new CalculatorHome().open();
                break;
            case "ups":
                new UpsHome().open();
                break;
            default:
                throw new RuntimeException("Unrecognized page " + page);
        }
    }
}
