package pages;

import common.Session;
import common.control.Button;
import common.control.Link;
import common.control.TextBox;
import common.locators.CruiseSearchResultItemLocators;
import common.locators.SearchResultPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    public Button numberOfGuestButton = new Button(By.xpath(SearchResultPageLocators.NUMBER_OF_GUESTS.getLocator()));
    public Button dealsButton = new Button(By.xpath(SearchResultPageLocators.DEALS.getLocator()));
    public Button shipsButton = new Button(By.xpath(SearchResultPageLocators.SHIPS.getLocator()));
    public Button vacationBudgetButton = new Button(By.xpath(SearchResultPageLocators.VACATION_BUDGET.getLocator()));
    public Button specialtySailingsButton = new Button(By.xpath(SearchResultPageLocators.SPECIALTY_SAILINGS.getLocator()));
    public Button sortByButton = new Button(By.xpath(SearchResultPageLocators.SORT_BY.getLocator()));

    public TextBox maxBudget = new TextBox(By.xpath(SearchResultPageLocators.MAX_VACATION_BUDGET.getLocator()));
    public Button sortByLowToHighButton = new Button(By.xpath(SearchResultPageLocators.LOW_TO_HIGH.getLocator()));
    public Button sortByHighToLowButton = new Button(By.xpath(SearchResultPageLocators.HIGH_TO_LOW.getLocator()));

    public Link viewItineraryLink = new Link(By.xpath(CruiseSearchResultItemLocators.VIEW_ITINERARY.getLocator()));

    public void writeMaxBudget(String value) {
        maxBudget.writeText(value);
    }

    public boolean appliedFiltersContain(String filterValue) {
        List<WebElement> elements = Session.getInstance().getDriver().findElements(By.xpath(SearchResultPageLocators.FILTER_APPLIED.getLocator()));
        boolean found = false;
        for (int i = 0; i < elements.size() && !found; i++)
            found = elements.get(i).getAttribute("textContent").contains(filterValue);

        return found;
    }

    public void clickOnViewItineraryFromCruiseNumber(int number) {
        List<WebElement> elements = Session.getInstance().getDriver().findElements(viewItineraryLink.getLocator());
        elements.get(number - 1).click();
    }
}
