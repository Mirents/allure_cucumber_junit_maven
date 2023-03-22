package com.dws.managers;

import org.openqa.selenium.support.ui.WebDriverWait;
import static com.dws.managers.DriverManager.getDriver;
import static com.dws.pages.utils.ProperitesConstant.*;

/**
 * Класс ожидания.
 * @author vadim
 */
public class WaitManager {
    private static WebDriverWait wait;
    private static WaitManager instance = null;
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
    
    public static WebDriverWait getWaitManager() {
        if(wait == null) {
            instance = new WaitManager();
        }
        return wait;
    }
}
