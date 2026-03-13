package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalAccountPage {

    private WebDriver driver;

    public PersonalAccountPage (WebDriver driver) {
        this.driver = driver;
    }

// Локаторы
    // поле "Логин"
    private By loginField = By.cssSelector("input[type='text'][name='name']");

// Методы
    // получить значение поля "Логин"
    public String getLoginField() {
            WebElement element = driver.findElement(loginField);
            String actualLoginField = element.getAttribute("value");
            return actualLoginField;
        }
    }




