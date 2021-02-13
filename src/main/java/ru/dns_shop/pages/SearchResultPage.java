package ru.dns_shop.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns_shop.pages.base.BasePage;

/**
 * Класс страницы с результатами поиска
 * @author vadim
 */
public class SearchResultPage extends BasePage {
    
    @FindBy(xpath = "//div[contains(@class, 'products-list__content')]")
    List<WebElement> productList;
    
    public void findInList(String name) {
        for(WebElement e: productList) {
            System.out.println("::::::: text = " + e.getText() + " / " + e.getTagName());
        }
    }
}
