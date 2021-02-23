package ru.dns_shop.pages.managers;

import ru.dns_shop.pages.CartPage;
import ru.dns_shop.pages.FindMenu;
import ru.dns_shop.pages.ProductPage;
import ru.dns_shop.pages.SearchResultPage;
import ru.dns_shop.pages.TopMenu;

/**
 * Класс работы со страницами проекта. Каждая создается в еденичном экземпляре.
 * @author vadim
 */
public class PageManager {
    private static PageManager pageManager;
    /*
    Список страниц тестируемого сайта
    */
    private TopMenu topMenu;
    private FindMenu findMenu;
    private SearchResultPage searchResultPage;
    private ProductPage productPage;
    private CartPage cardPage;
     
    public static PageManager getManager() {
        if(pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }
    
    public TopMenu getTopMenu() {
        if(topMenu == null) {
            topMenu = new TopMenu();
        }
        return topMenu;
    }
    
    public FindMenu getFindMenu() {
        if(findMenu == null) {
            findMenu = new FindMenu();
        }
        return findMenu;
    }
    
    public SearchResultPage getSearchResultPage() {
        if(searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }
        return searchResultPage;
    }
    
    public ProductPage getProductPage() {
        if(productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }
    
    public CartPage getCartPage() {
        if(cardPage == null) {
            cardPage = new CartPage();
        }
        return cardPage;
    }
}
