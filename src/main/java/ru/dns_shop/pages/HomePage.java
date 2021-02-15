package ru.dns_shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns_shop.pages.base.BasePage;

/**
 * Класс главной страницы сайта
 * @author vadim
 */
public class HomePage extends BasePage {
    
    @FindBy(xpath = "//input[contains(@placeholder, 'Поиск по сайту')]")
    WebElement inputFind;
    
    @FindBy(xpath = "//input[contains(@placeholder, 'Поиск по сайту')]/.."
            + "//span[contains(@class, '_icon_search ui-input-search__icon_presearch')]")
    WebElement buttonFind;
    
    public HomePage inputText(String text) {
        try {
            inputFind.sendKeys(text);
        } catch (Exception e) {
        System.out.println("Ошибка поле ввода");}
        
        return apptest.getHomePage();
    }
    
    public SearchResultPage clickButtonFind() {
        try {
            buttonFind.click();
        } catch (Exception e) {
            System.out.println("Ошибка кнопка поиска");
        }
        
        return apptest.getSearchResultPage();
    }
}
