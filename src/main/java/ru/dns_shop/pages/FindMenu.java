package ru.dns_shop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns_shop.pages.base.BasePage;

/**
 * Класс главной страницы сайта
 * @author vadim
 */
public class FindMenu extends BasePage {
    
    @FindBy(xpath = "//input[contains(@placeholder, 'Поиск по сайту')]")
    WebElement inputFind;
    
    @FindBy(xpath = "//input[contains(@placeholder, 'Поиск по сайту')]/.."
            + "//span[contains(@class, '_icon_search ui-input-search__icon_presearch')]")
    WebElement buttonFind;
    
    public FindMenu inputTextToFind(String text) {
        print("Ввод текста в поле поиска: " + text, "+++");
        try {
            inputFind.sendKeys(text);
        } catch (Exception e) {
        System.out.println("Ошибка поля ввода");}
        
        return apptest.getFindMenu();
    }
    
    public SearchResultPage clickButtonFind() {
        print("Нажатие на кнопку поиска", "+++");
        try {
            buttonFind.click();
        } catch (Exception e) {
            System.out.println("Ошибка кнопки поиска");
        }
        
        return apptest.getSearchResultPage();
    }
}
