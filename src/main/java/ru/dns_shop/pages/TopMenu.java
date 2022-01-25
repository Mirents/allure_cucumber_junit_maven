package ru.dns_shop.pages;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.dns_shop.pages.base.BasePage;
import ru.dns_shop.pages.managers.WaitManager;
import ru.dns_shop.pages.utils.Product;

/**
 * Класс главной страницы сайта
 * @author vadim
 */
@Slf4j
public class TopMenu extends BasePage {
    
    //a[contains(@class, 'cart-link')]
    @FindBy(xpath = "//span[contains(@class, 'cart-link__price')]")
    WebElement cartLink;
    
    @FindBy(xpath = "//span[contains(@class, 'cart-link__badge')]")
    WebElement cartLinkNumItem;
    
    @FindBy(xpath = "//a[contains(@class,'btn') and text()='Да']")
    WebElement cityConfirmButton;
    
    public FindMenu getFindMenu() {
        return apptest.getFindMenu();
    }

    public TopMenu isEqualShoppingListAndCartPrice() {
        log.debug("Проверка соотвествия цены в корзине и в списке");
        
        float priceShoppingList = Product.getPriceShoppingList();
        // Ожидание изменения цены в верхнем меню у значка "Корзина"
        WaitManager.getWait().until(ExpectedConditions
                    .textToBePresentInElement(cartLinkNumItem,
                            String.valueOf(Product.getProductList().size())));
        int cartPrice = Integer.parseInt(cartLink.getText().replaceAll("[\\D]", ""));
        // Проверка соответстви цены в корзине и в списке товаров
        log.debug("В корзине {}; в списке {}", priceShoppingList, cartPrice);
        Assertions.assertEquals(cartPrice, priceShoppingList);
        
        return apptest.getTopMenu();
    }
    
    public CartPage getCardPage() {
        cartLink.click();
        return apptest.getCartPage();
    }
    
    public TopMenu confirmToThisCity() {
        cityConfirmButton.click();
        return apptest.getTopMenu();
    }
}
