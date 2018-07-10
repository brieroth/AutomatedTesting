import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class ShoppingWebsite {

        WebElement element;
        WebDriver driver;

    @Before

        public void setup() {
            System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
    @After
         public void teardown() {
             driver.quit();
         }

    @Test
        public void mthodTest() throws InterruptedException {
            driver.manage().window().maximize();
            driver.get("http://automationpractice.com/index.php");
            WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
            searchButton.sendKeys("dress");
            WebElement button = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
            button.click();
            assertEquals("7 results have been found.",driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText());

     }

     @Test
     public  void dressTest() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
         HomePage page = PageFactory.initElements(driver,HomePage.class);
         page.searchBar("dress");
         //page.clickButton();
         assertEquals("7 results have been found.",driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText());


     }





















}
