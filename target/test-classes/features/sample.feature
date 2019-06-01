@sample
  Feature: sample scenarios

    @sample1
    Scenario: Responsive UI validation
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I resize window to 1200 and 800
      Then element with xpath "//b[@id='location']" should be displayed
      Then element with xpath "//b[@id='currentDate']" should be displayed
      Then element with xpath "//b[@id='currentTime']" should be displayed
      When I resize window to 400 and 800
      Then element with xpath "//b[@id='location']" should not be displayed
      Then element with xpath "//b[@id='currentDate']" should not be displayed
      Then element with xpath "//b[@id='currentTime']" should not be displayed
      When I resize window to 1200 and 800

    @sample2
    Scenario: Username field
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I type "a" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='username-error']" should contain text "2 char"
      When I type "a" into element with xpath "//input[@name='username']"
      And I wait for 5 sec
      Then element with xpath "//label[@id='username-error']" should not be displayed

    @sample3
    Scenario: Email field
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I type "i" into element with xpath "//input[@name='email']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='email-error']" should contain text "Please enter"
      When I type "renekochetkova@gmail.com" into element with xpath "//input[@name='email']"
      Then element with xpath "//label[@id='email-error']" should not be displayed

    @sample4
    Scenario: Confirm Password field
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I clear element with xpath "//input[@name='password']"
      Then element with xpath "//input[@name='confirmPassword']" should be displayed
      When I type "password" into element with xpath "//input[@name='password']"

    @sample5
    Scenario: Name field
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//span[@class='ui-dialog-title']/../.." should be present
      When I type "Irina" into element with xpath "//input[@id='firstName']"
      And I type "Nikolaevna" into element with xpath "//input[@id='middleName']"
      And I type "Kochetkova" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[text()='Save']/.."
      Then element with xpath "//input[@value='Irina Nikolaevna Kochetkova']" should be present
      
    @sample6
    Scenario: Accepting Privacy Policy validation
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I click on element with xpath "//button[@name='formSubmit']"
      Then element with xpath "//label[contains(text(),'Must')]" should be present
      When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      And I click on element with xpath "//button[@name='formSubmit']"
      Then element with xpath "//label[contains(text(),'Must')]" should not be present

    @sample7
    Scenario: Entering non-required fields
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      Then I type "8764543434" into element with xpath "//input[@name='phone']"
      And I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Russia']"
      And I click on element with xpath "//input[@value='female']"
      And I click on element with xpath "//input[@name='allowedToContact']"
      And I type "Rostov-on-Don" into element with xpath "//textarea[@name='address']"
      And I click on element with xpath "//select[@name='carMake']/option['Toyota']"
      And I click on element with xpath "//button[@id='thirdPartyButton']"
      Then I accept alert
      And I click on element with xpath "//input[@id='dateOfBirth']"
      And I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='3']"
      And I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='1973']"
      And I click on element with xpath "//table[@class='ui-datepicker-calendar']//a[text()='2']"

    @sample8
    Scenario: Validation form submission
      Given I open url "https://skryabin.com/webdriver/html/sample.html"
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//span[@class='ui-dialog-title']/../.." should be present
      When I type "Irina" into element with xpath "//input[@id='firstName']"
      And I type "Nikolaevna" into element with xpath "//input[@id='middleName']"
      And I type "Kochetkova" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[text()='Save']/.."
      Then element with xpath "//input[@value='Irina Nikolaevna Kochetkova']" should be present
      And I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Russia']"
      And I type "Rostov-on-Don" into element with xpath "//textarea[@name='address']"
      Then I type "irenekochetkova" into element with xpath "//input[@name='username']"
      And I type "irenekochetkova@gmail.com" into element with xpath "//input[@name='email']"
      And I type "veterok" into element with xpath "//input[@id='password']"
      And I type "veterok" into element with xpath "//input[@id='confirmPassword']"
      And I type "8764543434" into element with xpath "//input[@name='phone']"
      And I click on element with xpath "//input[@id='dateOfBirth']"
      And I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='3']"
      And I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='1973']"
      And I click on element with xpath "//table[@class='ui-datepicker-calendar']//a[text()='2']"
      And I click on element with xpath "//input[@value='female']"
      And I click on element with xpath "//select[@name='carMake']/option['Toyota']"
      And I click on element using JavaScript with xpath "//input[@name='allowedToContact']"
      And I click on element with xpath "//button[@id='thirdPartyButton']"
      Then I accept alert
      Then I click on element with xpath "//button[contains(text(),'Related documents (click)')]"
      Then I switch to first window
      Then I switch to iframe with xpath "//iframe[@name='additionalInfo']"
      And I type "Irina" into element with xpath "//input[@id='contactPersonName']"
      And I type "8764543434" into element with xpath "//input[@id='contactPersonPhone']"
      Then I switch to default content
      And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      When I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//div[@id='samplePageResult']" should be present
      Then I wait for 10 sec
      And element with xpath "//b[@name='firstName'][text()='Irina']" should be present
      And element with xpath "//b[@name='middleName'][text()='Nikolaevna']" should be present
      And element with xpath "//b[@name='lastName'][text()='Kochetkova']" should be present
      And element with xpath "//b[@name='name'][text()='Irina Nikolaevna Kochetkova']" should be present
      And element with xpath "//b[@name='countryOfOrigin'][text()='Russia']" should be present
      And element with xpath "//b[@name='address'][text()='Rostov-on-Don']" should be present
      And element with xpath "//b[@name='username'][text()='irenekochetkova']" should be present
      And element with xpath "//b[@name='email'][text()='irenekochetkova@gmail.com']" should be present
      And element with xpath "//b[@name='password']" should be enabled
      And element with xpath "//b[@name='phone'][text()='8764543434']" should be present
      And element with xpath "//b[@name='gender'][text()='female']" should be present
      And element with xpath "//b[@name='carMake'][text()='Ford']" should be present
      And element with xpath "//b[@name='allowedToContact'][text()='true']" should be present
      And element with xpath "//b[@name='agreedToPrivacyPolicy'][text()='true']" should be present
      And element with xpath "//b[@name='contactPersonName'][text()='Irina']" should be present
      And element with xpath "//b[@name='contactPersonPhone'][text()='8764543434']" should be present
      And element with xpath "//b[@name='thirdPartyAgreement'][text()='accepted']" should be present
      And element with xpath "//b[@name='dateOfBirth'][text()='04/02/1973']" should be present



















