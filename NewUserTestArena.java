import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static junit.framework.TestCase.assertTrue;


public class NewUserTestArena {

    WebDriver driver;
    WebDriverWait wait;


    @Before
    public void addNewUser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        //open website and logging in by administration
        driver.get("http://demo.testarena.pl");
        driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
        driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
        driver.findElement(By.id("login")).click();

        //open window in order to register new user
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header_admin']")));
        assertTrue(driver.findElement(By.xpath("//div[@class='header_admin']")).isDisplayed());
        driver.findElement(By.xpath("//div[@class='header_admin']")).click();
        driver.findElement(By.xpath("//a[@href='http://demo.testarena.pl/administration/users']")).click();
        driver.findElement(By.className("button_link")).click();

        //register new user
        driver.findElement(By.id("firstname")).sendKeys("Papa");
        driver.findElement((By.id("lastname"))).sendKeys("Smerf");

        //if you want to do this test again you shoud change email
        driver.findElement(By.id("email")).sendKeys("vistula7.waw@migmail.pl");
        driver.findElement(By.id("department")).sendKeys("IT Solutions");
        driver.findElement(By.id("save")).click();

        //check saved new user
        driver.findElement(By.className("j_close_button")).click();
        driver.findElement(By.xpath("//td[@title='Papa']")).isDisplayed();
        assertTrue(driver.findElement(By.xpath("//td[@class='t_name first-name'] |  //td[@title = 'Papa']")).isDisplayed());

        driver.close();
    }


 @After
   public void checkAddedNewUser() {

    // we can see window for a new user, we check if the user is correct
     //if you want to do this test again you shoud change email
     ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text() = 'vistula7.waw@migmail.pl']"));
     driver.findElement(By.xpath("//*[text() = 'vistula7.waw@migmail.pl']"));
     assertTrue(driver.findElement(By.xpath("//*[text() = 'vistula7.waw@migmail.pl']")).isDisplayed());

    driver.quit();
    }


    @Test

    public void checkEmailUserAndChangePasswordUser() {

         //login on email
        driver.get("http://migmail.pl/");

        //if you want to do this test again you shoud change email
        driver.findElement(By.id("login")).sendKeys("vistula6.waw");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // find new messege and clik on it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[a='Utworzenie konta']")));
        driver.findElement(By.xpath("//td[a='Utworzenie konta']")).click();
        driver.findElement(By.xpath("//a[contains(@href,'testarena.pl')]")).click();

        // go to the recently opened new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        assertTrue(driver.findElement(By.id("password")).isDisplayed());

       // write new user password and click
        driver.findElement((By.xpath("//input[@id='password']"))).sendKeys("PapaSmerff6");
        driver.findElement(By.name("confirmPassword")).sendKeys("PapaSmerff6");
        driver.findElement(By.id("new")).click();

    }

}

