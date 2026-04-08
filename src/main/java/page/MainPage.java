package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.TestData.BASE_URI;

public class MainPage {

    private WebDriver driver;

    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

// Локаторы
    // кнопка "Личный Кабинет"
    private By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");

    // кнопка "Войти в аккаунт"
    private By signInAccountButton = By.xpath("//button[text()=\"Войти в аккаунт\"]");

    // вкладка "Булки"
    private By bunsTab = By.xpath("//span[text()='Булки']");

    // вкладка "Соусы"
    private By sauceTab = By.xpath("//span[text()='Соусы']");

    // вкладка "Начинки"
    private By toppingsTab = By.xpath("//span[text()='Начинки']");

    // активная вкладка "Булки"
    private By activeBunsTab = By.xpath("//span[text()='Булки']/parent::div[contains(@class, 'tab_tab_type_current')]");

    // активная вкладка "Соусы"
    private By activeSauceTab = By.xpath("//span[text()='Соусы']/parent::div[contains(@class, 'tab_tab_type_current')]");

    // активная вкладка "Начинки"
    private By activeToppingsTab = By.xpath("//span[text()='Начинки']/parent::div[contains(@class, 'tab_tab_type_current')]");

// Методы
    @Step("Открываем сайт")
    public void openPage() {
        driver.get(BASE_URI);
    }

    @Step("Нажимаем на кнопку \"Личный кабинет\" на главной странице")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажимаем на кнопку \"Войти в аккаунт\" на главной странице")
    public void clickSignInAccountButton() {
        driver.findElement(signInAccountButton).click();
    }

    @Step("Нажимаем на вкладку \"Булки\" на главной странице")
    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    @Step("Нажимаем на вкладку \"Соусы\" на главной странице")
    public void clickSauceTab() {
        driver.findElement(sauceTab).click();
    }

    @Step("Нажимаем на вкладку \"Начинки\" на главной странице")
    public void clickToppingsTab() {
        driver.findElement(toppingsTab).click();
    }

    @Step("Проверяем, что вкладка \"Булки\" на главной странице стала активной (появилась синяя полоса под вкладкой")
    public boolean isDisplayedActiveBunsTab(){
        return driver.findElement(activeBunsTab).isDisplayed();
    }

    @Step("Проверяем, что вкладка \"Соусы\" на главной странице стала активной (появилась синяя полоса под вкладкой")
    public boolean isDisplayedActiveSauceTab(){
        return driver.findElement(activeSauceTab).isDisplayed();
    }

    @Step("Проверяем, что вкладка \"Начинки\" на главной странице стала активной (появилась синяя полоса под вкладкой")
    public boolean isDisplayedActiveToppingsTab(){
        return driver.findElement(activeToppingsTab).isDisplayed();
    }
}