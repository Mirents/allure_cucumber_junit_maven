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
        System.out.println("->InitManager:initFramework start getDriver().manage().timeouts().implicitlyWait");
        getDriver().manage().timeouts().implicitlyWait(
                Integer.parseInt(propertiesManager.getProperty(IMPLICITY_WAIT)),
                TimeUnit.SECONDS);
        System.out.println("->InitManager:initFramework start getDriver().manage().timeouts().pageLoadTimeout");
        getDriver().manage().timeouts().pageLoadTimeout(
                Integer.parseInt(propertiesManager.getProperty(PAGE_LOAD_TIMEOUT)),
                TimeUnit.SECONDS);
    }
    
    public static void quitFramework() {
        quitDriver();
    }
}
