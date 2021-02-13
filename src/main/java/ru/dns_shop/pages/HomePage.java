package ru.dns_shop.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.dns_shop.pages.base.BasePage;

/**
 * Класс главной страницы сайта
 * @author vadim
 */
public class HomePage extends BasePage {
    
    @FindBy(xpath = "//input[contains(@placeholder, 'DNS')]")
    WebElement inputFind;
    
    @FindBy(xpath = "//input[contains(@placeholder, 'DNS')]/../div[contains(@class, 'ui-input-search__buttons')]")
    WebElement buttonFind;
    
    @FindBy(xpath = "//div[contains(@class, 'homepage-actual-offers-main__title')]")
    WebElement actuals;

    
    public HomePage inputText() {
        inputFind.sendKeys("playstation\n");
        return apptest.getHomePage();
    }
    
    public SearchResultPage clickButtonFind() {
        buttonFind.click();
        return apptest.getSearchResultPage();
    }
}
