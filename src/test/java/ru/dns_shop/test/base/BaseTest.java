package ru.dns_shop.test.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.dns_shop.pages.managers.*;

/**
 * Базовый класс, отвечающий за первоначальную настройку тестов.
 * @author vadim
 */
public class BaseTest {
    protected PageManager apptest = PageManager.getManager();
    protected PropertiesManager propertiesManager = PropertiesManager.getPropertiesManager();
    
    /**
     * Метод первоначальной настройки драйвера и параметров запуска
     */
    /*@BeforeAll
    public static void beforeAll() {
        InitManager.initFramework();
    }*/

    /**
     * Метод завершения работы
     */
    /*@AfterAll
    public static void afterAll() {
        InitManager.quitFramework();
    }*/
    
    /**
     * Открытие главной страница сайта перед каждым началом теста.
     */
    /*@BeforeEach
    public void beforeEach() {
        getDriver().get(propertiesManager.getProperty(APP_URL));
    }*/
    
    @BeforeEach
    public void beforeEach() {
        InitManager.initFramework();
    }
    
    @AfterEach
    public void afterEach() {
       InitManager.quitFramework();
    }
}
