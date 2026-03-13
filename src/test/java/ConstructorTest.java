import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseUiTest{

    // Тест, проверяющий переход к разделу "Булки" на главной странице
    @Test
    @DisplayName("Переход к разделу \"Булки\"")
    @Description("Проверяем, что при нажатии на вкладку \"Булки\" появляется раздел \"Булки\"")
    public void clickBunsSectionLinkOnHomepageAndNavigateTest() {

        // Открыть сайт
        mainPage.openPage();

        // В стартовом состоянии вкладка "Булки" уже активна, поэтому для тестирования этого сценария необходимо нажать на другую вкладку, например "Соусы"
        mainPage.clickSauceTab();

        // Нажать на вкладку "Булки"
        mainPage.clickBunsTab();

        // Проверяем, что вкладка "Булки" стала активной (под вкладкой отображается синяя полоса)
        assertTrue("Вкладка \"Булки\" не активна", mainPage.isDisplayedActiveBunsTab());
    }

    // Тест, проверяющий переход к разделу "Соусы" на главной странице
    @Test
    @DisplayName("Переход к разделу \"Соусы\"")
    @Description("Проверяем, что при нажатии на вкладку \"Соусы\" появляется раздел \"Соусы\"")
    public void clickSauceSectionLinkOnHomepageAndNavigateTest() {

        // Открыть сайт
        mainPage.openPage();

        // Нажать на вкладку "Соусы"
        mainPage.clickSauceTab();

        // Проверяем, что вкладка "Соусы" стала активной (под вкладкой отображается синяя полоса)
        assertTrue("Вкладка \"Соусы\" не активна", mainPage.isDisplayedActiveSauceTab());
    }

    // Тест, проверяющий переход к разделу "Начинки" на главной странице
    @Test
    @DisplayName("Переход к разделу \"Начинки\"")
    @Description("Проверяем, что при нажатии на вкладку \"Начинки\" появляется раздел \"Начинки\"")
    public void clickToppingsSectionLinkOnHomepageAndNavigateTest() {

        // Открыть сайт
        mainPage.openPage();

        // Нажать на вкладку "Начинки"
        mainPage.clickToppingsTab();

        // Проверяем, что вкладка "Начинки" стала активной (под вкладкой отображается синяя полоса)
        assertTrue("Вкладка \"Начинки\" не активна", mainPage.isDisplayedActiveToppingsTab());
    }
}
