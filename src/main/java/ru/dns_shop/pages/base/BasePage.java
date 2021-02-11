package ru.dns_shop.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.dns_shop.pages.managers.DriverManager;
import ru.dns_shop.pages.managers.PageManager;
import static ru.dns_shop.pages.managers.DriverManager.getDriver;

public class BasePage {
    protected PageManager apptest = PageManager.getManager();
    //protected Actions action = new Actions(get);
    
    public WebDriverWait wait;
    private String baseUrl = "https://www.dns-shop.ru/";
    
    /**
     * Метод первоначальной настройки драйвера и параметров запуска
     */
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
        wait = new WebDriverWait(getDriver(), 10, 1000);
    }
    
    public void fillInputField(WebElement element, String value) {
        element.sendKeys(value);
    }
    
    public void fillFields(String nameElement, String value) {
        /*switch(nameElement) {
            case "0" :
                fillFields("0", value);
                break;
            default:
                System.out.println("");
        }*/
    }
    
    public void scrollToElement() {
        
    }
}
