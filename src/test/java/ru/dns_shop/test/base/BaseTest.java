package ru.dns_shop.test.base;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.dns_shop.pages.managers.PageManager;
import static ru.dns_shop.pages.managers.DriverManager.getDriver;
import static ru.dns_shop.pages.managers.DriverManager.quitDriver;

/**
 * Базовый класс, отвечающий за первоначальную настройку тестов
 * @author vadim
 */
public class BaseTest {
    protected PageManager apptest = PageManager.getManager();
    
    public WebDriverWait wait;
    
    /**
     * Метод первоначальной настройки драйвера и параметров запуска
     */
    @BeforeEach
    public void beforeAll() {
        
    }

    /**
     * Метод завершения работы
     */
    @AfterEach
    public void afterAll() {
        quitDriver();
    }    
}
