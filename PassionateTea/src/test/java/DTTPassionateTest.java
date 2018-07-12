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

import javax.xml.ws.Holder;

import static junit.framework.TestCase.assertEquals;

public class DTTPassionateTest {

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
        report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\PassionateTea.html", true);
        test =  report.startTest("PassionateTea");
    }
    @Test
    public void pTest() {
        driver.get(Constant.websiteURL);
        test.log(LogStatus.INFO, "Website Accessed!");
        HomePage page = PageFactory.initElements(driver, HomePage.class);
        page.menuB();
        test.log(LogStatus.INFO, "Menu page accessed");
        Menu page2 = PageFactory.initElements(driver, Menu.class);
        page2.menu();
        test.log(LogStatus.INFO, "Checkout accessed");
        CheckOut page3 = PageFactory.initElements(driver, CheckOut.class);
        page3.fillForm("lana@aol.com", "Lana", "23 Morelane", "Visa", "1234", "Lana Rey", "234");
        test.log(LogStatus.INFO, "Checkout complete");
        assertEquals("Menu", driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1")).getText());
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
