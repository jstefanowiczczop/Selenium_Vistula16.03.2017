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
        driver.findElement(By.id("email")).sendKeys("doTestow00.vistula.waw@migmail.pl");
        driver.findElement(By.id("organization")).sendKeys("WEb Driver Development Sp. z o.o.");
        driver.findElement(By.id("department")).sendKeys("IT Solutions");
        driver.findElement(By.id("phoneNumber")).sendKeys("5555 55 55555");
        driver.findElement(By.id("save")).click();

        driver.findElement(By.className("j_close_button")).click();
        driver.findElement(By.xpath("//td[@title='Papaaaa']")).isDisplayed();
        assertTrue(driver.findElement(By.xpath("//td[@class='t_name first-name'] |  //td[@title = 'Papaaaa']")).isDisplayed());

        driver.close();
    }

    @After
    public void checkAddedNewUser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);


        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);

        }

        driver.findElement(By.xpath("//div[@id='j_info_box']"));
        assertTrue(driver.findElement(By.xpath("//div[@id='j_info_box']")).isDisplayed());


        driver.quit();
    }


    @Test

    public void checkEmailUserAndChangePasswordUser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get("http://migmail.pl/");
        driver.findElement(By.id("login")).sendKeys("doTestow00.vistula.waw");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[a='Utworzenie konta']")));

        driver.findElement(By.xpath("//td[a='Utworzenie konta']")).click();
        driver.findElement(By.xpath("//a[contains(@href,'testarena.pl')]")).click();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        assertTrue(driver.findElement(By.id("password")).isDisplayed());
        driver.findElement((By.xpath("//input[@id='password']"))).sendKeys("PapaSmerff6");
        driver.findElement(By.name("confirmPassword")).sendKeys("PapaSmerff6");
        driver.findElement(By.id("new")).click();

    }

}

