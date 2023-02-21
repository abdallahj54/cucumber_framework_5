@Wiki
Feature: Wikipedia search functionality

  Background:
    Given user navigates to "https://www.wikipedia.org/"

  Scenario Outline: Validate Wikipedia search
    When user searches for "<key>" on Wikipedia
    Then user should see "<key>" in the title
    And user should see "<key>" in the url
    And user should see "<key>" in the first heading
    Examples:
      | key         |
      | Elon Musk   |
      | Johnny Depp |
      | Bill Gates  |

  @WikiLanguages
  Scenario: Validate Wikipedia main languages
    Then user should see below languages around the logo
      | English | Русский | 日本語 | Deutsch | Français | Español | Italiano | 中文 | فارسی | Polski |