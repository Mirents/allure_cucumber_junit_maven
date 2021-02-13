package ru.dns_shop.pages.managers;

import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.OS;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ru.dns_shop.pages.utils.ProperitesConstant.*;

/**
 * Класс работы с драйвером Selenium.
 * @author vadim
 */
public class DriverManager {
    private static WebDriver driver;
    private static DriverManager INSTANCE = null;
    PropertiesManager propertiesManager = PropertiesManager.getPropertiesManager();
    
    private DriverManager() {
        initDriver();
    }
    
    /**
     * Получение INSTANCE драйера.
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        if(driver == null) {
            INSTANCE = new DriverManager();
        }
        return driver;
    }
    
    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
            INSTANCE = null;
        }
    }
    
    private void initDriver() {
        if(OS.isFamilyWindows()) {
            initDriverAnyOsFamily(PATH_DRIVER_CHROME_WINDOWS);
        } else if(OS.isFamilyMac()) {
            initDriverAnyOsFamily(PATH_DRIVER_CHROME_MAC);
        } else if(OS.isFamilyUnix()) {
            initDriverAnyOsFamily(PATH_DRIVER_CHROME_UNIX);
        }
    }
    
    private void initDriverAnyOsFamily(String chrome) {
        switch(propertiesManager.getProperty(TYPE_BROWSER)) {
            case "firefox":
                /*System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                driver = new FirefoxDriver();*/
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", propertiesManager.getProperty(chrome));
                driver = new ChromeDriver();
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                break;
            default:
                Assertions.fail("типа браузера '" + propertiesManager.getProperty(TYPE_BROWSER)
                + "' не существует в фреймворке");
        }
    }
}
