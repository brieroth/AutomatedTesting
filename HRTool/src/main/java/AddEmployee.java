import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployee {

    @FindBy (id="firstName")
     private WebElement firstName;

    @FindBy (xpath= "//*[@id=\"middleName\"]")
    private WebElement middleName;

    @FindBy (xpath= "//*[@id=\"lastName\"]")
    private WebElement lastName;

    @FindBy (xpath= "//*[@id=\"employeeId\"]")
    private WebElement employeeId;

    @FindBy (xpath ="//ul[@id='select-options-7d12e654-06f2-909f-2554-887143ad2955']/li[3]/span")
      private WebElement location;

    @FindBy (xpath = "//form[@id='pimAddEmployeeForm']/div/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement createUser;

    //LOGIN DETAILS
    @FindBy (xpath= "//*[@id=\"username\"]")
    private WebElement logUser;
    @FindBy (xpath = "//*[@id=\"password\"]")
    private WebElement pass;
    @FindBy (xpath="//*[@id=\"confirmPassword\"]")
    private WebElement confirmP;
    @FindBy (xpath= "//*[@id=\"status_inputfileddiv\"]/div/input")
    private WebElement status;
    @FindBy (xpath= "//*[@id=\"essRoleId_inputfileddiv\"]/div/input")
    private WebElement eSS;
    @FindBy (xpath= "//*[@id=\"supervisorRoleId_inputfileddiv\"]/div/input")
    private WebElement roleID;
    @FindBy (xpath= "//*[@id=\"adminRoleId_inputfileddiv\"]/div/input")
    private WebElement adminRID;
    @FindBy (id = "systemUserSaveBtn")

    private WebElement saveButton;

    public void fillForm (String name, String middle, String last, String id, String loc){
        firstName.sendKeys(name);
        middleName.sendKeys(middle);
        lastName.sendKeys(last);
        employeeId.sendKeys(id);
        location.sendKeys(Keys.TAB);
        location.sendKeys(loc);

     }

     public void logDetails( ){
        createUser.click();
     }

     public void createLogDetails(String user, String pass1, String confirm, String status1, String ess1, String role, String admin){
         logUser.sendKeys(user);
         pass.sendKeys(pass1);
         confirmP.sendKeys(confirm);
         status.sendKeys(status1);
         status.sendKeys(Keys.TAB);
         eSS.sendKeys(ess1);
         eSS.sendKeys(Keys.TAB);
         roleID.sendKeys(role);
         roleID.sendKeys(Keys.TAB);
         adminRID.sendKeys(admin);
         adminRID.sendKeys(Keys.TAB);
             }
    public void saveLog( ){
        saveButton.click();
    }




}
