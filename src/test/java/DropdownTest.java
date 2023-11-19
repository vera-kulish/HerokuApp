import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest extends BaseTest {

    @Test
    public void dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> options = select.getOptions();

        Assert.assertEquals(options.get(0).getText(), "Please select an option");
        Assert.assertEquals(options.get(1).getText(), "Option 1");
        Assert.assertEquals(options.get(2).getText(), "Option 2");

        select.selectByVisibleText("Option 1");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        select.selectByVisibleText("Option 2");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }
}
