@login
Feature: When on the login portal page I can login using valid credentials

  Background:
    Given I am on the login portal

  Scenario Outline: Validate - Successful and unsuccessful login
    When I enter a username <username>
    And I enter a password <password>
    And click on Login button
    Then I should be presented with login validation message <validationmessage>

    Examples:
      | username  | password     | validationmessage    |
      | webdriver | webdriver123 | validation succeeded |
      | hello     | hello123     | validation failed    |
      | bye       | bye123       | validation failed    |

