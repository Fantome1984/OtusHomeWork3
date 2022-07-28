package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseUiTest {
    protected WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @After
    public void setDown(){
        if (driver != null);
        driver.quit();
    }
}
