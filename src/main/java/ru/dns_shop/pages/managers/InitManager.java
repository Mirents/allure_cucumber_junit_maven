package ru.dns_shop.pages.managers;

import java.util.concurrent.TimeUnit;
import static ru.dns_shop.pages.managers.DriverManager.*;
import static ru.dns_shop.pages.utils.ProperitesConstant.*;

/**
 * Класс установки начальных параметров.
 * @author vadim
 */
public class InitManager {
    private static final PropertiesManager propertiesManager = 
            PropertiesManager.getPropertiesManager();
    
    public static void initFramework() {
        getDriver().manage().timeouts().implicitlyWait(
                Integer.parseInt(propertiesManager.getProperty(IMPLICITY_WAIT)),
                TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(
                Integer.parseInt(propertiesManager.getProperty(PAGE_LOAD_TIMEOUT)),
                TimeUnit.SECONDS);
        if(propertiesManager.getProperty(MAXIMIZE_WINDOW).equals("yes"))
            getDriver().manage().window().maximize();
        getDriver().get(propertiesManager.getProperty(APP_URL));
    }
    
    public static void quitFramework() {
        quitDriver();
    }
}
