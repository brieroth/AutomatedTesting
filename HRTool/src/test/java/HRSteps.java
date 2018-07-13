
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
import gherkin.lexer.Pa;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class HRSteps {
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
        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\HR_Tool.html", true);
        test = report.startTest("HR_Tool");
    }

    @Given("^the login page$")
    public void the_login_page() {
        driver.get(Constant.logURL);
        test.log(LogStatus.INFO, "Website Accessed!");
    }

    @When("^I login$")
    public void i_login()  {
        LogIn log = PageFactory.initElements(driver, LogIn.class);
        log.login("Admin", "AdminAdmin");
        test.log(LogStatus.INFO, "Log in successful");
        }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() {
        Homepage page = PageFactory.initElements(driver, Homepage.class);
        page.pimT();
        test.log(LogStatus.INFO, "Pim Tab clicked");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveByOffset(100, 100).perform();
        driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]/span[2]")).click();
        test.log(LogStatus.INFO, "Add Employee tab clicked");
        Thread.sleep(1000);
            }

    @When("^I fill out the Employee Details correctly$")
    public void i_fill_out_the_Employee_Details_correctly() throws InterruptedException {
        AddEmployee emp = PageFactory.initElements(driver, AddEmployee.class);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(Constant.empURL);
        WebElement popup= driver.findElement(By.xpath("//*[@id=\"pimAddEmployeeForm\"]/div[1]/div"));
        emp.fillForm("Oscar", "Oliver", "Rey", "07678");
        Thread.sleep(1000);
        test.log(LogStatus.INFO, "Add Employee fill formed");
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button(){
        AddEmployee emp1 = PageFactory.initElements(driver, AddEmployee.class);
        emp1.logDetails();
        test.log(LogStatus.INFO, "Create log in details box ticked");
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly()  {
        AddEmployee emp2 = PageFactory.initElements(driver, AddEmployee.class);
        emp2.createLogDetails("otiskev867", "12345678", "12345678","Enabled", "Default ESS", "Default Supervisor","Asset Manager" );
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws InterruptedException {
        AddEmployee emp3 = PageFactory.initElements(driver, AddEmployee.class);
        emp3.saveLog();
        Thread.sleep(4000);
        test.log(LogStatus.INFO, "log in details saved");
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws InterruptedException {
        SearchEmployee srch = PageFactory.initElements(driver, SearchEmployee.class);
        srch.searchEmp("07678");
        test.log(LogStatus.PASS, "Employee searched and found");
          }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() {
        SearchEmployee srch2 = PageFactory.initElements(driver, SearchEmployee.class);
        //srch2.findE();
        test.log(LogStatus.INFO, "Commence Inspection");

        String url = driver.getCurrentUrl();
        System.out.println(url);
        String expected = Constant.empURL;
        if (url.equals(expected)) {
            test.log(LogStatus.PASS, "Inspection Success!");
        }
        else {
            test.log(LogStatus.FAIL, "Inspection Failed!");
        }
        assertEquals("Personal Details", driver.findElement(By.xpath("//*[@id=\"personal_details_tab\"]/h4")).getText());


    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        report.endTest(test);
        report.flush();
        driver.close();
        driver.quit();
    }



}
