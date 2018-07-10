import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy (id = "search_query_top")
    private WebElement searchBar;

    @FindBy (xpath = "//*[@id=\"searchbox\"]/button")
    private WebElement searchButton;

    public void searchBar(String search) {
        searchBar.sendKeys(search);
        searchButton.click();

    }
    }

