import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));

        Assert.assertFalse(checkboxes.get(0).isSelected());
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected());

        Assert.assertTrue(checkboxes.get(1).isSelected());
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected());
    }
}
