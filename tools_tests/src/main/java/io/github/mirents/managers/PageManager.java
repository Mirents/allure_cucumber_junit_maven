package io.github.mirents.managers;

import io.github.mirents.pages.HarViewerPage;
import io.github.mirents.pages.base.PageBase;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PageManager {
    private static final Logger LOGGER = LogManager.getLogger(PageManager.class);
    private static PageManager instance;
    private static Map<String, PageBase> mapPages = new HashMap<>();

    public static PageManager getPageManager() {
        if(instance == null) {
            instance = new PageManager();
        }
        return instance;
    }
    
    public HarViewerPage getHarViewerPage() {
        return getPage(HarViewerPage.class);
    }

    private <T extends PageBase> T getPage(Class<? extends PageBase> classPage) {
        if(mapPages.isEmpty() || mapPages.get(classPage.getClass().getName()) == null) {
            if(classPage == HarViewerPage.class)
                mapPages.put(classPage.toString(), new HarViewerPage());
        }
        return (T) mapPages.get(classPage.toString());
    }

    void clearMapPage() {
        mapPages.clear();
    }
}
