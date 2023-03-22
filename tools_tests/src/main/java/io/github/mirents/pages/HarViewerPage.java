package io.github.mirents.pages;

import io.github.mirents.pages.base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HarViewerPage extends PageBase {
    
    @FindBy(xpath = ".//button[@id='buttonFilters']")
    private WebElement buttonOpenFilterMenu;
        
    public HarViewerPage openFilterMenu() {
        buttonOpenFilterMenu.click();
        return this;
    }
}