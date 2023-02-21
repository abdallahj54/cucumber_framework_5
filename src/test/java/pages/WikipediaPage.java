package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class WikipediaPage {

    public WikipediaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "searchInput")
    public WebElement searchInput;

    @FindBy(id = "firstHeading")
    public WebElement firstHeading;

    @FindBy(css = ".link-box > strong")
    public List<WebElement> mainLanguages;
}
