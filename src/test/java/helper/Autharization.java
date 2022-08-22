package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Autharization extends BaseUiTest{


        LoginPassword loginPassword = new LoginPassword();


        public Autharization(WebDriver driver){
            this.driver = driver;
        }


        private By clickButton = By.className("header2__auth-reg");
        private By enteringMail = By.xpath("//form[@action = '/login/']//input[@name = 'email']");
        private By enteringPassword = By.xpath("//form[@action = '/login/']//input[@name = 'password']");
        private By entrance = By.xpath("//form[@action = '/login/']//button[@type ='submit']");



        public void auth(){
            driver.findElement(clickButton).click();
            driver.findElement(enteringMail).sendKeys(loginPassword.getLogin());
            driver.findElement(enteringPassword).sendKeys(loginPassword.getPassword());
            driver.findElement(entrance).click();
        }
        private WebDriver driver;

    }

