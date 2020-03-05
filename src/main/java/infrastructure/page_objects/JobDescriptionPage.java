package infrastructure.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobDescriptionPage extends BasePage {

    @FindBy(id = "requisitionDescriptionInterface.reqContestNumberValue.row1")
    public WebElement jobNumber;

    public String getJobNumber() {
        return jobNumber.getText();
    }
}
