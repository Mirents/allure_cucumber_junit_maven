package ru.dns_shop.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.dns_shop.pages.base.BasePage;
import ru.dns_shop.pages.managers.*;

/**
 * Класс страницы с результатами поиска
 * @author vadim
 */
public class SearchResultPage extends BasePage {
    
    @FindBy(xpath = "//div[contains(@data-id, 'catalog-item')]")
    private List<WebElement> productList;
    
    public ProductPage clickToProduct(String name) {
        try {
        productList.forEach(e -> {
            WebElement a = getNameInProductList(e);
            if(a.getText().trim().contains(name)) {
                WaitManager.getWait()
                        .until(ExpectedConditions.elementToBeClickable(a));
                a.click();
            }
        });
       } catch(StaleElementReferenceException ignore) {}
        
        return apptest.getProductPage();
    }
    
    private WebElement getNameInProductList(WebElement elem) {
        return elem.findElement(By.xpath(".//a[contains(@data-role, 'clamped-link')]"));
    }
}
