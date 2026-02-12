Feature: Train Search Tests

  Background:
    Given Open website "chrome"
    Then Close login popup

  Scenario: Test 15 - Navigate to trains section
    When Click Trains
    Then URL contains "railways"

  Scenario: Test 16 - Search trains with valid stations and date
    When Click Trains
    And Enter from station "Mumbai"
    And Enter to station "Pune"
    And Select departure date "20"
    And Click train search
    Then URL contains "railways"

  Scenario: Test 17 - Search trains without selecting date
    When Click Trains
    And Enter from station "Delhi"
    And Enter to station "Bangalore"
    And Click train search
    Then URL contains "railways"

  Scenario: Test 18 - Verify train results page
    When Click Trains
    And Enter from station "Delhi"
    And Enter to station "Mumbai"
    And Select departure date "22"
    And Click train search
    Then URL contains "railways"

  Scenario Outline: Test 19 - Search trains for different routes
    When Click Trains
    And Enter from station "<from_station>"
    And Enter to station "<to_station>"
    And Select departure date "20"
    And Click train search
    Then URL contains "railways"

    Examples:
      | from_station | to_station |
      | Mumbai       | Pune       |
      | Delhi        | Agra       |