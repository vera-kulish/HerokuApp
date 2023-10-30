import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TyposTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void typos() {
        driver.get("https://the-internet.herokuapp.com/typos");
        for(int i = 0; i < 5; i++) {
            Assert.assertEquals(driver.findElements(By.tagName("p")).get(1).getText(), "Sometimes you'll see a typo, other times you won't.");
            driver.navigate().refresh();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}
