Feature: Filters and Sorting Tests

  Scenario: Test 27 - Apply price filter on flight results
    Given Open website "chrome"
    Then Close login popup
    When Click Flights
    And Enter from "Delhi"
    And Enter to "Mumbai"
    And Select departure date and search
    And Apply price filter
    Then Filtered results shown

  Scenario: Test 28 - Apply rating filter on hotel results
    Given Open website "chrome"
    Then Close login popup
    When Click Hotels
    And Enter city "Goa"
    And Select checkin date "25"
    And Select checkout date "28"
    And Select rooms "1" adults "2"
    And Click hotel search
    And Apply rating filter
    Then Filtered results shown

  Scenario: Test 29 - Sort flight results by price
    Given Open website "chrome"
    Then Close login popup
    When Click Flights
    And Enter from "Delhi"
    And Enter to "Mumbai"
    And Select departure date and search
    And Sort by price
    Then Sorted results shown

  Scenario: Test 30 - Clear all applied filters
    Given Open website "chrome"
    Then Close login popup
    When Click Flights
    And Enter from "Delhi"
    And Enter to "Mumbai"
    And Select departure date and search
    And Apply price filter
    And Clear all filters
    Then All results shown

  Scenario: Test 31 - Apply multiple filters on flight results
    Given Open website "chrome"
    Then Close login popup
    When Click Flights
    And Enter from "Bangalore"
    And Enter to "Chennai"
    And Select departure date and search
    And Apply price filter
    And Sort by price
    Then Filtered results shown