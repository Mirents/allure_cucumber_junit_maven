package ru.dns_shop.pages.managers;

import ru.dns_shop.pages.HomePage;
import ru.dns_shop.pages.ProductPage;
import ru.dns_shop.pages.SearchResultPage;

/**
 * Класс работы со страницами проекта. Каждая создается в еденичном экземпляре.
 * @author vadim
 */
public class PageManager {
    private static PageManager pageManager;
    /*
    Список страниц тестируемого сайта
    */
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ProductPage productPage;
    
    /*private PageManager() {
    }*/
    
    public static PageManager getManager() {
        System.out.println("->PageManager:getManager");
        if(pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }
    
    public HomePage getHomePage() {
        System.out.println("->PageManager:getHomePage");
        if(homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    
    public SearchResultPage getSearchResultPage() {
        System.out.println("->PageManager:getSearchResultPage");
        if(searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }
        return searchResultPage;
    }
    
    public ProductPage getProductPage() {
        System.out.println("->PageManager:getProductPage");
        if(productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }
}
