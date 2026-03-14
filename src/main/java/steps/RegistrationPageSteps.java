package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import page.RegistrationPage;

public class RegistrationPageSteps {

    WebDriver driver;

    public RegistrationPageSteps (WebDriver driver) {
        this.driver = driver;
    }

    // Шаг, который заполняет поля имя, email и пароль на странице "Регистрация" и нажимает кнопку "Зарегистрироваться"
    @Step("Регистрируемся в системе через UI")
    public void registrationUserSteps(String name, String email, String password, RegistrationPage registrationPage) {
        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickRegisterButton();
        }
}