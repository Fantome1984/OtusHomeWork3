import helper.*;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.util.Set;


public class UiTest extends BaseUiTest {


    private By picture = By.xpath("//img[@id='fullResImage']");
    private By userName = By.xpath("//div[@data-name='user-info']" +
            "//span[@class='header3__user-info-name']");
    private By searchResults = By.xpath("//span[text()='Онлайн‑курсы для профессионалов," +
            " дистанционное обучение современным ...']");

    private String duckduckgoUrl="https://duckduckgo.com/";
    private String otusUrl = "https://otus.ru/";
    private String w3layoutsUrl ="https://demo.w3layouts.com/demos_new/template_demo/" +
                    "03-10-2020/photoflash-liberty-demo_Free/685659620/web/" +
                    "index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818";






    public org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);
    @Test
    @Tag(value = "headless")
    public void searchOtus()  {
        MethodsHelper methodsHelper = new MethodsHelper(driver);
      logger.info("Открыли браузер в headless режиме");
        driver.get(duckduckgoUrl);
        logger.info("Перешли в поисковую систему");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("ОТУС");
        driver.findElement(By.id("search_button_homepage")).click();
        logger.info("Ввели в поисковю строку ОТУС и кликнули по кнопке поиска ");
        methodsHelper.getElement(searchResults);
        WebElement element = driver.findElement(searchResults);
        String actual = element.getText();
        String exspected ="Онлайн‑курсы для профессионалов, дистанционное обучение современным ...";
        Assertions.assertEquals(actual,exspected);
        logger.info("Проверка поисковой выдачи");


    }
    @Test
    @Tag(value = "fullscreen")
    public void imageSearch() {
        MethodsHelper methodsHelper = new MethodsHelper(driver);
        logger.info("Открыли браузер в fullscreen");
        driver.get(w3layoutsUrl);
        logger.info("Перешли на сайт");
        driver.findElement(By.xpath("//li[@data-id='id-1']")).click();
        logger.info("Кликнули по картинке");
        Assertions.assertTrue(methodsHelper.getElement(picture).isDisplayed());
        logger.info("Проверили что картинка открылась в модальном окне");
        driver.findElement(
                By.xpath("//img[@id='fullResImage']")).isDisplayed();
       }

    @Test
    @Tag(value = "maximize" )
    public void otusAvtorization()  {
        Autharization autharization = new Autharization(driver);
        MethodsHelper helper = new MethodsHelper(driver);
        driver.get(otusUrl);
        logger.info("Открыли сайт Отуса");
        autharization.auth();
        logger.info("Произвели авторизацю");
       Set<Cookie> cookiesList = driver.manage().getCookies();
        for (Cookie getCookies : cookiesList){
            System.out.println(getCookies);
        }
        logger.info("Вывели Cookie");
       helper.getElement(userName);
        WebElement element = driver.findElement(userName);
        String actual = element.getText();
        String exspected ="Румпель";
      Assertions.assertEquals(actual,exspected);
        logger.info("Проверили имя указанное при регистрации на главной странице сайта");

    }
    }



