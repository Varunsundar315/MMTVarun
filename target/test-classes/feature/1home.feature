Feature: Home Page Tests

  Background:
    Given Open website "chrome"

  Scenario: Test 1 - Verify home page title
    Then Title contains "MakeMyTrip"

  Scenario: Test 2 - Close login popup
    Then Close login popup

  Scenario: Test 3 - Verify navigation tabs are displayed
    Then Check "Flights" tab
    And Check "Hotels" tab
    And Check "Trains" tab

  Scenario: Test 4 - Verify flight search fields are displayed
    When Click Flights
    Then Check From field
    And Check To field

  Scenario: Test 5 - Verify departure date picker is displayed
    When Click Flights
    Then Check Departure picker
