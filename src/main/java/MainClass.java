import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {
        @Test
        public void FirstTest(){
                System.setProperty("webdriver.chrome.driver", "C:/Work/chromedriver-win64/chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.get("https://habr.com/ru/articles/");
                driver.manage().window().setSize(new Dimension(1920, 1080));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(
                        By.xpath("//*[@class='tm-svg-img tm-header-user-menu__icon tm-header-user-menu__icon_search tm-header-user-menu__icon_dark']")).click();
                Assert.assertEquals(driver.findElement(By.xpath("//*[@class='tm-search__input tm-input-text-decorated__input']")), driver.switchTo().activeElement());
                driver.findElement(By.xpath("//*[@class='tm-search__input tm-input-text-decorated__input']")).sendKeys("Selenium WebDriver");
                driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(By.linkText("Что такое Selenium?")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                Assert.assertEquals("28 сен 2012 в 16:14" ,driver.findElement(By.xpath("//*[@title='2012-09-28, 16:14']")).getText());
                driver.findElement(By.xpath("//a[@href='/ru/articles/' and @class='footer-menu__item-link']")).click();
                driver.quit();
        }

        @Test
        public void SecondTest(){
                System.setProperty("webdriver.chrome.driver", "C:/Work/chromedriver-win64/chromedriver.exe");
                WebDriver driver = new ChromeDriver();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                driver.get("https://eios.kemsu.ru/a/eios");
                driver.manage().window().setSize(new Dimension(1920, 1080));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                //Да, я осознаю, что все в интернете смогут увидесь мой пороль от ЭИОС через ГитХаб. Надеюсь, никто этим не воспользуется
                driver.findElement(By.xpath("//*[@placeholder='логин']")).sendKeys("stud71624");
                driver.findElement(By.xpath("//*[@placeholder='пароль']")).sendKeys("ASDFLKJTY1357");
                driver.findElement(
                        By.xpath("//*[@class='css-h0m9oy efn4aem0']")).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                Assert.assertEquals("Воронков Д.А." ,driver.findElement(By.xpath("//*[@class='css-10pdxt6 efn4aem0']")).getText());

                WebElement exit = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@class='eios-icon eios-icon-exit']")
                ));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", exit);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                Assert.assertTrue(";-)", driver.findElement(By.xpath("//*[@class='css-h0m9oy efn4aem0']")).isDisplayed());

                driver.quit();
        }
}

//driver.findElement(
//        By.xpath("//*[@class='css-1oslnw8 efn4aem0']")).click();