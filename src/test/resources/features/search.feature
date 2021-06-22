Feature: Booking search

  Scenario Outline: Search booking page for hotel
    Given I want to search for <name>
    When I do search
    Then Results page should contain <name>
    And rating should be <rating>
    Examples:
      |           name         | rating |
      | "Apartland Griboedova" | "8.2"  |
      | "Centrum Lwowska"      | "7.8"  |
      | "Xi Tang Hotel"        | "8.8"  |