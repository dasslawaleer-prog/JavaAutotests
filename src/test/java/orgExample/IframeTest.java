package orgExample;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Задача 3. Iframe (WYSIWYG редактор)
Создай класс IframeTest extends BaseTest.
Открой сайт https://the-internet.herokuapp.com/iframe.
Это страница с текстовым редактором внутри фрейма.
Найди фрейм и переключись на него (driver.switchTo().frame(0) или по id="mce_0_ifr").
Найди элемент с id="tinymce" (это само поле ввода).
Очисти его (clear()) и введи текст "Мой новый текст".
Переключись обратно на главную страницу (defaultContent()).
Найди заголовок h3 на главной странице и проверь, что он равен "An iFrame containing the TinyMCE WYSIWYG Editor".
 */
public class IframeTest extends BaseTest {

    @Test
    void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        driver.switchTo().frame(0);
        WebElement field = driver.findElement(By.id("tinymce"));
        field.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        field.sendKeys(Keys.DELETE);
        field.sendKeys("My new Text");
        driver.switchTo().defaultContent();
        String headerText=driver.findElement(By.tagName("h3")).getText();
        assertEquals("An iFrame containing the TinyMCE WYSIWYG Editor", headerText);
    }
}
