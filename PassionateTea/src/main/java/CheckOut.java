import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOut {

    @FindBy (xpath = "//*[@id=\"email\"]")
    private WebElement email;

    @FindBy (xpath = "//*[@id=\"name\"]")
    private WebElement name;

    @FindBy (xpath = "//*[@id=\"address\"]")
    private WebElement address;

    @FindBy (id = "card_type")
    private WebElement cardType;

    @FindBy (xpath = "//*[@id=\"card_number\"]")
    private WebElement cardNumber;

    @FindBy (xpath = "//*[@id=\"cardholder_name\"]")
    private WebElement cardHolderName;

    @FindBy (xpath = " //*[@id=\"verification_code\"]")
    private WebElement verificationCode;

    @FindBy (xpath = " //*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/button")
    private WebElement placeOrderButton;

//mouse move for card type

    public void fillForm(String email1,String name1,String address1,String cardType1,String cardNumber1,String cardHolderName1,String verificationCode1){

        email.sendKeys(email1);
        name.sendKeys(name1);
        address.sendKeys(address1);
        cardType.sendKeys(cardType1);
        cardType.sendKeys(Keys.TAB);
        cardNumber.sendKeys(cardNumber1);
        cardHolderName.sendKeys(cardHolderName1);
        verificationCode.sendKeys(verificationCode1);
        placeOrderButton.submit();
    }
}


