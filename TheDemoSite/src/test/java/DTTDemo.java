import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import javafx.scene.control.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
public class DTTDemo {

        WebElement element;
        WebDriver driver;
        ExtentTest test;
        ExtentReports report;
        String LoginData = "C:\\Users\\Admin\\Desktop\\AutomationReports\\DemoSiteDDT.xlsx";

        @Before

        public void setup() throws Exception {
                ExcelUtils.setExcelFile(Constant.Path_ExcelData + Constant.File_ExcelData, 0);
                System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
                driver = new ChromeDriver();
                report = new ExtentReports("C:\\Users\\Admin\\Desktop\\AutomationReports\\DemoTestDTT.html", true);
                test =  report.startTest("Testing");
        }

        @Test
         public void dttExcelTest() {
            FileInputStream file = null;
            try {
                file = new FileInputStream(Constant.Path_ExcelData + Constant.File_ExcelData);
            } catch (FileNotFoundException e) {}

            XSSFWorkbook workbook = null;
            try {
                workbook = new XSSFWorkbook(file);
            } catch (IOException e) { }

            XSSFSheet sheet = workbook.getSheetAt(0);
            //XSSFCell cell = sheet.getRow(0).getCell(0);

            //get values for each cell and pass as string
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++){
                XSSFCell username = sheet.getRow(i).getCell(0);
                XSSFCell password = sheet.getRow(i).getCell(1);
                String user = username.getStringCellValue();
               	String pass = password.getStringCellValue();

                driver.get("http://thedemosite.co.uk/");
                test.log(LogStatus.INFO, "Website Accessed!");
                HomePage page = PageFactory.initElements(driver, HomePage.class);
                page.clickAddButton();
                test.log(LogStatus.INFO, "Navigate to Add User page!");

                test.log(LogStatus.INFO, "inputting new username");
                AddUser page1 = PageFactory.initElements(driver, AddUser.class);
                page1.addUser(user,pass);
                page1.clickLogButton();
                System.out.println("test1");
                test.log(LogStatus.INFO, "Navigate to Login page");

                test.log(LogStatus.INFO, "inputting login details");
                LogIn page2 = PageFactory.initElements(driver, LogIn.class);
                page2.logIn(user,pass);
                System.out.println("login1");
                test.log(LogStatus.PASS, "login success");


                String title = driver.getTitle();
                System.out.println(title);
                String expected = "Login example page to test the PHP MySQL online system";

                if (title.equals(expected)) {
                    test.log(LogStatus.PASS, "Successfully verified  Title of the page!!");
                    ExcelUtils.setCellData("Pass", i, 2);
                }
                else {
                    test.log(LogStatus.FAIL, "Failed to verify Title of the page");
                    ExcelUtils.setCellData("Fail", i, 2);
                }

                assertEquals(expected, title);




            }


        }












    @After
    public void teardown() {
        driver.quit();
        report.endTest(test);
        report.flush();
        driver.quit();

    }
}
