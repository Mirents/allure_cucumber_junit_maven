package ru.dns_shop.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.dns_shop.pages.base.BasePage;
import static ru.dns_shop.pages.utils.WarrantyEnum.WARRANTY_ONE_YEAR;
import ru.dns_shop.test.base.BaseTest;

@DisplayName("Simple Test to get Youth Card")
public class SimpleTest extends BaseTest {
    
    /**
     * Простой линейный тест для проверки заполнения полей при оформлении
     * молодежной карты
     * @author vadim
     */
    //@Disabled("Пока находится в разработке, отключен по ненадобности")
    @Test
    public void SimpleGetYouthCardTest() {
        // открыть сайт
        apptest
                // В главном меню в поиске ввести "playstation" и нажать поиск
                .getTopMenu()
                .getFindMenu()
                .inputTextToFind("playstation")
                .clickButtonFind()
                // Перейти к странице товара "Игровая консоль PlayStation 4 Slim Black 1 TB"
                .checkToProductPage("Игровая консоль PlayStation 4 Slim Black 1 TB")
                // Запомнить цену
                .savePrice("Игровая консоль PlayStation 4 Slim Black 1 TB")
                // Доп.гарантия - выбрать 2 года
                .choiseToWarranty(WARRANTY_ONE_YEAR)
                // Дождаться изменения цены и запомнить цену с гарантией
                .savePriceToWarranty("Игровая консоль PlayStation 4 Slim Black 1 TB", WARRANTY_ONE_YEAR)
                // Нажать кнопку купить
                .clickButtonBy()
                // В главном меню в поиске ввести "Detroit"
                .getTopMenu()
                .getFindMenu()
                .inputTextToFind("Detroit")
                // В главном меню в поиске ввести "Detroit" и нажать поиск
                .clickButtonFind()
                // Перейти к странице товара "Игра Detroit: Стать человеком"
                .checkToProductPage("Игра Detroit: Стать человеком")
                // Запомнить цену
                .savePrice("Игра Detroit: Стать человеком")
                // Нажать кнопку купить
                .clickButtonBy()
                // В главном меню проверить что цена равна добавленным товарам
                .getTopMenu()
                .isEqualShoppingListAndCartPrice()
                // В главном меню перейти к корзине
                .getTopMenu()
                .getCardPage()
                // Проверить соответствие гарантии
                .checkWarranty("Игровая консоль PlayStation 4 Slim Black 1 TB", WARRANTY_ONE_YEAR);
    }

    /**
     * Тест, аналогичный первому, только запуском с тремя наборами параметров
     */
    @Disabled("Пока находится в разработке, отключен по ненадобности")
    //@ParameterizedTest(name = "Тест data = {0}, {1}")
    //@CsvSource({"0,0", "0,12","0,24", "12,0","12,12", "12,24","24,0", "24,12", "24,24"})
    public void ParameterizedGetYouthCardTest(int setWarranty, int getWarranty) {
        apptest
                .getTopMenu()
                .getFindMenu()
                .inputTextToFind("playstation")
                .clickButtonFind()
                .checkToProductPage("Игровая консоль PlayStation 4 Slim Black 1 TB")
                //.savePrice("Игровая консоль PlayStation 4 - 1")
                .choiseToWarranty(WARRANTY_ONE_YEAR)
                .savePriceToWarranty("Игровая консоль PlayStation 4 Slim Black 1 TB", WARRANTY_ONE_YEAR)
                .clickButtonBy()
                .getTopMenu()
                .getFindMenu()
                .inputTextToFind("Detroit")
                .clickButtonFind()
                .checkToProductPage("Игра Detroit: Стать человеком")
                .savePrice("Игра Detroit: Стать человеком")
                .clickButtonBy()
                .getTopMenu()
                .isEqualShoppingListAndCartPrice()
                .getTopMenu()
                .getCardPage()
                .checkWarranty("Игровая консоль PlayStation 4 Slim Black 1 TB", WARRANTY_ONE_YEAR);
    }
}