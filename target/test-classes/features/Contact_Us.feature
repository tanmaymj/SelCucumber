@contactus
Feature: WebDriver university - contact us page

  Scenario: Validate successful submission - unique data
    Given I access webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on submit button
    Then I should be presented with a success message

  Scenario: Validate successful submission - specific data
    Given I access webdriver university contact us page
    When I enter a specific first name joe
    And I enter a specific last name blogs
    And I enter a specific email address joe_blogs@gmail.com
    And I enter a specific comment "How are you"
    And I click on submit button
    Then I should be presented with a success message