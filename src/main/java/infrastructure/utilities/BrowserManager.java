package infrastructure.utilities;

import infrastructure.utilities.data_readers.ConfigPropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static infrastructure.utilities.data_readers.DataReader.getData;
import static org.awaitility.Awaitility.with;

public class BrowserManager {

    public static WebDriver driver;
    private static String browserType;

    public BrowserManager() {
        browserType = new ConfigPropertiesReader().getBrowserType();
        initBrowser(browserType);
    }

    public static void initBrowser(String browserType) {
        String startUrl = getData("URL");
        switch(browserType.toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFFDriver();
                break;
        }
        driver.get(startUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    private static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", getData("ChromeDriverPath"));
        return new ChromeDriver();
    }

    private static WebDriver initFFDriver() {
        System.setProperty("webdriver.gecko.driver", getData("FFDriverPath"));
        return new FirefoxDriver();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }


    public boolean waitForUrlToContainValue(final String value) {
        with()
                .alias("URL does not contain = " + value)
                .pollInSameThread()
                .pollInterval(1, TimeUnit.SECONDS)
                .await()
                .atMost(20, TimeUnit.SECONDS).until(() -> getCurrentUrl().contains(value));
        return true;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
