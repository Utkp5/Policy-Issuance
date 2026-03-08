package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://pi.policysearch.in/");
    }
    
    //@AfterClass
    @AfterClass
    public void close()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }

    
}