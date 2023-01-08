package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Autharization{



      private LoginPassword loginPassword = new LoginPassword();

      public Autharization(WebDriver driver){this.driver = driver;}

        private By clickButton = By.xpath("//button[@class ='header3__button-sign-in']");



        public void fieldFillingsAuth(){
            MethodsHelper methodsHelper = new MethodsHelper(driver);
            methodsHelper.getElement(By.xpath("//form[@action = '/login/']"));
            WebElement authForm = driver.findElement(By.xpath("//form[@action = '/login/']"));
            WebElement emailField = authForm.findElement(By.xpath(".//input[@name = 'email']"));
            WebElement passwordField = authForm.findElement(By.xpath(".//input[@name = 'password']"));
            emailField.sendKeys(loginPassword.getLogin());
            passwordField.sendKeys(loginPassword.getPassword());
            WebElement entrance = authForm.findElement(By.xpath(".//button[@type ='submit']"));
            entrance.click();
        }

        public  void auth()  {
           MethodsHelper methodsHelper = new MethodsHelper(driver);
           methodsHelper.getElement(clickButton);
            driver.findElement(clickButton).click();
            fieldFillingsAuth();
        }
    private WebDriver driver;

    }


