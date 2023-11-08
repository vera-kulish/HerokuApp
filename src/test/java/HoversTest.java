import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoversTest {

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
    public void hovers() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        List<WebElement> avatars = driver.findElements(By.className("figure"));

        action.moveToElement(avatars.get(0)).moveToElement(driver.findElement(By.cssSelector("[href=\"/users/1\"]"))).click().build().perform();
        Assert.assertFalse(driver.getPageSource().contains("Not Found"));
        action.moveToElement(avatars.get(1)).moveToElement(driver.findElement(By.cssSelector("[href=\"/users/2\"]"))).click().build().perform();
        Assert.assertFalse(driver.getPageSource().contains("Not Found"));
        action.moveToElement(avatars.get(2)).moveToElement(driver.findElement(By.cssSelector("[href=\"/users/3\"]"))).click().build().perform();
        Assert.assertFalse(driver.getPageSource().contains("Not Found"));

    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}
