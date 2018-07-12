import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu {


    @FindBy (xpath= "//*[@id=\"wsb-element-00000000-0000-0000-0000-000451955160\"]")


    private WebElement greenCheckOut;

    public void menu(){
        greenCheckOut.click();

    }


}
