import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.UserCreate;
import model.UserLogin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.UserSteps;

import static data.TestData.*;
import static org.junit.Assert.assertTrue;

public class RegistrationUserTest extends BaseUiTest {

    UserCreate userCreate;
    UserSteps userSteps;
    UserLogin userLogin;
    String email;
    String password;
    String name;

    @Before
    public void createTestUser() {
        userCreate = new UserCreate(EMAIL, PASSWORD, NAME);
        userLogin = new UserLogin(EMAIL, PASSWORD);
        userSteps = new UserSteps();
        email = userCreate.getEmail();
        password = userCreate.getPassword();
        name = userCreate.getName();
    }

    // Тест, проверяющий регистрацию пользователя
    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверяем, что пользователь может зарегистрироваться")
    public void successRegistrationUserTest() {

        // Открыть сайт
        mainPage.openPage();

        // Нажать на кнопку "Личный кабинет" вверху страницы
        mainPage.clickPersonalAccountButton();

        // Нажать на кнопку "Зарегистрироваться" на странице "Вход"
        loginPage.clickRegisterButton();

        // Шаг, который заполняет поля имя, email и пароль на странице "Регистрация" и нажимает кнопку "Зарегистрироваться"
        registrationPageSteps.registrationUserSteps(name, email, password, registrationPage);

        // Проверяем, что мы перешли на страницу вход (кнопка "Войти" видима)
        assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    // Тест, проверяющий ошибку для некорректного пароля
    @Test
    @DisplayName("Ошибка валидации поля ввода пароля")
    @Description("Проверяем, что появляется ошибка валидации поля ввода пароля, если передать пароль менее 7 символов")
    public void errorIncorrectPasswordTest() {

        // Открыть сайт
        mainPage.openPage();

        // Нажать на кнопку "Личный кабинет" вверху страницы
        mainPage.clickPersonalAccountButton();

        // Нажать на кнопку "Зарегистрироваться" на странице "Вход"
        loginPage.clickRegisterButton();

        // Шаг, который заполняет поля имя, email и пароль (специально с ошибкой - менее 7 символов) на странице "Регистрация" и нажимает кнопку "Зарегистрироваться"
        registrationPageSteps.registrationUserSteps(name, email, password.substring(0,4), registrationPage);

        // Проверяем, что появилось сообщение "Некорректный пароль"
        assertTrue(registrationPage.getErrorMessageIncorrectPassword().isDisplayed());
    }

    // После каждого теста удаляем созданного пользователя
    @After
    public void cleanUser(){
        userSteps.cleanUp(userLogin, email);
    }
}
