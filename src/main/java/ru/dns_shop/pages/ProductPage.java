package ru.dns_shop.pages;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.dns_shop.pages.base.BasePage;
import ru.dns_shop.pages.managers.*;
import static ru.dns_shop.pages.managers.DriverManager.getDriver;
import ru.dns_shop.pages.utils.Product;
import ru.dns_shop.pages.utils.WarrantyEnum;

/**
 * Класс карточки продукта.
 * @author vadim
 */
public class ProductPage extends BasePage {
    
    @FindBy(xpath = "//select[contains(@class, 'select')]//option")
    private List<WebElement> selectWarnary;
    
    @FindBy(xpath = "//span[contains(@class, 'product-card-price__current')]")
    private WebElement thisPrice;
    
    @FindBy(xpath = "//button[contains(@class, 'buy-btn')]")
    private WebElement buttonBy;
    
    /**
     * Метод выбора гарантии на странице товара.
     * Значения:
     * * '0' - без гарантии;
     * * '1' - гарантия 1 год;
     * * '2' - гарантия 2 года;
     * @param selectElem
     * @return 
     */
    public ProductPage choiseToWarranty(WarrantyEnum warranty) {
        print("Выбор гарантии, параметр: " + warranty.geWarranty(), "+++");
        String warrantyText = "";
        switch(warranty) {
            case WARRANTY_NO :
                warrantyText = "default";
                break;
            case WARRANTY_ONE_YEAR :
                warrantyText = "0";
                break;
            case WARRANTY_TWO_YEAR :
                warrantyText = "1";
                break;
        }
        // В это месте происходит первая крупная задержка
        // Время задержки равно параметру "implicity.wait"
        String maskSelectElement = ".//option[@value='%s']";
        String selectElementXPath = String.format(maskSelectElement, warrantyText);
        WebElement selectElement = getDriver().findElement(By.xpath(selectElementXPath));
        print("Перед кликом по гарантии", "+++");
        selectElement.click();
        print("После клика по гарантии", "+++");
        
        return apptest.getProductPage();
    }

    public ProductPage savePrice(String name) {
        print("Сохранение цены: " + name, "+++");
        Product.saveProduct(name, getPrice());
        //shoppingList.put(text, getPrice());
        return apptest.getProductPage();
    }

    public ProductPage savePriceToWarranty(String name, WarrantyEnum warranty) {
        print("Сохранение цены с гарантией: " + name, "+++");
        waitChangePriceToProduct();
        //shoppingList.put(text, getPrice());
        Product.saveProduct(name, warranty, getPrice());
        return apptest.getProductPage();
    }

    private int getPrice() {
        print("Парсинг цены", "+++");
        return Integer.parseInt(thisPrice.getText().replaceAll("[\\D]", ""));
    }

    private void waitChangePriceToProduct() {
        print("Ожидание изменения цены на карточке товара", "+++");
        // В том случае, если значение выпадающего списка остается по умолчанию
        // и не происходит изменения цены - срабатывает исключение и оно
        // игнорируется
        try {
            WaitManager.getWait().until(ExpectedConditions.
                attributeContains(thisPrice, "class", "active"));
        } catch(TimeoutException ignore) {}
    }
    
    public ProductPage clickButtonBy() {
        print("Нажатие кнопки купить", "+++");
        WaitManager.getWait().until(ExpectedConditions.elementToBeClickable(buttonBy));
        buttonBy.click();
        
        return apptest.getProductPage();
    }
}
