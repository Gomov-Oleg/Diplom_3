package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage (WebDriver driver) {
        this.driver = driver;
    }

// Локаторы
    // поле ввода имени
    private By nameInputField = By.xpath("//label[text()='Имя']/following-sibling::input[@name='name']");

    // поле ввода email
    private By emailInputField = By.xpath("//label[text()='Email']/following-sibling::input[@name='name']");

    // поле ввода пароля
    private By passwordInputField = By.cssSelector("input[name='Пароль']");

    // кнопка "Зарегистрироваться"
    private By registerButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // кнопка "Войти"
    private By loginButton = By.className("Auth_link__1fOlj");

    // Сообщение об ошибке "Некорректный пароль"
    private By errorMessageIncorrectPassword = By.className("input__error");

// Методы
    @Step("Вводим имя пользователя на странице регистрации")
    public void enterName(String name) {
    driver.findElement(nameInputField).sendKeys(name);
    }

    @Step("Вводим email пользователя на странице регистрации")
    public void enterEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    @Step("Вводим пароль на странице регистрации")
    public void enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    @Step("Нажимаем на кнопку \"Зарегистрироваться\" на странице регистрации")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажимаем на кнопку \"Войти\" на странице регистрации")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Проверяем, что появилось сообщение \"Некорректный пароль\" на странице регистрации")
    public WebElement getErrorMessageIncorrectPassword(){
        WebElement messageError = driver.findElement(errorMessageIncorrectPassword);
        return messageError;
    }
}