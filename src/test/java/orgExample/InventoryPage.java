package orgExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
Задача 1. Создай класс InventoryPage
Он должен содержать:
Приватное поле WebDriver driver.
Конструктор, принимающий driver.
Локаторы (через By):
Заголовок страницы (className("title")).
Кнопка добавления рюкзака (cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).
Счетчик корзины (className("shopping_cart_badge")).
Методы:
getTitleText() — возвращает текст заголовка.
addBackpackToCart() — кликает по кнопке.
getCartCount() — возвращает текст счетчика (число).
 */
public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    WebDriverWait wait;
    private By title = By.className("title");
    private By addBackpage = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private By itemCount = By.className("shopping_cart_badge");
    private By loginMistake = By.cssSelector("h3[data-test='error']");

    public String getTitleText() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return driver.findElement(title).getText();
    }

    public InventoryPage addBackpackToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addBackpage));
        driver.findElement(addBackpage).click();
        return this;
    }

    public String getCartCount() {
        wait.until(ExpectedCondi)
        return driver.findElement(itemCount).getText();
    }

    public String getTextFromMistake() {
        return driver.findElement(loginMistake).getText();
    }
}
