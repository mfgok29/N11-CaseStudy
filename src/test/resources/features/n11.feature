
@n11
Feature: N11 Testcase using Selenium WebDriver and Cucumber Framework

  @smoke @login
  Scenario: Go to website in valid credentials and search product
    Given go to the n11 homepage
    And   the user opened the login page
    When login with valid credentials
    Then in the search area write samsung and click search button