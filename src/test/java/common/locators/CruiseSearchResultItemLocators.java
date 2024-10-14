package common.locators;

public enum CruiseSearchResultItemLocators {

    VIEW_ITINERARY("//a[contains(@href,'itinerary')]");

    public final String locator;

    private CruiseSearchResultItemLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
