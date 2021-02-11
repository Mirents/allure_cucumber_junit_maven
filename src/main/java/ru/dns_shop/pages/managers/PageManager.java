package ru.dns_shop.pages.managers;

import ru.dns_shop.pages.HomePage;
import ru.dns_shop.pages.SearchResultPage;

public class PageManager {
    private static PageManager pageManager;
    
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    
    private PageManager() {
    }
    
    public static PageManager getManager() {
        if(pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }
    
    public HomePage getHomePage() {
        if(homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    
    public SearchResultPage getSearchResultPage() {
        if(searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }
        return searchResultPage;
    }
}
