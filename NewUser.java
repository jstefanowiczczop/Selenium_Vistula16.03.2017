import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Jola on 2017-03-12.
 */
public class NewUser {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);

        driver.get("http://demo.testarena.pl");
        driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
        driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
        driver.findElement(By.id("login")).click();

    }

    @After
    public void after() {

    //    driver.close();

            }


    @Test
    public void newUser() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header_admin']")));
        assertTrue(driver.findElement(By.xpath("//div[@class='header_admin']")).isDisplayed());
        driver.findElement(By.xpath("//div[@class='header_admin']")).click();

        driver.findElement(By.xpath("//a[@href='http://demo.testarena.pl/administration/users']")).click();
        driver.findElement(By.className("button_link")).click();
        driver.findElement(By.id("firstname")).sendKeys("laladtgkklddd");
        driver.findElement((By.id("lastname"))).sendKeys("tatrkkrrgggratata");
        driver.findElement(By.id("email")).sendKeys("dotestow.vistula.waw@migmail.pl");
        driver.findElement(By.id("organization")).sendKeys("WEb Driver Development Sp. z o.o.");
        driver.findElement(By.id("department")).sendKeys("IT Solutions");
        driver.findElement(By.id("phoneNumber")).sendKeys("5555 55 55555");

        driver.findElement(By.id("save")).click();
        driver.findElement(By.className("j_close_button")).click();
        driver.findElement(By.xpath("//td[@title='laladtgkklddd']")).isDisplayed();
        assertTrue(driver.findElement(By.xpath("//td[@class='t_name first-name'] |  //td[@title = 'laladtgkklddd']")).isDisplayed());


            }
}
