import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IFrameTest extends BaseTest {

    @Test
    public void iFrame() {
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[text()='iFrame']")).click();
        driver.switchTo().frame("mce_0_ifr");
        assertEquals(driver.findElement(By.xpath("//p")).getText(), "Your content goes here.");
    }
}
