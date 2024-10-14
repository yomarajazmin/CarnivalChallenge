Feature: Select destination and duration of cruise

  Scenario: As a user
  I want to search for cruises to The Bahamas with duration between 6 and 9 days
  So that I will visualize all the options to choose one. Right now, I don't care about the departure port.

    Given I am at the "Carnival Cruise" website
    And I Agree to cookie policy in main page

    When I click on the SAIL TO search option in main page
    And I select The Bahamas option for SAIL TO in main page
    And I click on the DURATION search option in main page
    And I select 6 - 9 Days option for DURATION in main page
    And I click on SEARCH CRUISE button in main page
    Then I land into Search Result page

    When I click on Vacation Budget in search result page
    And I set max budget to 1000 in the Vacation Budget in search result page
    Then I check that the number of results are not the same as before in search result page
    And I check that the filter with "$1000" is applied in search result page

    When I click on Sort By filter to select High to low in search result page
    Then I check that the number of results are the same as before in search result page
    And I check that prices are sort from High to Low in search result page