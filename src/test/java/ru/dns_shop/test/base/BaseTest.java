package ru.dns_shop.test.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static ru.dns_shop.pages.managers.DriverManager.getDriver;
import ru.dns_shop.pages.managers.*;
import static ru.dns_shop.pages.utils.ProperitesConstant.APP_URL;

/**
 * Базовый класс, отвечающий за первоначальную настройку тестов.
 * @author vadim
 */
public class BaseTest {
    protected PageManager apptest = PageManager.getManager();
    PropertiesManager propertiesManager = PropertiesManager.getPropertiesManager();
    
    /**
     * Метод первоначальной настройки драйвера и параметров запуска
     */
    @BeforeAll
    public static void beforeAll() {
        System.out.println("->BaseTest:beforeAll start InitManager:initFramework");
        InitManager.initFramework();
    }

    /**
     * Метод завершения работы
     */
    @AfterAll
    public static void afterAll() {
        System.out.println("->BaseTest:beforeAll start InitManager:quitFramework");
        InitManager.quitFramework();
    }
    
    /**
     * Открытие главной страница сайта перед каждым началом теста.
     */
    @BeforeEach
    public void beforeEach() {
        System.out.println("->BaseTest:beforeEach start getDriver().get(propertiesManager.getProperty(APP_URL))");
        getDriver().get(propertiesManager.getProperty(APP_URL));
    }
}
