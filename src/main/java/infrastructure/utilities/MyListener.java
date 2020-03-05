package infrastructure.utilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

public class MyListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        reportManager.test.log(LogStatus.PASS, result.getName() + " test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        reportManager.test.log(LogStatus.PASS, result.getName() + " test ended successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            reportManager.test.log(LogStatus.FAIL, "Test failed, see details: " +
                                            result.getThrowable()  + reportManager.test.addScreenCapture(takeSS()));
        } catch (IOException e) {
            reportManager.test.log(LogStatus.FAIL, "Could Not take screen shot, see details: " + e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        reportManager.test.log(LogStatus.SKIP, "Skipped test: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}

