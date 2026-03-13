package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {

    private WebDriver driver;

    public RestorePasswordPage (WebDriver driver) {
        this.driver = driver;
    }

// Локаторы
    // поле ввода email
    private By emailInputField = By.cssSelector(".text.input__textfield.text_type_main-default");

    // кнопка "Восстановить"
    private By restoreButton = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // кнопка "Войти"
    private By loginButton = By.className("Auth_link__1fOlj");

// Методы
    // Ввести email пользователя
    public void enterEmail(String email) {
    driver.findElement(emailInputField).sendKeys(email);
    }

    // Нажать на кнопку "Восстановить"
    public void clickRestoreButton() {
        driver.findElement(restoreButton).click();
    }

    // Нажать на кнопку "Войти"
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
