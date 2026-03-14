package page;

import io.qameta.allure.Step;
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
    @Step("Вводим email пользователя на странице восстановления пароля")
    public void enterEmail(String email) {
    driver.findElement(emailInputField).sendKeys(email);
    }

    @Step("Нажимаем на кнопку \"Восстановить\" на странице восстановления пароля")
    public void clickRestoreButton() {
        driver.findElement(restoreButton).click();
    }

    @Step("Нажимаем на кнопку \"Войти\" на странице восстановления пароля")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}