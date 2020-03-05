package test_cases;

import infrastructure.page_objects.GoogleMapsPage;
import infrastructure.utilities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import static infrastructure.utilities.PageObjectManager.*;
import static infrastructure.utilities.PageObjectManager.googleMapsPage;
import static java.text.MessageFormat.format;

public class Tests extends BaseTest {

    private String jobsUrl = "https://gm.taleo.net/careersection/20162901/jobsearch.ftl";

    @Test(description = "validate Automation Engineer position exist")
    public void validateAutomationPosition() {
        String jobName = "Automation Engineer";
        browserManager.navigateToUrl(jobsUrl);
        searchJobsPage.isJobExist(jobName);

        Assert.assertTrue(searchJobsPage.isJobExist(jobName),format("{0} position is not exist",jobName));
    }

    @Test(description = "validate number of shown positions")
    public void validateDisplayedPositions() {
        browserManager.navigateToUrl(jobsUrl);
        int actualDisplayedPositions = searchJobsPage.getNumOfDisplayPositions();
        String pageInfo = searchJobsPage.getPageInfo();
        int expectedDisplayedPositions = Integer.parseInt(pageInfo.split(" ")[2]);

        Assert.assertEquals(actualDisplayedPositions, expectedDisplayedPositions);
    }

    @Test(description = "validate location of all positions is Israel")
    public void validatePositionLocations() {
        browserManager.navigateToUrl(jobsUrl);
        String location = "Israel";

        Assert.assertTrue(searchJobsPage.areAllPositionsInLocation(location),
                             format("Not all positions are in {0}",location));
    }

    @Test(description = "find Rome in google maps and take screenshots")
    public void findRomeInGoogleMaps() {
        browserManager.navigateToUrl("https://www.google.com/maps");
        googleMapsPage.findLocation("london");
        browserManager.waitForUrlToContainValue("place");
        takeScreenShotsInGoogle(1000,3,googleMapsPage);
    }



    private void takeScreenShotsInGoogle(int delay, int numOfScreenshot, GoogleMapsPage googleMapsPage) {
        for (int i = 0; i < numOfScreenshot; i++) {
            sleep(delay);
            takeScreenShot();
            googleMapsPage.zoomIn();
        }
    }






}
