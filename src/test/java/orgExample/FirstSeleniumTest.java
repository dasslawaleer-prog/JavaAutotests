package orgExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        // 1. WebDriverManager сам скачает нужный драйвер для Chrome
        WebDriverManager.chromedriver().setup();

        // 2. Создаем экземпляр браузера
        driver = new ChromeDriver();

        // 3. Открываем сайт
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }

    @Test
    void testLogin() {
//        // 4. Находим поле "Username" по ID и вводим текст
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//
//        // 5. Находим поле "Password" по ID и вводим текст
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//
//        // 6. Находим кнопку "Login" по ID и кликаем
//        driver.findElement(By.id("login-button")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        // 7. Делаем проверку (Assert).
        // Проверяем, что после входа в заголовке страницы появилась надпись "Products"
        String actualTitle = driver.findElement(By.className("title")).getText();
        assertEquals("Products", actualTitle, "Заголовок не совпадает!");
    }

    //Задача 2
    @Test
    void cartAdd(){
        driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
        String actualCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals("1", actualCount);
    }

    /*
    Задача 1. Тест на неверный логин

Создай новый тест-метод testLoginWithWrongPassword.

Введи логин standard_user, а пароль wrong_password.
Нажми кнопку Login.
Проверь (assertEquals), что появилась ошибка с текстом:
"Epic sadface: Username and password do not match any user in this service".
Подсказка: ошибка выводится в элементе с тегом h3 и классом
error-message-container или просто найди по тексту //h3[contains(text(),
'Epic sadface')]. Посмотри в браузере через F12, как устроен элемент.
     */
    @Test
    void testLoginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_userMistace", "secret_sauceMistace");
        String actualText = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        System.out.println(actualText);
        assertEquals("Epic sadface: Username and password do not match any user in this service", actualText,
                "Mistake in mistake");
    }

    @AfterEach
    void tearDown() {
        // 8. Закрываем браузер после каждого теста
        if (driver != null) {
            driver.quit();
        }
    }
}