import helper.BaseUiTest;
import helper.Logger;
import helper.LoginPassword;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class UiTests extends BaseUiTest{

    LoginPassword loginPassword = new LoginPassword();
    public org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);


    @Test
    public void searchOtus(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        logger.info("Открыли браузер в headless режиме");

        driver.get("https://duckduckgo.com/");
        logger.info("Перешли в поисковую систему");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("ОТУС");
        driver.findElement(By.id("search_button_homepage")).click();
        logger.info("Ввели в поисковю строку ОТУС и кликнули по кнопке поиска ");

        WebElement element = driver.findElement(By.xpath("//div[@class='ikg2IXiCD14iVX7AdZo1']"));
        String actual = element.getText();
        String exspected ="Онлайн‑курсы для профессионалов, дистанционное обучение современным ...";
        Assert.assertEquals(actual,exspected);
        logger.info("Проверка поисковой выдачи");
    }
    @Test
    public void imageSearch()  {
        driver.manage().window().fullscreen();
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/" +
                "03-10-2020/photoflash-liberty-demo_Free/685659620/web/" +
                "index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        driver.findElement(By.xpath("//li[@data-id='id-1']")).click();
        isVisible( "//div[@class='pp_pic_holder light_rounded']");

    }

    @Test
    public void otusAvtorization(){
        driver.get("https://otus.ru/");
        logger.info("Открыли сайт Отуса");
        auth();
        logger.info("Произвели авторизацю");
        driver.manage().addCookie(new Cookie("login","mk66@mailinator.com"));
        driver.manage().addCookie(new Cookie("password","Test12345"));
        logger.info(driver.manage().getCookies());
        logger.info("Вывели Cookie");
    }

    public void auth(){
        driver.findElement(By.className("header2__auth-reg")).click();
        driver.findElement(By.xpath("//form[@action = '/login/']//input[@name = 'email']"))
                .sendKeys(loginPassword.getLogin());
        driver.findElement(By.xpath("//form[@action = '/login/']//input[@name = 'password']")).
                sendKeys(loginPassword.getPassword());
        driver.findElement(By.xpath("//form[@action = '/login/']//button[@type ='submit']")).submit();
    }


    private boolean isVisible(String locator){
       try {
           driver.findElement(By.id(locator));
           return true;
       }
       catch (Exception ex){
           return false;
       }


    }


}
