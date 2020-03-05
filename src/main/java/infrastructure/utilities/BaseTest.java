package infrastructure.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import static infrastructure.utilities.BrowserManager.*;
import static infrastructure.utilities.data_readers.DataReader.getData;


@Listeners(MyListener.class)
public abstract class BaseTest {

    protected static BrowserManager browserManager = new BrowserManager();
    protected static ReportManager reportManager = new ReportManager();
    protected static PageObjectManager pageObjectManager = new PageObjectManager();
    protected static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());


    @BeforeClass(alwaysRun = true)
    public void startSession() {
        reportManager.instanceReport();
    }

    @AfterClass(alwaysRun = true)
    public void closeSession() {
        driver.quit();
        reportManager.finalizeExtentReport();
    }

    @BeforeMethod
    public void doBeforeMethod(Method method,ITestResult test) {
        reportManager.initReportTest(method.getName(),test.getMethod().getDescription());
    }

    @AfterMethod
    public void doAfterMethod() {
        reportManager.finalizeReportTest();
    }
    protected void sleep(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String takeSS() throws IOException {
        String SSPath = getData("ReportFilePath") + "Execution_" + timeStamp + "/" + "screenshot_" + getRandomNumber() + ".png";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(SSPath));

        return SSPath;
    }


    public static String takeScreenShot()  {
        String SSPath = "C:/Google/screenshot" + getRandomNumber() + ".png";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(SSPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SSPath;
    }


    private static int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999999) + 1;
    }
}
