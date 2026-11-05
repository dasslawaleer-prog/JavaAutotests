package orgExample;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckboxesTest extends BaseTest{
    @Test
    void checkBoxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement checkBox1=checkBoxes.get(0);
        WebElement checkBox2=checkBoxes.get(1);
        assertFalse(checkBox1.isSelected());
        assertTrue(checkBox2.isSelected());
        checkBox1.click();
        assertTrue(checkBox1.isSelected());
    }
}
