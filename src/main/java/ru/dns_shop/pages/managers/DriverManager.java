package ru.dns_shop.pages.managers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.OS;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
    
    private void initDriverAnyOsFamily(String browser) {
        ChromeOptions options = new ChromeOptions();
        switch(propertiesManager.getProperty(TYPE_BROWSER)) {
            case "firefox":
                /*System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                driver = new FirefoxDriver();*/
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", propertiesManager.getProperty(browser));
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "remote":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "88.0");
                Map<String, Object> m = new HashMap<>();
                m.put("enableVNC", true);
                m.put("enableVideo", false);
                capabilities.setCapability("selenoid:options", m);
                try {
                    driver = new RemoteWebDriver(
                        URI.create("http://192.168.56.101:4444/wd/hub").toURL(), 
                        capabilities
                    );
                } catch (MalformedURLException e) {
                    Assertions.fail("Для браузера '" + propertiesManager.getProperty(TYPE_BROWSER)
                + "' возникла проблема запуска");
                }
                break;
            case "headless":
                //System.setProperty("webdriver.chrome.driver", propertiesManager.getProperty(browser));
                options.addArguments("--headless");
                options.addArguments("window-size=1200x600");
                driver = new ChromeDriver(options);
                break;
            default:
                Assertions.fail("Типа браузера '" + propertiesManager.getProperty(TYPE_BROWSER)
                + "' не существует в фреймворке");
        }
    }
    
    private ChromeOptions getChromeOptions() {
        ChromeOptions result = new ChromeOptions();
        if(propertiesManager.getProperty(CHROME_MAXIMIZE_WINDOW).equals("on")) {
            result.addArguments("start-maximized");
        }
        if(propertiesManager.getProperty(CHROME_DISABLE_NOTIFICATIONS).equals("on")) {
            result.addArguments("disable-notifications");
        }
        if(propertiesManager.getProperty(CHROME_DISABLE_INFOBARS).equals("on")) {
            result.addArguments("disable-infobars");
        }
        if(propertiesManager.getProperty(CHROME_DISABLE_POPUP_BLOCKING).equals("on")) {
            result.addArguments("disable-popup-blocking");
        }
        if(propertiesManager.getProperty(CHROME_INCOGNITO).equals("on")) {
            result.addArguments("incognito");
        }
        return result;
    }
}
