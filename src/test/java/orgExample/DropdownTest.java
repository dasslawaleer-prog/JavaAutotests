package orgExample;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest extends BaseTest{
    By dropDown = By.id("dropdown");
    @Test
            void dropDownTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDown));
        WebElement dropDownElement = driver.findElement(dropDown);
        Select dropdown = new Select(dropDownElement);
        dropdown.selectByVisibleText("Option 2");
        String actualText =dropdown.getFirstSelectedOption().getText();
        assertEquals("Option 2",actualText );
        List<WebElement> options = dropdown.getOptions();
        options.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
    }
}
