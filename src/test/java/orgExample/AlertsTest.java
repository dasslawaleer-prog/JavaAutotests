package orgExample;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Создай класс AlertsTest extends BaseTest.
Открой сайт https://the-internet.herokuapp.com/javascript_alerts.
Кликни по кнопке Click for JS Alert.
Переключись на алерт, проверь (assertEquals), что его текст равен "I am a JS Alert".
Нажми ОК (accept).
Проверь, что на странице появился результат "You successfully clicked an alert".

 */
public class AlertsTest extends BaseTest {
    By findAllert = By.xpath("//button[text()='Click for JS Alert']");

    @Test
    void alertsTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        wait.until(ExpectedConditions.visibilityOfElementLocated(findAllert));
        driver.findElement(findAllert).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("I am a JS Alert", alertText);
        alert.accept();
        String succText = driver.findElement(By.id("result")).getText();
        assertEquals("You successfully clicked an alert", succText);
    }
    /*
    Задача 2. JavaScript Prompt (со звёздочкой)
На том же сайте.
Кликни по кнопке Click for JS Prompt.
Переключись на алерт, введи туда текст "Слава" (sendKeys).
Нажми ОК (accept).
Проверь, что на странице появился результат "You entered: Слава"
     */
    By promptPath = By.xpath("//button[text()='Click for JS Prompt']");
    @Test
    void prompt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        wait.until(ExpectedConditions.visibilityOfElementLocated(promptPath));
        driver.findElement(promptPath).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Slava");
        alert.accept();
        String succText= driver.findElement(By.id("result")).getText();
        assertEquals("You entered: Slava",succText);
    }
}
