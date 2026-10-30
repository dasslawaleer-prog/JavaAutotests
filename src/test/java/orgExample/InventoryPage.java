package orgExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public InventoryPage(WebDriver driver){
        this.driver=driver;
    }
    private By title = By.className("title");
    private By addBackpage = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private By itemCount = By.className("shopping_cart_badge");

    public String getTitleText(){
       return driver.findElement(title).getText();
    }
    public void addBackpackToCart(){
        driver.findElement(addBackpage).click();
    }
    public String getCartCount(){
        return driver.findElement(itemCount).getText();
    }

}
