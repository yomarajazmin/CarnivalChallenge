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

    public void click() {
        Session.getSession().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        findControl();
        control.click();
        Session.getSession().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public boolean isControlDisplayed() {
        try {
            findControl();
            Session.getSession().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return control.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getAttribute(String attributeName) {
        try {
            Session.getSession().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            findControl();
            return control.getAttribute(attributeName);
        } catch (Exception e) {
            return "";
        }
    }

    public void scrollInto() {
        try {
            Session.getSession().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            JavascriptExecutor js = (JavascriptExecutor) Session.getInstance().getDriver();
            findControl();
            js.executeScript("arguments[0].scrollIntoView();", control);
        } catch (Exception e) {
        }
    }
}
