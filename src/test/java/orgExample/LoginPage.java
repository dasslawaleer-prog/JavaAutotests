package orgExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginMistake = By.cssSelector("h3[data-test='error']");
    private By titleText = By.className("title");
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public InventoryPage login(String username, String password){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(titleText),
                ExpectedConditions.visibilityOfElementLocated(loginMistake)));
        return  new InventoryPage(driver);
    }
//    public String getTextFromMistake (){
//        return driver.findElement(loginMistake).getText();
//    }
}
