package ru.dns_shop.test;

import org.junit.jupiter.api.*;
import static ru.dns_shop.pages.utils.WarrantyEnum.WARRANTY_ONE_YEAR;
import ru.dns_shop.test.base.BaseTest;

@DisplayName("Simple Test to get Youth Card")
public class JUnitTest extends BaseTest {

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
                // В главном меню в поиске ввести "6.1" Смартфон Apple iPhone Xr 64 ГБ белый" и нажать поиск
                .getTopMenu()
                .getFindMenu()
                .inputTextToFind("iphone xr")
                .clickButtonFind()
                // Перейти к странице товара "6.1" Смартфон Apple iPhone Xr 64 ГБ белый"
                .checkToProductPage("6.1\" Смартфон Apple iPhone Xr 64 ГБ белый")
                // Запомнить цену
                .savePrice("6.1\" Смартфон Apple iPhone Xr 64 ГБ белый")
                // Доп.гарантия - выбрать 2 года
                .choiseToWarranty(WARRANTY_ONE_YEAR)
                // Дождаться изменения цены и запомнить цену с гарантией
                .savePriceToWarranty("6.1\" Смартфон Apple iPhone Xr 64 ГБ белый", WARRANTY_ONE_YEAR)
                // Нажать кнопку купить
                .clickButtonBy()
                .getTopMenu()
                .isEqualShoppingListAndCartPrice()
                // В главном меню перейти к корзине
                .getTopMenu()
                .getCardPage()
                // Проверить соответствие гарантии
                .checkWarranty("6.1\" Смартфон Apple iPhone Xr 64 ГБ белый", WARRANTY_ONE_YEAR);
    }
}