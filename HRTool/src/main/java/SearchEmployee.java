import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchEmployee {
    @FindBy (xpath="//*[@id=\"employee_name_quick_filter_employee_list_value\"]")
    private WebElement search;

    @FindBy (xpath = "//*[@id=\"quick_search_icon\"]")
    private WebElement button;

//    @FindBy (xpath = "//*[@id=\"employeeListTable\"]/tbody/tr/td[3]")
//    private WebElement findE;


    public void searchEmp (String id){
        search.sendKeys(id);

    }
//
//    public void findE(){
//        findE.click();
//    }

}

