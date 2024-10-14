package common.locators;

public enum SearchResultPageLocators {

    //filter section
    CRUISE_RESULT_LABEL("//h2[@data-testid='cruisetotalResults']"),
    NUMBER_OF_GUESTS("//button[@aria-label='Number of Guests']"),
    DEALS("//button[@aria-label='Deals']"),
    SHIPS("//button[@aria-label='Ships']"),
    VACATION_BUDGET("//button[@aria-label='Vacation Budget']"),
    MAX_VACATION_BUDGET("input-max-price"),
    SPECIALTY_SAILINGS("//button[@aria-label='Specialty Sailings']"),
    SORT_BY("//select[@data-testid='sortBySelect']"),
    LOW_TO_HIGH("//option[@value='fromprice']"),
    HIGH_TO_LOW("//option[@value='fromprice desc']"),
    FILTER_APPLIED("//span[@data-testid='filter-chip']/div"),
    PRICE_LIST("//div[@data-testid='priceAmount']");

    public final String locator;

    private SearchResultPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
