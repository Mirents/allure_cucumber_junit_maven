package com.dws.bdd_tests;

import com.dws.managers.InitManager;
import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import lombok.extern.slf4j.Slf4j;

/**
 * Точка входа/раннер для старта тестов Cucumber
 * Для работы методов-эмуляторов @BeforeClass и @AfterClass данный
 * класс реализует ConcurrentEventListener и в файле настроек src/test/
 * resources/junit-platform.properties в параметр cucumber.plugin передано полное
 * имя данного класса. Так же данная реализация возможна при использовании вместо
 * RunnerCucumber другого стороннего класса(Так же с передачей параметра).
 * В папке resources файлы со сценариями должны иметь путь по папкам как у
 * раннера 'src/test/resources/com/dws/bdd_tests'.
 */
@Slf4j
@Cucumber
public class RunnerCucumber implements ConcurrentEventListener {
    
    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
      eventPublisher.registerHandlerFor(TestRunStarted.class, event -> {
        beforeAll();
      });
      eventPublisher.registerHandlerFor(TestRunFinished.class, event -> {
        afterAll();
      });
    }
    
    private void beforeAll() {
        log.info("Запуск настроек фреймворка перед запуском всех тестов");
        InitManager.initFramework();
    }
    
    private void afterAll() {
        log.info("Завершение работы фреймворка после запуска всех тестов");
        InitManager.quitFramework();
    }
}
