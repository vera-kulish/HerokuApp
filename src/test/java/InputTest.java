import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputTest extends BaseTest {

    @Test
    public void input() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("1234567890");
        Assert.assertEquals(input.getAttribute("value"), "1234567890");

        input.clear();
        input.sendKeys("asdfghjkl!@#$%^&*()_}{:\":>?><");
        Assert.assertEquals(input.getAttribute("value"), "");

        input.clear();
        input.sendKeys("1");
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "2");

        input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(input.getAttribute("value"), "1");
    }
}
