import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class NewEmailTest{

    WebDriver driver;
    WebDriverWait wait;

    /**
 @Before
    wait = new WebDriverWait(driver, 20);


  public void before(){
        driver = new ChromeDriver();

    driver.get("http://demo.testarena.pl");
    driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
    driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
    driver.findElement(By.id("login")).click();
     //   driver.close();
    }**/
    @After
    public void after (){


    }

    @Test

public void loginAdminAddUser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);


        driver.get("http://demo.testarena.pl");
        driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
        driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header_admin']")));
        assertTrue(driver.findElement(By.xpath("//div[@class='header_admin']")).isDisplayed());
        driver.findElement(By.xpath("//div[@class='header_admin']")).click();
        driver.findElement(By.xpath("//a[@href='http://demo.testarena.pl/administration/users']")).click();
        driver.findElement(By.className("button_link")).click();
        driver.findElement(By.id("firstname")).sendKeys("Papaaaa");
        driver.findElement((By.id("lastname"))).sendKeys("Smerfff");

        driver.findElement(By.id("email")).sendKeys("doTestow10.vistula.waw@migmail.pl");
        driver.findElement(By.id("organization")).sendKeys("WEb Driver Development Sp. z o.o.");
        driver.findElement(By.id("department")).sendKeys("IT Solutions");
        driver.findElement(By.id("phoneNumber")).sendKeys("5555 55 55555");
        driver.findElement(By.id("save")).click();
        driver.findElement(By.className("j_close_button")).click();

        driver.findElement(By.xpath("//td[@title='Papaaaa']")).isDisplayed();
        assertTrue(driver.findElement(By.xpath("//td[@class='t_name first-name'] |  //td[@title = 'Papaaaa']")).isDisplayed());

        driver.close();


    }

@Test
    public void checkEmail() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver,10);
    WebElement element;

    driver.get("http://migmail.pl/");
    driver.findElement(By.id("login")).sendKeys("doTestow10.vistula.waw");
    driver.findElement(By.xpath("//input[@type='submit']")).click();

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[a='Utworzenie konta']")));

    driver.findElement(By.xpath("//td[a='Utworzenie konta']")).click();
    driver.findElement(By.xpath("//a[contains(@href,'testarena.pl')]")).click();

    for (String handle : driver.getWindowHandles()) {
        driver.switchTo().window(handle);
    }
   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer_static")));
    assertTrue(driver.findElement(By.xpath("footer_static")).isDisplayed());
    driver.findElement(By.id("footer_static"));

    /******************
     * Java Script executor
     */
    /*
    WebElement createAccLink=driver.findElement(By.xpath("//a[contains(@href,'testarena.pl')]"));

    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", createAccLink)
    */

    //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer_static")));
    //driver.findElement(By.id("footer_static"));




    String pageSource=  driver.getPageSource();
   System.out.print(pageSource);
// przejscie na stronę ze zmiana hasła . Szuka pierwszego elementu do wpisania hasła


    //    driver.findElement(By.xpath("//*[contains(@href,'account')]")).click();
  wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
    assertTrue(driver.findElement(By.id("password")).isDisplayed());
    driver.findElement((By.xpath("//input[@id='password']"))).sendKeys("PapaSmerff6");
    driver.findElement(By.name("confirmPassword")).sendKeys("Smerf111");
    driver.findElement(By.id("new")).click();
//
   // JavascriptExecutor js = (JavascriptExecutor) driver2;
//    String pageSource=  driver.getPageSource();
  //    System.out.print(pageSource);
   // js.executeScript("document.getElementById('element').click();
    // String pageSource=  driver.getPageSource();
  //  System.out.print(pageSource);
  //  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains (@class, 'button-front')]")));
   //assertTrue(driver.findElement(By.xpath("//div[contains (@class, 'button-front')]")).isDisplayed());
  //  driver.findElement(By.id(" password")).sendKeys("Smerf111");   napisałam pod spodemby.name password

//    element =  driver.findElement(By.name("password"));
  //          element.sendKeys("Smerf111");
  //  driver.findElement(By.name("confirmPassword")).sendKeys("Smerf111");
//    driver.findElement(By.className("front-log"));
    //driver.findElement(By.tagName(" input")).sendKeys("Smerf111");
     // assertTrue(driver.findElement(By.xpath("//div[@class='login_tc_header']")).isDisplayed());

   // driver.findElement(By.xpath("//*[contains (@action,'http://demo.testarena.pl/creating_password')]"));
   // driver.findElement(By.tagName(" input")).sendKeys("Smerf111");

}

@Test

public void newPassword(){
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 20);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains (@action,'http://demo.testarena.pl/creating_password')]")));
    assertTrue(driver.findElement(By.xpath("//*[contains (@action,'http://demo.testarena.pl/creating_password')]")).isDisplayed());
 //driver.findElement(By.xpath("//*[contains (@action,'http://demo.testarena.pl/creating_password')]"));
  //  driver.findElement(By.xpath(" // div(@class='formContainer full' | //input[@id='password']")).sendKeys("Smerf111");
  //  driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("Smerf111");
  //  driver.findElement(By.id("new")).click();
    // driver.findElement(By.xpath("  //*[@id='password']")).sendKeys("Smerf111");
   // driver.findElement(By.tagName(" input")).sendKeys("Smerf111");

 //   driver.findElement(By.tagName(" password")).sendKeys("Smerf111");
  //  driver.findElement(By.name("confirmPassword")).sendKeys("Smerf111");
  //  driver.findElement(By.id("new")).click();


}





}
