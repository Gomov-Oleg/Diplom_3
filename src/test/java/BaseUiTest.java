import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.*;
import steps.LoginPageSteps;
import steps.RegistrationPageSteps;

import java.util.concurrent.TimeUnit;

public class BaseUiTest extends BaseApiTest {

    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    LoginPageSteps loginPageSteps;
    RegistrationPageSteps registrationPageSteps;
    PersonalAccountPage personalAccountPage;
    RestorePasswordPage restorePasswordPage;

    // Открыть браузер
    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome"); //"chrome" - значение по умолчанию
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("yandex")) {
            startBrowserYandex();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Добавляем неявное ожидание
        driver.manage().window().maximize(); // Открыть окно браузера на весь экран

        mainPage = new MainPage(driver);
        registrationPageSteps = new RegistrationPageSteps(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        loginPageSteps = new LoginPageSteps(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
    }

    public void startBrowserYandex() {
        // Указываем путь к YandexDriver (аналог chromedriver)
        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Yandex/yandexdriver.exe");

        // Настраиваем ChromeOptions для Яндекс Браузера
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/Oleg/AppData/Local/Yandex/YandexBrowser/Application/browser.exe"); // путь к бинарнику Яндекс Браузера

        driver = new ChromeDriver(options);
    }
    public void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Закрыть браузер
    @After
    public void tearDown(){
        driver.quit();
    }
}