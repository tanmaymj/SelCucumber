@Test123
Feature: WebDriver university - contact us page

  Scenario: Validate successful submission - unique data
    Given I access webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
