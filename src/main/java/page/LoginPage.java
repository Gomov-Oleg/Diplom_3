package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

// Локаторы
    // кнопка "Зарегистрироваться"
    private By registerButton = By.cssSelector("a.Auth_link__1fOlj[href='/register']");

    // поле ввода email
    private By emailInputField = By.cssSelector("input.input__textfield[name=\"name\"]");

    // поле ввода пароля
    private By passwordInputField = By.cssSelector("input.input__textfield[name=\"Пароль\"]");

    // кнопка "Войти"
    private By loginButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // кнопка "Восстановить пароль"
    private By restorePasswordButton = By.cssSelector("a.Auth_link__1fOlj[href='/forgot-password']");

// Методы
    @Step("Нажимаем на кнопку \"Зарегистрироваться\" на странице авторизации")
    public void clickRegisterButton() {
    driver.findElement(registerButton).click();
}

    @Step("Вводим email пользователя на странице авторизации")
    public void enterEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    @Step("Вводим пароль на странице авторизации")
    public void enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    @Step("Нажимаем на кнопку \"Войти\" на странице авторизации")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажимаем на кнопку \"Восстановить пароль\" на странице авторизации")
    public void clickRestorePasswordButton() {
        driver.findElement(restorePasswordButton).click();
    }

    @Step("Проверяем, что появилась кнопка \"Войти\" на странице авторизации")
    public WebElement getLoginButton(){
        WebElement visualLoginButton = driver.findElement(loginButton);
        return visualLoginButton;
    }
}