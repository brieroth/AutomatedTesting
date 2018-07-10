
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class demoSite {

    WebElement element;
    WebDriver driver;
    ExtentTest test;
    ExtentReports report;

    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\DemoTest.html", true);
        test =  report.startTest("Testing");
    }

    @After
    public void teardown() {
        driver.quit();
        report.endTest(test);
        report.flush();
        driver.quit();

    }

    @Test
    public void methodTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://thedemosite.co.uk/");
        //search bar
        WebElement checkElement = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
        checkElement.click();
        Thread.sleep(1000);
        // Add a user
        WebElement usrName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
        usrName.sendKeys("lana");
        WebElement usrPassword = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
        usrPassword.sendKeys("lana");
        WebElement saveButton = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
        saveButton.click();
        Thread.sleep(1000);
        //Log In
        WebElement logIn = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
        logIn.click();
        WebElement logName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
        logName.sendKeys("lana");
        WebElement logPassword = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
        logPassword.sendKeys("lana");
        WebElement logButton = driver.findElement(By.xpath(" /html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
        logButton.click();
        assertEquals("Successful Login",driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());

    }

        //Test website by Page Object Model (POM) design; creating a class for each webpage!!
    @Test
    public void homeTest() {
        test.log(LogStatus.INFO, "Website Accessed!");
        driver.get("http://thedemosite.co.uk/");
        HomePage page = PageFactory.initElements(driver, HomePage.class);
        page.clickAddButton();
        test.log(LogStatus.INFO, "Navigate to Add User page!");

        AddUser page1 = PageFactory.initElements(driver, AddUser.class);
        page1.addUser("lana", "lana");
        page1.clickLogButton();
        test.log(LogStatus.INFO, "Navigate to Login page");

        LogIn page2 = PageFactory.initElements(driver, LogIn.class);
        page2.logIn("lana", "lana");
        test.log(LogStatus.PASS, "login success");

        //get title of the current page for testing
        String title = driver.getTitle();
        System.out.println(title);

        //if statement to determine success if title page matches string below
        if (title.equals("Login example page to test the PHP MySQL online system")) {
           test.log(LogStatus.PASS, "verify Title of the page! Success!");
       }
        else {
            test.log(LogStatus.FAIL, "verify Title of the page");
        }
        assertEquals("**Successful Login**",driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());

    }























//    public void homeTest() {
//        driver.get("http://thedemosite.co.uk/");
//        HomePage page = PageFactory.initElements(driver, HomePage.class);
//        page.clickAddButton();
//        addTest();
//        logTest();
////     }

//    public void addTest(){
//        AddUser page = PageFactory.initElements(driver,AddUser.class);
//        page.addUser("lana", "lana");
//        page.clickLogButton();
////    }
////    public void logTest(){
//        LogIn page = PageFactory.initElements(driver,LogIn.class);
//        page.logIn("lana", "lana");
//     }










}