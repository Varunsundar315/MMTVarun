Feature: Flight Results Page Tests

  Background:
    Given Open website "chrome"
    Then Close login popup
    When Click Flights
    And Enter from "Delhi"
    And Enter to "Mumbai"
    And Select departure date and search

  Scenario: Test 23 - Verify flight results are displayed
    Then Flight list displayed

  Scenario: Test 24 - Open flight details page
    When Click first flight
    Then Flight details page shown

  Scenario: Test 25 - Verify fare details are displayed
    Then Fare details shown

  Scenario: Test 26 - Verify results page URL contains flight
    Then URL contains "www.makemytrip.com"