﻿Framework для автоматизированного тестирования.

В настоящий момент реализована поддержка:
- запуск автоматизированных тестов в различных браузерах:
    * Firefox;
    * Chrome;
- запуск как в обычном, так и режиме со скрытой графической оболочкой;
- запуск в удаленном контейнере Docker (Реализовано для браузера Chrome);

По умолчанию для загрузки параметров тестов используется файл "application.properties", расположенный в папке "/src/main/resources/" относительно корня директории проекта.
В случае задания кастомного файла с другими настройками прописать при запуске название нового файла в системную переменную propFile: mvn -DpropFile=my
В файле с настройками все переменные, которые не будут заданы - будут проигнорированы. (Т.к. в хэш таблицу нельзя передать переменную со значением null)

Ссылки:
Страница с загрузкой Chrome WebDriver:
https://chromedriver.chromium.org/downloads
Страница с загрузкой Firefox:
https://github.com/mozilla/geckodriver/releases

Команды запуска тестов:
mvn -Dtest=RunnerCucumber test - для запуска BDD тестов с помощью Cucumber

Примеры реализации методов @BeforeAll и @AfterAll для главного класса запуса тестов:
https://metamorphant.de/blog/posts/2020-03-10-beforeall-afterall-cucumber-jvm-junit/

Настройки Cucumber и Junit5:
https://github.com/cucumber/cucumber-jvm/tree/main/junit-platform-engine
