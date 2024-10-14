package common.control;

import common.Session;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Control {

    protected WebElement control;
    protected By locator;

    public Control(By locator) {
        this.locator = locator;
    }

    public WebElement getControl() {
        return control;
    }

    public By getLocator() {
        return locator;
    }

    protected void findControl() {
        control = Session.getInstance().getDriver().findElement(locator);
    }

    public void click() throws InterruptedException {
        Thread.sleep(3000);
        findControl();
        control.click();
        Thread.sleep(3000);
    }

    public boolean isControlDisplayed() {
        try {
            findControl();
            Thread.sleep(3000);
            return control.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getAttribute(String attributeName) {
        try {
            Thread.sleep(3000);
            findControl();
            return control.getAttribute(attributeName);
        } catch (Exception e) {
            return "";
        }
    }

    public void scrollInto() {
        try {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) Session.getInstance().getDriver();
            findControl();
            js.executeScript("arguments[0].scrollIntoView();", control);
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }
}
