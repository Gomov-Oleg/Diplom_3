package page;

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
    private By nameInputField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    // поле ввода email
    private By emailInputField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    // поле ввода пароля
    private By passwordInputField = By.cssSelector("input[name='Пароль']");

    // кнопка "Зарегистрироваться"
    private By registerButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // кнопка "Войти"
    private By loginButton = By.className("Auth_link__1fOlj");

    // Сообщение об ошибке "Некорректный пароль"
    private By errorMessageIncorrectPassword = By.className("input__error");

// Методы
    // Ввести имя пользователя
    public void enterName(String name) {
    driver.findElement(nameInputField).sendKeys(name);
    }

    // Ввести email пользователя
    public void enterEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    // Ввести пароль
    public void enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    // Нажать на кнопку "Зарегистрироваться"
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    // Нажать на кнопку "Войти"
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Проверить, что появилось сообщение "Некорректный пароль"
    public WebElement getErrorMessageIncorrectPassword(){
        WebElement messageError = driver.findElement(errorMessageIncorrectPassword);
        return messageError;
    }
}
