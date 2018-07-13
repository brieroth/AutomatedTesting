
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class PassionateSteps {

    WebElement element;
    WebDriver driver;
    String url;
    ExtentTest test;
    ExtentReports report;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\PassionateTeaBDD.html", true);
        test =  report.startTest("PassionateTea");
    }


    @Given("^the correct web address$")
    public void the_correct_web_address() {
        driver.get(Constant.websiteURL);
    }

    @When("^I navigate to the 'Menu' page$")
    public void i_navigate_to_the_Menu_page() {
        // Write code here that turns the phrase above into concrete actions
        HomePage page = PageFactory.initElements(driver, HomePage.class);
        page.menuB();
        test.log(LogStatus.INFO, "Website Accessed!");
    }

    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products() {
        // Write code here that turns the phrase above into concrete actions
        Menu page1 = PageFactory.initElements(driver, Menu.class);
        page1.menu();
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(Constant.menuURL);
        Menu page1 = PageFactory.initElements(driver, Menu.class);
        page1.menu();

    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page() {
        // Write code here that turns the phrase above into concrete actions    throw new PendingException();
        driver.get(Constant.checkOutURL);
        CheckOut page2 = PageFactory.initElements(driver, CheckOut.class);
        page2.fillForm("lana@aol.com", "Lana Rey", "23 MoreLane", "Visa", "2345089372", "Miss Lana Rey", "234");
//        assertTrue(!url.equals(driver.getCurrentUrl()));
        assertEquals("Pay with Credit Card or Log In", driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")).getText());

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}























