import helper.*;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




public class UiTest extends BaseUiTest {

    public org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    @Test
    @Tag(value = "headless")
    public void searchOtus(){
      logger.info("Открыли браузер в headless режиме");

        driver.get("https://duckduckgo.com/");
        logger.info("Перешли в поисковую систему");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("ОТУС");
        driver.findElement(By.id("search_button_homepage")).click();
        logger.info("Ввели в поисковю строку ОТУС и кликнули по кнопке поиска ");

        WebElement element = driver.findElement(By.xpath("//div[@class='ikg2IXiCD14iVX7AdZo1']"));
        String actual = element.getText();
        String exspected ="Онлайн‑курсы для профессионалов, дистанционное обучение современным ...";
        Assertions.assertEquals(actual,exspected);

        logger.info("Проверка поисковой выдачи");


    }
    @Test
    @Tag(value = "fullscreen")
    public void imageSearch()  {
        logger.info("Открыли браузер в fullscreen");

        driver.get("https://demo.w3layouts.com/demos_new/template_demo/" +
                "03-10-2020/photoflash-liberty-demo_Free/685659620/web/" +
                "index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        logger.info("Перешли на сайт");

        driver.findElement(By.xpath("//li[@data-id='id-1']")).click();
        logger.info("Кликнули по картинке");

       VisibilityСheck visibilityСheck = new VisibilityСheck(driver);
       visibilityСheck.isVisible("//div[@class='pp_pic_holder light_rounded']");
        WebElement actual = driver.findElement(By.xpath("//div[@class='pp_pic_holder light_rounded']"));
        WebElement exspected = driver.findElement(By.xpath("//div[@class='pp_pic_holder light_rounded']"));
       Assertions.assertEquals(actual,exspected);
        logger.info("Проверили что картинка открылась в модальном окне");




       }

    @Test
    @Tag(value = "maximize" )
    public void otusAvtorization(){
        driver.get("https://otus.ru/");
        logger.info("Открыли сайт Отуса");
        Autharization autharization = new Autharization(driver);
        autharization.auth();
        logger.info("Произвели авторизацю");
        logger.info(driver.manage().getCookies());
        logger.info("Вывели Cookie");
        WebElement element = driver.findElement(By.xpath("//div [@class='header2-menu__item-wrapper " +
                "header2-menu__item-wrapper__username']"));
        String actual = element.getText();
        String exspected ="Румпель";
      Assertions.assertEquals(actual,exspected);
        logger.info("Проверили имя указанное при регистрации на главной странице сайта");

    }

    }



