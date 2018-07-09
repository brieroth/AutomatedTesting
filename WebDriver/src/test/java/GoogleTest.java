import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleTest {
   WebElement element;
   WebDriver driver;


@Before

    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

@After
    public void teardown(){
        //driver.quit();
    }

@Test
    public void mthodTest() {
    driver.manage().window().maximize();
    driver.get("https://www.google.co.uk");
    //search bar
    WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
    //input into search bar
    checkElement.sendKeys("Hello");
    //search button
    WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]"));
    searchButton.click();
    //click on youtube button
    WebElement helloButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div[2]/h3/a"));
    helloButton.click();




}



}
