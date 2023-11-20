import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortableDataTablesTest extends BaseTest {

    @Test
    public void sortableDataTable() {
        driver.get("https://the-internet.herokuapp.com/tables");
        Assert.assertEquals(driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[1]")).getText(), "Smith");
        Assert.assertEquals(driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[2]")).getText(), "John");
        Assert.assertEquals(driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td[3]")).getText(), "fbach@yahoo.com");
        Assert.assertEquals(driver.findElement(By.xpath("//table[1]/tbody/tr[3]/td[4]")).getText(), "$100.00");
    }
}
