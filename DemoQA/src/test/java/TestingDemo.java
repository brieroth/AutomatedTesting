import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class TestingDemo {

    WebElement element;
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        //Actions action = new Actions(driver);

    }

     @Test
    public void demoQATest() throws InterruptedException {
        driver.get("http://demoqa.com/");
         Actions action = new Actions(driver);
         action.moveByOffset(100, 100).perform();
         driver.findElement(By.xpath("//*[@id=\"menu-item-144\"]/a")).click();
    }




    @After
    public void tearDown() {

        driver.quit();

    }
}

