package io.github.mirents.managers;

import io.github.mirents.pages.utils.ProperitesConstant;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс ожидания.
 * @author vadim
 */
public class WaitManager {
    private static WebDriverWait wait;
    private static WaitManager instance = null;
    PropertiesManager propertiesManager = PropertiesManager.getPropertiesManager();
    
    private WaitManager() {
        long sleepInMillis = Integer.parseInt(propertiesManager.getProperty(ProperitesConstant.WAIT_SLEEPINMILLIS));
        if(sleepInMillis == 0) {
            sleepInMillis = 1000;
        }
        long timeoutInSeconds = Integer.parseInt(propertiesManager.getProperty(ProperitesConstant.WAIT_TIMEOUTINSECONDS));
        if(timeoutInSeconds == 0) {
            timeoutInSeconds = 5;
        }

        wait = new WebDriverWait(DriverManager.getDriver(), timeoutInSeconds, sleepInMillis);
    }
    
    public static WebDriverWait getWaitManager() {
        if(wait == null) {
            instance = new WaitManager();
        }
        return wait;
    }
}
