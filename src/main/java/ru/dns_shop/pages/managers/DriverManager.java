package ru.dns_shop.pages.managers;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.OS;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static ru.dns_shop.pages.utils.ProperitesConstant.*;

/**
 * Класс работы с драйвером Selenium.
 * @author vadim
 */
@Slf4j
public class DriverManager {
    private static WebDriver driver;
    private static DriverManager instance = null;
    private final PropertiesManager propertiesManager = PropertiesManager.getPropertiesManager();
    
    private DriverManager() {
        initDriverS();
    }
    
    /**
     * Получение INSTANCE драйера.
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        if(driver == null) {
            instance = new DriverManager();
        }
        return driver;
    }

    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
            instance = null;
        }
    }
    
    private void initDriverS() {
        if (OS.isFamilyWindows()) {
            initDriverWindowsOsFamily();
        } else if (OS.isFamilyMac()) {
            initDriverMacOsFamily();
        } else if (OS.isFamilyUnix()) {
            initDriverUnixOsFamily();
        }
    }
    
    private void initDriverWindowsOsFamily() {
        initDriverAnyOsFamilyS(PATH_DRIVER_FIREFOX_WINDOWS, PATH_DRIVER_CHROME_WINDOWS);
    }
    
    private void initDriverMacOsFamily() {
        initDriverAnyOsFamilyS(PATH_DRIVER_FIREFOX_MAC, PATH_DRIVER_CHROME_MAC);
    }
    
    private void initDriverUnixOsFamily() {
        initDriverAnyOsFamilyS(PATH_DRIVER_FIREFOX_UNIX, PATH_DRIVER_CHROME_UNIX);
    }
    
    private void initDriverAnyOsFamilyS(String firefox, String chrome) {
        switch(propertiesManager.getProperty(TYPE_BROWSER)) {
            case "firefox":
                initDriverFirefox(firefox);
                break;
            case "chrome":
                initDriverChrome(chrome);
                break;
            default:
                Assertions.fail("Типа браузера '" + propertiesManager.getProperty(TYPE_BROWSER)
                + "' не существует в фреймворке");
        }
    }

    private void initDriverFirefox(String pathDriver) {
        if(propertiesManager.getProperty(IS_HEADLESS).equals("yes")) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            System.setProperty("webdriver.gecko.driver", propertiesManager.getProperty(pathDriver));
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            driver = new FirefoxDriver(firefoxOptions);
        } else if(propertiesManager.getProperty(IS_REMOTE).equals("yes")) {
             Assertions.fail("Режим '" + IS_REMOTE + "' не реализован в фреймворке");
        } else {
            System.setProperty("webdriver.gecko.driver", propertiesManager.getProperty(pathDriver));
            driver = new FirefoxDriver();
        }
    }
    
    private void initDriverChrome(String pathDriver) {
        if(propertiesManager.getProperty(IS_HEADLESS).equals("yes")) {
            System.setProperty("webdriver.chrome.driver", propertiesManager.getProperty(pathDriver));
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(chromeOptions);
        } else if(propertiesManager.getProperty(IS_REMOTE).equals("yes")) {
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
        } else {
            System.setProperty("webdriver.chrome.driver", propertiesManager.getProperty(pathDriver));
            driver = new ChromeDriver(getChromeOptions());
        }
    }
    
    private void initDriver() {
        if(OS.isFamilyWindows()) {
            if(propertiesManager.getProperty(TYPE_BROWSER).contains("firefox"))
                initDriverAnyOsFamily(PATH_DRIVER_FIREFOX_WINDOWS);
            else
                initDriverAnyOsFamily(PATH_DRIVER_CHROME_WINDOWS);
        } else if(OS.isFamilyMac()) {
            if(propertiesManager.getProperty(TYPE_BROWSER).contains("chrome"))
                initDriverAnyOsFamily(PATH_DRIVER_CHROME_MAC);
            else
                initDriverAnyOsFamily(PATH_DRIVER_FIREFOX_MAC);
        } else if(OS.isFamilyUnix()) {
            if(propertiesManager.getProperty(TYPE_BROWSER).contains("firefox"))
                initDriverAnyOsFamily(PATH_DRIVER_FIREFOX_UNIX);
            else
                initDriverAnyOsFamily(PATH_DRIVER_CHROME_UNIX);
        }
    }

    private void initDriverAnyOsFamily(String pathDriver) {
        switch(propertiesManager.getProperty(TYPE_BROWSER)) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", propertiesManager.getProperty(pathDriver));
                driver = new FirefoxDriver();
                break;
            case "headless_firefox":
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                System.setProperty("webdriver.gecko.driver", propertiesManager.getProperty(pathDriver));
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", propertiesManager.getProperty(pathDriver));
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "headless_chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "remote_chrome":
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
            default:
                Assertions.fail("Типа браузера '" + propertiesManager.getProperty(TYPE_BROWSER)
                + "' не существует в фреймворке");
        }
        if(driver != null) {
            //validateBrowser();
            // Установка общих праметров запуска для всех браузеров
            setManageBeforeStart();
        }
    }
    
    // TODO переделать инициализацию опций для всех браузеров
    private ChromeOptions getChromeOptions() {
        ChromeOptions result = new ChromeOptions();
        /*if(propertiesManager.getProperty(CHROME_MAXIMIZE_WINDOW).equals("yes")) {
            result.addArguments("start-maximized");
        }*/
        if(propertiesManager.getProperty(CHROME_DISABLE_NOTIFICATIONS).equals("yes")) {
            result.addArguments("disable-notifications");
        }
        if(propertiesManager.getProperty(CHROME_DISABLE_INFOBARS).equals("yes")) {
            result.addArguments("disable-infobars");
        }
        if(propertiesManager.getProperty(CHROME_DISABLE_POPUP_BLOCKING).equals("yes")) {
            result.addArguments("disable-popup-blocking");
        }
        if(propertiesManager.getProperty(CHROME_INCOGNITO).equals("yes")) {
            result.addArguments("incognito");
        }                
        return result;
    }
    
    private void setManageBeforeStart() {
        if(propertiesManager.getProperty(DELETE_ALL_COOKIES_BEFORE_START_TESTS).equals("yes")) {
            driver.manage().deleteAllCookies();
        }
    }
    
    private void validateBrowser() {
        /*Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        String browserVersion = caps.getVersion();*/
        log.debug("validateBrowser " + ((RemoteWebDriver) driver).getCapabilities().toString());
    }
}
