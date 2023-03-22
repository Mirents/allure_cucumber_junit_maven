package steps;

import io.github.mirents.managers.InitManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

/**
 * Методы, выполняемые перед стартом каждого сценария и его завершением.
 * В одном future-файле может быть несколько сценариев, данные методы выполняться
 * для каждого.
 */
@Slf4j
public class CucumberBeforeAfterEachHooks {
    @Before
    public void beforeEach() {
        log.info("Запуск установки тестового окружения перед стартом сценария");
        InitManager.openBrowser();
    }
    
    @After
    public void afterEach() {
        log.info("Запуск уничтожения тестового окружения после завершения сценария");
        InitManager.clearCookies();
    }
}
