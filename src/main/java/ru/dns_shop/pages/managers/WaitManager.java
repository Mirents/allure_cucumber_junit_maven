package ru.dns_shop.pages.managers;

import org.openqa.selenium.support.ui.WebDriverWait;
import static ru.dns_shop.pages.managers.DriverManager.getDriver;
import static ru.dns_shop.pages.utils.ProperitesConstant.*;

/**
 * Класс ожидания.
 * @author vadim
 */
public class WaitManager {
    private static WebDriverWait wait;
    private static WaitManager INSTANCE = null;
    PropertiesManager propertiesManager = PropertiesManager.getPropertiesManager();
    
    private WaitManager() {
        long sleepInMillis = Integer.parseInt(propertiesManager.getProperty(WAIT_SLEEPINMILLIS));
        if(sleepInMillis == 0) {
            sleepInMillis = 1000;
        }
        long timeoutInSeconds = Integer.parseInt(propertiesManager.getProperty(WAIT_TIMEOUTINSECONDS));
        if(timeoutInSeconds == 0) {
            timeoutInSeconds = 5;
        }
        
        wait = new WebDriverWait(getDriver(), timeoutInSeconds, sleepInMillis);
    }
    
    public static WebDriverWait getWait() {
        if(wait == null) {
            INSTANCE = new WaitManager();
        }
        return wait;
    }
}
