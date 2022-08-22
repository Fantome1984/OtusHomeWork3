package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VisibilityСheck {
    public VisibilityСheck(WebDriver driver) {
        this.driver = driver;
    }

   public boolean isVisible(String locator){
        try {
            driver.findElement(By.id(locator));
            return true;
        }
        catch (Exception ex){
            return false;
        }


    }
    private WebDriver driver;

}
