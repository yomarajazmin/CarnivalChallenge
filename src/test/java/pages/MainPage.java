package pages;

import common.Session;
import common.control.Button;
import common.locators.MainPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MainPage {

    public Button agreeCookiesButton = new Button(By.id(MainPageLocators.AGREE_COOKIES_POLICY.getLocator()));
    public Button sailToButton = new Button(By.id(MainPageLocators.SAIL_TO.getLocator()));
    public Button durationButton = new Button(By.id(MainPageLocators.DURATION.getLocator()));
    public Button searchButton = new Button(By.xpath(MainPageLocators.SEARCH_CRUISES.getLocator()));

    public void clickOnOption(String option) {
        Session.getSession().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(String.format(MainPageLocators.OPTION.getLocator(), option)));
        element.click();
    }

    public boolean checkOptionSelected(String option) {
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(String.format(MainPageLocators.OPTION_SELECTED.getLocator(), option)));
        String currentOptionSelected = element.getText();
        return currentOptionSelected.contains(option);
    }
}
