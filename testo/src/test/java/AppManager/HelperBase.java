package AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;

import static org.awaitility.Awaitility.await;

public class HelperBase {
    protected WebDriver wd;

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        await().until(() -> wd.findElement(locator).isDisplayed());
        wd.findElement(locator).click();
    }

    public void getPage(String url) {
        wd.get(url);
        await().until(() -> getCurrentUrl().equals(url));
    }

    protected void type(String text, By locator) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public String getCurrentUrl() {
        return wd.getCurrentUrl();
    }

    protected void attach(File file, By locator) {
        if (file != null) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    protected boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}