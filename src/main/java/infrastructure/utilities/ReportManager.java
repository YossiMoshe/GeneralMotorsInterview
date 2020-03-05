package infrastructure.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import static infrastructure.utilities.BaseTest.timeStamp;
import static infrastructure.utilities.data_readers.DataReader.getData;

public class ReportManager {

    public ExtentReports extent;
    public ExtentTest test;

    public void instanceReport() {
        extent = new ExtentReports(getData("ReportFilePath") + "Execution_" + timeStamp + "/" + getData("ReportFileName") + ".html");
    }

    public void initReportTest(String testName, String testDescription) {
        test = extent.startTest(testName,testDescription);
    }

    public void finalizeReportTest()
    {
        extent.endTest(test);
    }

    public void finalizeExtentReport() {
        extent.flush();
        extent.close();
    }
}
