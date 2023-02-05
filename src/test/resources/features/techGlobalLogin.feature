Feature: TechGlobal Training Functionalities

  Scenario: Validate login
    Given user navigates to "https://techglobal-training.netlify.app/"
    When user clicks on Practices dropdown in the header
    And user selects the "Frontend Testing" option
    And user selects the "Login Form" option
    Then user should see "Login Form" heading
    When user enters username as "johndoe" and password as "123456"
    Then user should see a "Invalid Username entered!" message