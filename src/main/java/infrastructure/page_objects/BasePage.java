package infrastructure.page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

import static infrastructure.utilities.BrowserManager.*;

public abstract class BasePage {

    protected WebDriverWait wait = new WebDriverWait(driver, 20);
    protected JavascriptExecutor js = (JavascriptExecutor) driver;
    protected Actions action = new Actions(driver);
    protected ArrayList<String> windowHandles;

    protected WebElement waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
