package ru.dns_shop.pages.managers;

import java.sql.Time;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;
    
    private static DriverManager INSTANCE = null;
    
    private DriverManager() {
        initDriver();
    }
    
    /**
     * Получение INSTANCE драйера.
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        if(INSTANCE == null) {
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
        /*if(OS.isFamilyWindows()) {
            initDriverWindowsOsFamily();
        } else if(OS.isFamilyMac()) {
            initDriverMacOsFamily();
        } else if(OS.isFamilyUnix()) {
            initDriverUnixOsFamily();
        }*/
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-infobars");
        // Без этих опций вообще не начинало работу
        options.addArguments("disable-popup-blocking");
        options.addArguments("incognito");
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriverunix");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        System.out.println("-------------Начало загрузки страницы");
        try {  
            String baseUrl = "https://www.dns-shop.ru/";
            //driver.navigate().to(baseUrl); 
            driver.get(baseUrl);
        } catch (TimeoutException e) {}
        System.out.println("-------------Завершение загрузки страницы");
        
        /*new WebDriverWait(driver, 1).until( 
            webDriver -> ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete"));*/
    }
    
    /*private void initDriverWindowsOsFamily() {
        initDriverAnyOsFamily(PATH_GECKO_DRIVER_WINDOWS, PATH_CHROME_DRIVER_WINDOWS);
    }
    
    private void initDriverMacOsFamily() {
        initDriverAnyOsFamily(PATH_GECKO_DRIVER_MAC, PATH_CHROME_DRIVER_MAC);
    }
    
    private void initDriverUnixOsFamily() {
        initDriverAnyOsFamily(PATH_GECKO_DRIVER_UNIX, PATH_CHROME_DRIVER_UNIX);
    }
    
    private void initDriverAnyOsFamily(String gecko, String chrome) {
        switch(props.getProperty(TYPE_BROWSER)) {
            case "firefox":
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                driver = new ChromeDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("типа браузера '" + props.getProperty(TYPE_BROWSER)
                + "' не существует в фреймворке");
        }
    }*/
}
