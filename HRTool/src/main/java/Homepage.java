import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Homepage {

    @FindBy (xpath= "//*[@id=\"menu_pim_viewPimModule\"]/a")
    private WebElement pimTab;

    @FindBy (xpath = "//*[@id=\"menu_pim_addEmployee\"]/span[2]")
    private WebElement addEmployee;


    public void pimT(){
        pimTab.click();
    }

    public void addEmp(){
          addEmployee.click();
    }


}
