package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.LoginPage;

public class LoginPageSteps {

    WebDriver driver;

    public LoginPageSteps (WebDriver driver) {
        this.driver = driver;
    }

    // Шаг, который заполняет поля email и пароль на странице "Вход" и нажимает кнопку "Войти"
    @Step("Авторизуемся в системе через UI")
    public void loginUserSteps(String email, String password, LoginPage loginPage) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}