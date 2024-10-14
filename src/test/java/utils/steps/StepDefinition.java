package utils.steps;

import common.Session;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ItineraryPage;
import pages.MainPage;
import pages.SearchResultPage;

public class StepDefinition {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ItineraryPage itineraryPage = new ItineraryPage();
    String previousValueOfResults = "";

    @Given("I am at the {string} website")
    public void iAmAtTheWebsite(String arg0) {
        Session.getInstance().getDriver().get("https://www.carnival.com/");
    }

    @And("I Agree to cookie policy in main page")
    public void iAgreeToCookiePolicyInMainPage() {
        if (mainPage.agreeCookiesButton.isControlDisplayed())
            mainPage.agreeCookiesButton.click();
    }

    @And("^I click on the (SAIL TO|SAIL FROM|DATES|DURATION) search option in main page$")
    public void iClickOnTheSearchOption(String option) {
        switch (option) {
            case "SAIL TO" -> mainPage.sailToButton.click();
            case "DURATION" -> mainPage.durationButton.click();
        }
    }

    @Then("^I select (.*) option for (SAIL TO|SAIL FROM|DATES|DURATION) in main page$")
    public void iClickOnTheSearchOption(String value, String category) {
        mainPage.clickOnOption(value);
        Assert.assertTrue(mainPage.checkOptionSelected(value));
    }

    @Then("I land into Search Result page")
    public void iLandIntoSearchResultPage() {
        searchResultPage.cruiseResultLabel.scrollInto();
        Assert.assertTrue(searchResultPage.cruiseResultLabel.isControlDisplayed());
        previousValueOfResults = searchResultPage.getNumberOfResults();
    }

    @And("I click on SEARCH CRUISE button in main page")
    public void iClickOnSearchCruiseButton() {
        mainPage.searchButton.click();
    }

    @And("^I click on (Number if Guests|Deals|Ships|Vacation Budget|Specialty Sailings) in search result page$")
    public void iClickOnOptionInSearchResultPage(String option) {
        searchResultPage.vacationBudgetButton.click();
    }

    @And("^I set max budget to (.*) in the (Vacation Budget) in search result page$")
    public void iSetMaxBudgetToValueInTheFilterInSearchResultPage(String value, String option) {
        searchResultPage.maxBudget.writeText(value);
        searchResultPage.vacationBudgetButton.click();
    }

    @Then("^I check that the number of results are (the same|not the same) as before in search result page$")
    public void iCheckThatTheNumberOfResultsAreNotTheSameAsBeforeInSearchResultPage(String option) {
        String newNumberOfResults = searchResultPage.getNumberOfResults();

        if (option.contains("not"))
            Assert.assertNotEquals(previousValueOfResults, newNumberOfResults);
        else
            Assert.assertEquals(previousValueOfResults, newNumberOfResults);
        previousValueOfResults = newNumberOfResults;
    }

    @And("^I click on (Sort By) filter to select (Low to high|High to low) in search result page$")
    public void iClickOnSortByFilterToSelectOptionInSearchResultPage(String text, String option) {
        searchResultPage.sortByButton.click();

        if (option.equals("High to low"))
            searchResultPage.sortByHighToLowButton.click();
        else
            searchResultPage.sortByLowToHighButton.click();
    }

    @And("I click on view itinerary link from cruise number {int} in search result page")
    public void iClickOnViewItineraryLinkFromCruiseInSearchResultPage(int number) {
        searchResultPage.clickOnViewItineraryFromCruiseNumber(number);
    }

    @And("I check that the filter with {string} is applied in search result page")
    public void iCheckThatTheFilterIsAppliedInSearchResultPage(String value) {
        Assert.assertTrue(searchResultPage.appliedFiltersContain(value));
    }

    @And("I check that prices are sort from High to Low in search result page")
    public void iCheckThatPricesAreSortInSearchResultPage() {
        Assert.assertTrue(searchResultPage.areTheListOfResultsSortInDescOrder());
    }

}
