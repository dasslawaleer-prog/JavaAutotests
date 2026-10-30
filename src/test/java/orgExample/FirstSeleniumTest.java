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
    WebDriverWait wait;
    @BeforeEach
    void setUp() throws InterruptedException {
        // 1. WebDriverManager сам скачает нужный драйвер для Chrome
        WebDriverManager.chromedriver().setup();

        // 2. Создаем экземпляр браузера
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 3. Открываем сайт
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        InventoryPage inventory = new InventoryPage(driver);
        String actualTitle = inventory.getTitleText();
        assertEquals("Products", actualTitle, "Заголовок не совпадает!");
    }

    //Задача 2
    @Test
    void cartAdd(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        String actualCount = inventory.getCartCount();
        assertEquals("1", actualCount);
    }

    @Test
    void testLoginWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");
        InventoryPage inventory = new InventoryPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
        String actualText = loginPage.getTextFromMistake();
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