package pages;

import common.Session;
import common.control.Button;
import common.control.Label;
import common.control.TextBox;
import common.locators.ViewItineraryPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ItineraryPage {

    public Button bookNowButton = new Button(By.xpath(ViewItineraryPageLocators.BOOK_NOW.getLocator()));
    public Label shipLabel = new Label(By.xpath(ViewItineraryPageLocators.SHIP_NAME.getLocator()));
    public TextBox shipDescriptionTextbox = new TextBox(By.xpath(ViewItineraryPageLocators.SHIP_DESCRIPTION.getLocator()));

    public void clickOnReadMoreOfDay(int dayNumber) throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) Session.getInstance().getDriver();
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(String.format(ViewItineraryPageLocators.READ_MORE.getLocator(), dayNumber - 1)));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public String getReadMoreLinkText(int dayNumber) throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(String.format(ViewItineraryPageLocators.READ_MORE.getLocator(), dayNumber - 1)));
        JavascriptExecutor js = (JavascriptExecutor) Session.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element.getAttribute("textContent");
    }

    public void clickOnThingsToDoOfDay(int dayNumber) throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(String.format(ViewItineraryPageLocators.THINGS_TO_DO.getLocator(), dayNumber - 1)));
        JavascriptExecutor js = (JavascriptExecutor) Session.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public void clickOnShoreExcursionsOfDay(int dayNumber) throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = Session.getInstance().getDriver().findElement(By.xpath(String.format(ViewItineraryPageLocators.SHORE_EXCURSIONS.getLocator(), dayNumber - 1)));
        JavascriptExecutor js = (JavascriptExecutor) Session.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    public boolean isThingsToDoListEmpty() {
        List<WebElement> element = Session.getInstance().getDriver().findElements(By.xpath(ViewItineraryPageLocators.THINGS_TO_DO_LIST.getLocator()));
        return element == null || element.size() == 0;
    }

    public boolean isShoreExcursionsListEmpty() {
        List<WebElement> element = Session.getInstance().getDriver().findElements(By.xpath(ViewItineraryPageLocators.SHORE_EXCURSIONS_LIST.getLocator()));
        return element == null || element.size() == 0;
    }

    public boolean isOnboardActivitiesListEmpty() {
        List<WebElement> element = Session.getInstance().getDriver().findElements(By.xpath(ViewItineraryPageLocators.ONBOARD_ACTIVITIES.getLocator()));
        return element == null || element.size() == 0;
    }

    public boolean isOnboardDiningListEmpty() {
        List<WebElement> element = Session.getInstance().getDriver().findElements(By.xpath(ViewItineraryPageLocators.ONBOARD_DINING.getLocator()));
        return element == null || element.size() == 0;
    }

    public boolean isShipNameDisplayed() {
        shipLabel.scrollInto();
        return shipLabel.isControlDisplayed();
    }
}
