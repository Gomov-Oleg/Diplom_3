package page;

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
    private By personalAccountButton = By.xpath("//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");

    // кнопка "Войти в аккаунт"
    private By signInAccountButton = By.xpath("//button[text()=\"Войти в аккаунт\"]");

    // вкладка "Булки"
    private By bunsTab = By.xpath("//span[text()='Булки']");

    // вкладка "Соусы"
    private By sauceTab = By.xpath("//span[text()='Соусы']");

    // вкладка "Начинки"
    private By toppingsTab = By.xpath("//span[text()='Начинки']");

    // активная вкладка "Булки"
    private By activeBunsTab = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[1][@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    // активная вкладка "Соусы"
    private By activeSauceTab = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[2][@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    // активная вкладка "Начинки"
    private By activeToppingsTab = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[3][@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

// Методы
    // Открыть сайт
    public void openPage() {
        driver.get(BASE_URI);
    }

    // Нажать на кнопку "Личный Кабинет"
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    // Нажать на кнопку "Войти в аккаунт"
    public void clickSignInAccountButton() {
        driver.findElement(signInAccountButton).click();
    }

    // Нажать на вкладку "Булки"
    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    // Нажать на вкладку "Соусы"
    public void clickSauceTab() {
        driver.findElement(sauceTab).click();
    }

    // Нажать на вкладку "Начинки"
    public void clickToppingsTab() {
        driver.findElement(toppingsTab).click();
    }

    // Возвращает True или False, в зависимости от того, стала ли активной вкладка "Булки" (появляется синяя полоса под вкладкой)
    public boolean isDisplayedActiveBunsTab(){
        return driver.findElement(activeBunsTab).isDisplayed();
    }

    // Возвращает True или False, в зависимости от того, стала ли активной вкладка "Соусы" (появляется синяя полоса под вкладкой)
    public boolean isDisplayedActiveSauceTab(){
        return driver.findElement(activeSauceTab).isDisplayed();
    }

    // Возвращает True или False, в зависимости от того, стала ли активной вкладка "Начинки" (появляется синяя полоса под вкладкой)
    public boolean isDisplayedActiveToppingsTab(){
        return driver.findElement(activeToppingsTab).isDisplayed();
    }









}
