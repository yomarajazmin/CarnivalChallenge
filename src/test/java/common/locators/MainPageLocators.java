package common.locators;

public enum MainPageLocators {

    AGREE_COOKIES_POLICY("onetrust-accept-btn-handler"),
    SAIL_TO("cdc-destinations"),
    SAIL_FROM("cdc-ports"),
    DATES("cdc-dates"),
    DURATION("cdc-durations"),
    OPTION("//button[contains(.,'%s')]"),
    OPTION_SELECTED("//button[contains(@class,'cdc-filter-button-active')]"),
    SEARCH_CRUISES("//li/a[@data-tealium='cdc-search-cruises-cta']");

    public final String locator;

    private MainPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
