import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;
/**
 * Created by Jola on 2017-03-15.
 */
public class tetsWeb {
    WebDriver driver;
    WebDriverWait wait;
   @Test

    public void loginAdminAddUser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);


        driver.get("file:///C:/Users/Jola/Desktop/ustaw%20has%C5%82o.html");
        driver.findElement(By.xpath(" //*[@id='password']")).isDisplayed();
        assertTrue(driver.findElement(By.xpath("//*[@id='password']")).isDisplayed());

    }
}