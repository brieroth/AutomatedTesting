import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn {

    @FindBy (xpath="//*[@id=\"txtUsername\"]")
    private WebElement username;

    @FindBy (xpath = "//*[@id=\"txtPassword\"]")
    private WebElement password;

    @FindBy (xpath= "//*[@id=\"btnLogin\"]")
    private WebElement logButton;


    public void login (String userName, String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);
        logButton.click();
            }

}
