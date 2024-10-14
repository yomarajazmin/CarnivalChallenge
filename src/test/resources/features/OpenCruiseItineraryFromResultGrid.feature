Feature: Open a cruise itinerary of the result grid

  Scenario: As a user
            I want to choose one sail and learn more about the trip,
            So that I will get more info about the itinerary.

    Given I am at the "Carnival Cruise" website
    And I Agree to cookie policy in main page

    When I click on the SAIL TO search option in main page
    And I select The Bahamas option for SAIL TO in main page
    And I click on the DURATION search option in main page
    And I select 6 - 9 Days option for DURATION in main page
    And I click on SEARCH CRUISE button in main page
    And I land into Search Result page
    And I click on Vacation Budget in search result page
    And I set max budget to 1000 in the Vacation Budget in search result page
    And I click on Sort By filter to select High to low in search result page

    When I click on view itinerary link from cruise number 2 in search result page
    And I click on Read more link from day number 1 in itinerary page
    Then I check Read less link is displayed for day number 1 in itinerary page

    When I click on THINGS TO DO link from day number 2 in itinerary page
    Then I check THINGS TO DO menu is displayed for day number 2 in itinerary page

    When I click on SHORE EXCURSIONS link from day number 3 in itinerary page
    Then I check SHORE EXCURSIONS menu is displayed for day number 3 in itinerary page
    And I check the ship information is in itinerary page
    And I check the onboard activities and dining menus are displayed in itinerary page
