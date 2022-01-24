package ru.dns_shop.pages;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns_shop.pages.base.BasePage;
import ru.dns_shop.pages.utils.WarrantyEnum;

/**
 * Класс корзины
 * @author vadim
 */
@Slf4j
public class CartPage extends BasePage {
    
    @FindBy(xpath = "//div[contains(@class, 'cart-items__products')]//div[@class='cart-items__product']")
    List<WebElement> productListToCart;
    
    /**
     * Проверка чекбокса гарантии элемента 'product'
     * Значения 'numMounthWarranty':
     * * '0' - без гарантии;
     * * '1' - гарантия 1 год;
     * * '2' - гарантия 2 года;
     * @param product
     * @param warranty
     * @return 
     */
    public CartPage checkWarranty(String product, WarrantyEnum warranty) {
        productListToCart.forEach(e -> {
            WebElement a = getNameInCartList(e);
            if(a.getText().trim().contains(product)) {
                String warrantyListXpath = ".//div[contains(@class, 'warrant')]"
                        + "//div[contains(@class, 'slider_')]//span[contains(@class, 'radio-button')]";
                List<WebElement> warrantyList = e.findElements(By.xpath(warrantyListXpath));
                warrantyList.forEach(w -> {
                    if(w.getAttribute("class").trim().contains("checked")) {
                        int war = 0;
                        // Если при парсинге страны нет числа - происходит
                        // обработка исключения и присвоение переменной количества
                        // месяцев 0
                        try {
                            war = Integer.parseInt(w.getText().replaceAll("[\\D]", ""));
                        } catch(NumberFormatException ignore) {
                            war = 0;
                        }
                        log.debug("Проверка гарантии: {} - {}", warranty.geWarranty(), war);
                        Assertions.assertEquals(warranty.geWarranty(), war);
                    }
                });
            }
        });
        return apptest.getCartPage();
    }
    
    private WebElement getNameInCartList(WebElement elem) {
        return elem.findElement(By.xpath(".//a[@class='cart-items__product-name-link']"));
    }
}
