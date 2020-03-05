package infrastructure.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchJobsPage extends BasePage {

    @FindBy(xpath = "//th[@scope='row']")
    public List<WebElement> jobs;

    @FindBy(className = "odd")
    public List<WebElement> odds;

    @FindBy(className = "even")
    public List<WebElement> even;

    @FindBy(id = "currentPageInfo")
    public WebElement pageInfo;


    public String getPageInfo() {
        return pageInfo.getText();
    }

    public int getNumOfDisplayPositions(){
        return jobs.size();
    }

    public boolean isJobExist(String jobName) {
        return getJobByName(jobName) != null;
    }

    public boolean areAllPositionsInLocation(String location) {
        for (WebElement job : odds) {
            if (!job.getText().contains(location))
                return false;
        }
        for (WebElement job : even) {
            if (!job.getText().contains(location))
                return false;
        }
        return true;
    }

    public void clickOnJob(String jobName) {
        waitUntilClickable(getJobByName(jobName)).click();
    }

    private WebElement getJobByName(String jobName) {
        for(WebElement job : jobs) {
            if(job.getText().equals(jobName))
                return job;
        }
        return null;
    }
}
