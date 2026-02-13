Feature: Hotel Search Tests

  Background:
    Given Open website "chrome"
    Then Close login popup

  Scenario: Test 11 - Navigate to hotels section
    When Click Hotels
    Then URL contains "hotels"

  Scenario: Test 12 - Search hotels with valid details
    When Click Hotels
    And Enter city "Goa"
    And Select checkin date "25"
    And Select checkout date "28"
    And Click hotel search
    Then Hotel results shown

  Scenario: Test 13 - Search hotels without dates
    When Click Hotels
    And Enter city "Mumbai"
    And Click hotel search
    Then URL contains "hotels"

  Scenario: Test 14 - Verify hotel results page
    When Click Hotels
    And Enter city "Delhi"
    And Select checkin date "22"
    And Select checkout date "25"
    And Click hotel search
    Then Hotel results shown

  Scenario Outline: Test - Search hotels in different cities
    When Click Hotels
    And Enter city "<city>"
    And Select checkin date "20"
    And Select checkout date "23"
    And Click hotel search
    Then Hotel results shown

    Examples:
      | city      |
      | Goa       |
      | Jaipur    |