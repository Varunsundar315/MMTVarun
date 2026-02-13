Feature: Flight Search Tests

  Background:
    Given Open website "chrome"
    Then Close login popup

  Scenario: Test 6 - Search flights with valid cities
    When Click Flights
    And Enter from "Delhi"
    And Enter to "Mumbai"
    And Select departure date and search
    Then Results page shown

  Scenario: Test 7 - Search flights with same source and destination
    When Click Flights
    And Enter from "Delhi"
    And Enter to "Delhi"
    And Select departure date and search
    Then Error message shown

  Scenario: Test 8 - Search flights without selecting date
    When Click Flights
    And Enter from "Bangalore"
    And Enter to "Chennai"
    And Click search
    Then Results page shown

  Scenario: Test 9 - Verify flight results page URL
    When Click Flights
    And Enter from "Delhi"
    And Enter to "Mumbai"
    And Select departure date and search
    Then URL contains "www.makemytrip.com"

  Scenario: Test 10 - Verify flight list is displayed
    When Click Flights
    And Enter from "Delhi"
    And Enter to "Mumbai"
    And Select departure date and search
    Then Flight list displayed

  Scenario Outline: Test - Search flights to multiple destinations
    When Click Flights
    And Enter from "<source>"
    And Enter to "<destination>"
    And Select departure date and search
    Then URL contains "www.makemytrip.com"

    Examples:
      | source  | destination |
      | Delhi   | Bangalore   |
      | Mumbai  | Chennai     |
