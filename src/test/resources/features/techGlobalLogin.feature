@Login

Feature: TechGlobal Training Functionalities

  Background:
    Given user navigates to "https://techglobal-training.netlify.app/"
    When user clicks on Practices dropdown in the header
    And user selects the "Frontend Testing" option
    And user selects the "Login Form" option
    Then user should see "Login Form" heading

  Scenario Outline: Validate login
    When user enters username as "<username>" and password as "<password>"
    Then user should see a "<message>" message
    Examples:
      | username   | password | message                   |
      | johndoe    | 123456   | Invalid Username entered! |
      | tomsmith   | 12345    | Invalid Username entered! |
      | TechGlobal | Test1234 | You are logged in         |
      | TechGlobal | 12345    | Invalid Password entered! |
      |            |          | Invalid Username entered! |