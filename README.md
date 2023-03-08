### Пример фреймворка для автоматизированного тестирования UI на основе подхода BDD - Cucumber

##### Applied technology

* Language: Java 11
* Build Automation Tool: Maven
* Test Frameworks: JUnit 5
* BDD Test Frameworks: Cucumber
* Logger: Log4j2 with Slf4j
* Drivers used: Selenium
* Test website: http://demowebshop.tricentis.com/

##### Run tests

> mvn clean test "-Dgroups=(run1|run2)&!notRun"

> mvn clean test "-Dcucumber.filter.tags=(@run1 or @run2) and not @notRun"

##### Features

* запуск автоматизированных тестов в различных браузерах:
    * Firefox;
    * Chrome;
* запуск как в обычном, так и режиме со скрытой графической оболочкой;
* запуск в удаленном контейнере Docker (Реализовано для браузера Chrome);

По умолчанию для загрузки параметров тестов используется файл "application.properties", расположенный в папке "/src/main/resources/" относительно корня директории проекта.
В случае задания кастомного файла с другими настройками прописать при запуске название нового файла в системную переменную propFile: mvn -DpropFile=my
В файле с настройками все переменные, которые не будут заданы - будут проигнорированы. (Т.к. в хэш таблицу нельзя передать переменную со значением null)

##### Links

* [Страница][chrome_driver] с загрузкой Chrome WebDriver
* [Страница][gecko_driver] с загрузкой Firefox
* [Примеры][examples_before_after_all] реализации методов @BeforeAll и @AfterAll для главного класса запуса тестов
* [Настройки][settings_cucumber_junit5] Cucumber и Junit5

[chrome_driver]: https://chromedriver.chromium.org/downloads
[gecko_driver]: https://github.com/mozilla/geckodriver/releases
[examples_before_after_all]: https://metamorphant.de/blog/posts/2020-03-10-beforeall-afterall-cucumber-jvm-junit/
[settings_cucumber_junit5]: https://github.com/cucumber/cucumber-jvm/tree/main/junit-platform-engine