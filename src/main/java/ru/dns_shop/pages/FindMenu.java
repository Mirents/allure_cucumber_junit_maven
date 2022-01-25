package ru.dns_shop.pages;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns_shop.pages.base.BasePage;

/**
 * Класс главной страницы сайта
 * @author vadim
 */
@Slf4j
public class FindMenu extends BasePage {
    
    @FindBy(xpath = "//input[contains(@placeholder, 'Поиск по сайту') and not(contains(@id,'null'))]")
    WebElement inputFind;
    
    @FindBy(xpath = "//nav[@id='header-search']//span[contains(@class,'icon_search')]")
    WebElement buttonFind;
    
    public FindMenu inputTextToFind(String text) {
        log.debug("Ввод текста в поле поиска: {}", text);
        try {
            inputFind.sendKeys(text);
        } catch (Exception e) {
            Assertions.fail("Ошибка поля ввода", e);
        }
        
        return apptest.getFindMenu();
    }
    
    public SearchResultPage clickButtonFind() {
        log.debug("Нажатие на кнопку поиска");
        try {
            buttonFind.click();
        } catch (Exception e) {
            Assertions.fail("Ошибка кнопки поиска", e);
        }
        
        return apptest.getSearchResultPage();
    }
}
