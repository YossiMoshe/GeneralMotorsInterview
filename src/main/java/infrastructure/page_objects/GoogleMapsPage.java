package infrastructure.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMapsPage extends BasePage {

    @FindBy(xpath = "//input[@id='searchboxinput']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@id='searchbox-searchbutton']")
    public WebElement searchBtn;

    @FindBy(xpath = "//button[@id='widget-zoom-in']")
    public WebElement zoomIn;


    public void findLocation(String location) {
        searchBox.sendKeys(location);
        searchBtn.click();
    }

    public void zoomIn() {
        zoomIn.click();
    }

}
