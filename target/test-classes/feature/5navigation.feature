Feature: Navigation Tests

  Background:
    Given Open website "chrome"
    Then Close login popup

  Scenario: Test 19 - Navigate between different modules
    When Click Flights
    And Click Hotels
    And Click Trains
    Then URL contains "railways"

  Scenario: Test 20 - Navigate from Flights to Hotels
    When Click Flights
    And Click Hotels
    Then URL contains "hotels"

  Scenario: Test 21 - Navigate from Hotels to Trains
    When Click Hotels
    And Click Trains
    Then URL contains "railways"

  