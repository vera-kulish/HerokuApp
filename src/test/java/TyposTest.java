import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest extends BaseTest {

    @Test
    public void typos() {
        driver.get("https://the-internet.herokuapp.com/typos");
        for(int i = 0; i < 5; i++) {
            Assert.assertEquals(driver.findElements(By.tagName("p")).get(1).getText(), "Sometimes you'll see a typo, other times you won't.");
            driver.navigate().refresh();
        }
    }
}
