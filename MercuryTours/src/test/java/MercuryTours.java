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



public class MercuryTours {
    WebElement element;
    WebDriver driver;
    ExtentTest test;
    ExtentReports report;


    @Before

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\MercuryTours.html", true);
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

    public void mercuryTest() {
        test.log(LogStatus.INFO, "Website Accessed!");
        driver.get(Constant.websiteURL);
        HomePage page = PageFactory.initElements(driver, HomePage.class);
        page.register();
        test.log(LogStatus.INFO, "Navigate to Register page!");
        Register page1 = PageFactory.initElements(driver, Register.class);
        page1.fillForm("john","tom","123456789","tom@qa.com","35fsfdgg","london,","uk","L1 5TS","UK","tom123","123456","123456");
        test.log(LogStatus.INFO, "Register complete");
        test.log(LogStatus.INFO, "Login");
        page.signIn("tom123","123456");
        test.log(LogStatus.INFO, "Login Complete");



  }


}
