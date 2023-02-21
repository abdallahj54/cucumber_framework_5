Feature: TechGlobal Training Functionalities

  Background:
    Given user navigates to "https://techglobal-training.netlify.app/"
    When user clicks on Practices dropdown in the header
    And user selects the "Frontend Testing" option

  Scenario: Validate dynamic tables pop-up window
    And user selects the "Dynamic Tables" option
    Then user should see "Dynamic Tables" heading
    When user clicks the "ADD PRODUCT" button
    Then validate "Add New Product" pop-up is displayed
    When user clicks the "CLOSE" button
    Then user should not see Add New Product pop-up

  Scenario: Validate Alerts card page
    And user selects the "Alerts" option
    Then user should see "Alerts" heading
    And user should see buttons as below
     | Warning alert | Confirmation alert | Prompt alert |
    And user should see "Result:" text
    When user clicks on "Warning alert" box
    Then user should see a popup displaying message "You are on TechGlobal Training application."
