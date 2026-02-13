Feature: Filters and Sorting Tests

  Background:
    Given Open website "chrome"
    Then Close login popup
    When Click Hotels
    And Enter city "Goa"
    And Select checkin date "25"
    And Select checkout date "28"
    And Click hotel search
    Then Hotel results shown

  Scenario: Test 19 - Apply price filter and verify results
    When Apply price filter
    Then Filtered results shown

  Scenario: Test 20 - Apply rating filter and verify results
    When Apply rating filter
    Then Filtered results shown

  Scenario: Test 21 - Sort search results by price
    When Sort by price
    Then Sorted results shown

  Scenario: Test 22 - Clear applied filters and verify results reset
    When Apply price filter
    And Apply rating filter
    And Clear all filters
    Then All results shown