import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControls() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        assertFalse(driver.findElement(By.xpath("//form[@id='input-example']/input")).isEnabled());

        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("message"))));
        assertTrue(driver.findElement(By.xpath("//form[@id='input-example']/input")).isEnabled());
    }
}
