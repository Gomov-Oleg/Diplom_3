package page;

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
    private By emailInputField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    // поле ввода пароля
    private By passwordInputField = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    // кнопка "Войти"
    private By loginButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");

    // кнопка "Восстановить пароль"
    private By restorePasswordButton = By.cssSelector("a.Auth_link__1fOlj[href='/forgot-password']");

// Методы
    // Нажать на кнопку "Зарегистрироваться"
    public void clickRegisterButton() {
    driver.findElement(registerButton).click();
}

    // Ввести email пользователя
    public void enterEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    // Ввести пароль
    public void enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    // Нажать на кнопку "Войти"
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Нажать на кнопку "Восстановить пароль"
    public void clickRestorePasswordButton() {
        driver.findElement(restorePasswordButton).click();
    }

    // Проверить, что появилась кнопка "Войти"
    public WebElement getLoginButton(){
        WebElement visualLoginButton = driver.findElement(loginButton);
        return visualLoginButton;
    }
}
