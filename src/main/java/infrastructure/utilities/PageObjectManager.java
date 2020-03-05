package infrastructure.utilities;

import infrastructure.page_objects.GoogleMapsPage;
import infrastructure.page_objects.JobDescriptionPage;
import infrastructure.page_objects.SearchJobsPage;
import org.openqa.selenium.support.PageFactory;
import static infrastructure.utilities.BrowserManager.*;

public class PageObjectManager {

    public static SearchJobsPage searchJobsPage;
    public static JobDescriptionPage jobDescriptionPage;
    public static GoogleMapsPage googleMapsPage;

    public PageObjectManager() {
        initPageObjects();
    }

    public void initPageObjects() {
        searchJobsPage = PageFactory.initElements(driver, SearchJobsPage.class);
        jobDescriptionPage = PageFactory.initElements(driver, JobDescriptionPage.class);
        googleMapsPage = PageFactory.initElements(driver, GoogleMapsPage.class);
    }
}
