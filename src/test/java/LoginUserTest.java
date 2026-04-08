import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.UserCreate;
import model.UserLogin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.UserSteps;

import static data.TestData.*;
import static org.junit.Assert.assertEquals;
import static steps.UserSteps.createNewUser;

public class LoginUserTest extends BaseUiTest{

    UserCreate userCreate;
    UserLogin userLogin;
    UserSteps userSteps;
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

        // Создаём тестового пользователя
        createNewUser(userCreate);
    }

    // Тест, проверяющий вход по кнопке "Войти в аккаунт" на главной странице
    @Test
    @DisplayName("Вход по кнопке \"Войти в аккаунт\" на главной странице")
    @Description("Проверяем, что пользователь может авторизоваться через кнопку \"Войти в аккаунт\" на главной странице")
    public void clickLoginButtonOnHomepageAndAuthenticateTest() {

        // Открыть сайт
        mainPage.openPage();

        // Нажать на кнопку "Войти в аккаунт"
        mainPage.clickSignInAccountButton();

        // Шаг, который заполняет поля email и пароль на странице "Вход" и нажимает кнопку "Войти"
        loginPageSteps.loginUserSteps(email, password, loginPage);

        // Нажать на кнопку "Личный Кабинет" вверху страницы
        mainPage.clickPersonalAccountButton();

        // Проверяем, что мы перешли в "Личный кабинет" (в поле "Логин" отображается email, который использовали при регистрации)
        assertEquals("Email, введённый при регистрации не отображается", personalAccountPage.getLoginField(), email);
    }

    // Тест, проверяющий вход через кнопку "Личный кабинет"
    @Test
    @DisplayName("Вход по кнопке \"Личный кабинет\" на главной странице")
    @Description("Проверяем, что пользователь может авторизоваться через кнопку \"Личный кабинет\" на главной странице")
    public void clickPersonalAccountButtonAndAuthenticateTest() {

        // Открыть сайт
        mainPage.openPage();

        // Нажать на кнопку "Личный Кабинет" вверху страницы
        mainPage.clickPersonalAccountButton();

        // Шаг, который заполняет поля email и пароль на странице "Вход" и нажимает кнопку "Войти"
        loginPageSteps.loginUserSteps(email, password, loginPage);

        // Нажать на кнопку "Личный Кабинет" вверху страницы
        mainPage.clickPersonalAccountButton();

        // Проверяем, что мы перешли в "Личный кабинет" (в поле "Логин" отображается email, который использовали при регистрации)
        assertEquals("Email, введённый при регистрации не отображается", personalAccountPage.getLoginField(), email);
    }

    // Тест, проверяющий вход через кнопку в форме регистрации
    @Test
    @DisplayName("Вход по кнопке \"Войти\" в форме регистрации")
    @Description("Проверяем, что пользователь может авторизоваться через кнопку \"Войти\" в форме регистрации")
    public void clickLoginButtonInRegistrationFormAndAuthenticateTest() {

        // Открыть сайт
        mainPage.openPage();

        // Нажать на кнопку "Личный Кабинет" вверху страницы
        mainPage.clickPersonalAccountButton();

        // Нажать на кнопку "Зарегистрироваться" на странице "Вход"
        loginPage.clickRegisterButton();

        // Нажать на кнопку "Войти"
        registrationPage.clickLoginButton();

        // Шаг, который заполняет поля email и пароль на странице "Вход" и нажимает кнопку "Войти"
        loginPageSteps.loginUserSteps(email, password, loginPage);

        // Нажать на кнопку "Личный Кабинет" вверху страницы
        mainPage.clickPersonalAccountButton();

        // Проверяем, что мы перешли в "Личный кабинет" (в поле "Логин" отображается email, который использовали при регистрации)
        assertEquals("Email, введённый при регистрации не отображается", personalAccountPage.getLoginField(), email);
    }

    // Тест, проверяющий вход через кнопку в форме восстановления пароля
    @Test
    @DisplayName("Вход по кнопке \"Войти\" в форме восстановления пароля")
    @Description("Проверяем, что пользователь может авторизоваться через кнопку \"Войти\" в форме восстановления пароля")
    public void clickLoginButtonInPasswordRecoveryFormAndAuthenticateTest() {

        // Открыть сайт
        mainPage.openPage();

        // Нажать на кнопку "Личный Кабинет" вверху страницы
        mainPage.clickPersonalAccountButton();

        // Нажать на кнопку "Восстановить пароль"
        loginPage.clickRestorePasswordButton();

        // Нажать на кнопку "Войти" в форме восстановления пароля
        restorePasswordPage.clickLoginButton();

        // Шаг, который заполняет поля email и пароль на странице "Вход" и нажимает кнопку "Войти"
        loginPageSteps.loginUserSteps(email, password, loginPage);

        // Нажать на кнопку "Личный Кабинет" вверху страницы
        mainPage.clickPersonalAccountButton();

        // Проверяем, что мы перешли в "Личный кабинет" (в поле "Логин" отображается email, который использовали при регистрации)
        assertEquals("Email, введённый при регистрации не отображается", personalAccountPage.getLoginField(), email);
    }

// После каждого теста удаляем созданного пользователя
    @After
    public void cleanUser(){
        userSteps.cleanUp(userLogin, email);
    }
    }