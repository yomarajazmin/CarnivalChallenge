package common.locators;

public enum ViewItineraryPageLocators {

    //todo clarify if it is actually called start booking
    BOOK_NOW("//div[@data-testid='startBooking']"),
    SHIP_NAME("//span[@data-testid='shipTitle']"),
    SHIP_DESCRIPTION("//span[@data-testid='shipDescription']"),

    //onboard activities
    ONBOARD_ACTIVITIES("//h3[contains(.,'Onboard Activities')]/parent::div//div[@data-testid='obaSection']//div[@data-index]"),
    ONBOARD_DINING("//h3[contains(.,'Onboard Dining')]/parent::div//div[@data-testid='obaSection']//div[@data-index]"),

    //day item
    READ_MORE("//button[@aria-controls='read-more-%s']"),
    THINGS_TO_DO("//button[@aria-controls='things-to-do-section-%s']"),
    THINGS_TO_DO_LIST("//div[@data-testid='thingsToDoSection']//div[@data-index]"),
    SHORE_EXCURSIONS("//button[@aria-controls='excursions-section-%s']"),
    SHORE_EXCURSIONS_LIST("//div[@data-testid='excursionsSection']//div[@data-index]");

    public final String locator;

    private ViewItineraryPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
