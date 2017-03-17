import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Jola on 2017-03-12.
 */
public class LoginTest {
    WebDriver driver ;
    WebDriverWait wait;
// obiekty dostepne w każdym z naszych testów
    @Before
    public void  before (){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
    // Obiekty otwierane metoda before
    }
    @After
    public void after (){
        driver.close();
    // metody zamykane metoda after
    }


    @Test
    public void shouldLoginCorectly() {


        //stworzyłam obiekt klasy driver dla klasy Webdriver i on bedzie korzystac z FirefoxaDrivera

        driver.get("http://demo.testarena.pl");
        //otwieram stonę internetową

        driver.findElement(By.id("email")).sendKeys("administrator@testarena.pl");
        //szuka elementu emial poniewaz biorąc kod zródłowy pole login ma id emial
        //sendKeys służy doo wpisania w element loginy
        // podsumowanie: kod powyzej szuka pola do wpisania loginu i i wpisuje login
        // powyższe jest to samo co WebElement emialField = driver.findElement(By.id("email")).sendKeys("administratot@testarena.pl");
        // wówczas mozemy wywołać emailFeld  z innego miejsca
        // nie będziemy tak robic poniewaz nie bedziemy tego wiecej ruzywac tego pola


        driver.findElement(By.id("password")).sendKeys("sumXQQ72$L");
        driver.findElement(By.id("login")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header_logout']")));
        // linia stabilizuje test

        assertTrue(driver.findElement(By.xpath("//div[@class='header_logout']")).isDisplayed());
       // driver.close();
        // driver.close przeniesiony do metody after

        // test nie działa pomimo prawidłowych warunków testowych.TZN ze jest niestabilny
        //


    }


}
