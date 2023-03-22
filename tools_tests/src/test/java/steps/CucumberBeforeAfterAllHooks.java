package steps;

import io.cucumber.java.AfterAll;
import io.github.mirents.managers.InitManager;
import io.cucumber.java.BeforeAll;
import lombok.extern.slf4j.Slf4j;
/**
 * Методы, выполняемые перед стартом каждого сценария и его завершением.
 * В одном future-файле может быть несколько сценариев, данные методы выполняться
 * для каждого.
 */
@Slf4j
public class CucumberBeforeAfterAllHooks {
    @BeforeAll
    public static void beforeAll() {
        log.info("Запуск настроек фреймворка перед запуском всех тестов");
        InitManager.initFramework();
    }

    @AfterAll
    public static void afterAll() {
        log.info("Завершение работы фреймворка после запуска всех тестов");
        InitManager.quitFramework();
    }
}
