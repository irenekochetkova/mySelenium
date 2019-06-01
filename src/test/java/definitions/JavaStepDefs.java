package definitions;

import cucumber.api.java.en.Given;
import pages.Animal;
import pages.Cat;
import pages.Dog;
import pages.Horse;

import java.util.ArrayList;
import java.util.HashMap;

public class JavaStepDefs {
    @Given("^I write my step$")
    public void iWriteMyStep() {
        System.out.println("Hello World");
         String firstName = "Slava";
         String lastName = "Skryabin";
         String favoriteColor = "blue";

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(favoriteColor);

        System.out.println(firstName + " " + "lastName");
        System.out.println(favoriteColor.toUpperCase());
        System.out.println(favoriteColor.length());
    }

    @Given("^I do actions with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iDoActionsWithAnd(String str1, String str2) throws Throwable {
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);

        System.out.println("str1 uppercase: " + str1.toUpperCase());
        System.out.println("str2 uppercase: "  + str2.toUpperCase());

        System.out.println("str1 length: " + str1.length());
        System.out.println("str2 length: " + str2.length());

        System.out.println("str1 and str2 comporison: " + str1.equals(str2));

        System.out.println("str1 and str2 comporisone ignoring case: " + str1.equalsIgnoreCase(str2));
        System.out.println("str1 and str2 do not equals?: " + str1.equals(str2));
        System.out.println("if str1 contains str2: " + str1.contains(str2));
    }

    @Given("^I print \"([^\"]*)\"$")
    public void iPrint(String text) throws Throwable {
        System.out.println(text);
        System.out.println();
    }

    @Given("^I compare \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCompareAnd(String str1, String str2) throws Throwable {
        if (str1.equals(str2)) {
            System.out.println("string are equal!");
        } else {
            System.out.println("strings are not equal!");
        }
    }

    @Given("^I print url for site \"([^\"]*)\"$")
    public void iPrintUrlForSite(String site) throws Throwable {
        if(site.equalsIgnoreCase("google")) {
            System.out.println("https://www.google.com/");
        } else if (site.equalsIgnoreCase("sample")) {
            System.out.println("https://skryabin.com/webdriver/html/sample.html");
        } else {
            System.out.println("Not supported site: " + site);
        }

        System.out.println();
    }

    @Given("^I work with arrays$")
    public void iWorkWithArrays() {
        String[] groceryList = {"milk", "apples", "cheese" };

        for(String item : groceryList) {
            System.out.println(item);
        }

        ArrayList<String> newGroceryList = new ArrayList<String>();
        newGroceryList.add("milk");
        newGroceryList.add("apples");
        newGroceryList.add("cheese");

        for(String item : groceryList) {
            System.out.println(item);
        }
    }

    @Given("^I work with maps$")
    public void iWorkWithMaps() {
        HashMap<String, String> user = new HashMap<String, String>();
        
        user.put("email", "john@doe.com");
        user.put("password", "welcome");
        user.put("firstName", "John");
        user.put("lastName", "Doe");

        HashMap<String, String> admin = new HashMap<String, String>();
        admin.put("username", "amoore");
        admin.put("email", "adam@moore.com");
        admin.put("password", "12345");
        admin.put("firstName", "Adam");
        admin.put("lastName", "Moore");
    }

    @Given("^I play with string$")
    public void iPlayWithString() {
//        String str = "abc";

        char data[] = {'a', 'b', 'c'};
        String str = new String(data);
        System.out.println(str);

        String cde = "cde";
        String c = str.substring(2,3);
        String d = cde.substring(1,2);

        System.out.println(c);
        System.out.println(d);
    }

    @Given("^I create classes$")
    public void iCreateClasses() {
        Animal myCat = new Cat("Tom");
//        System.out.println("Cat " + myCat.getName());
        myCat.speak();
        myCat.walk();
        myCat.sleep();
        myCat.eat("fish");

        Animal myDog = new Dog("Charlie");
        myDog.speak();
        myDog.walk();
        myDog.sleep();
        myDog.eat("bones");

        Animal myHorse = new Horse("Angel");
        myHorse.speak();
        myHorse.walk();
        myHorse.sleep();
        myHorse.eat("grain");
    }
}
