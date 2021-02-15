package ru.dns_shop.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.CsvSource;
import ru.dns_shop.test.base.BaseTest;

@DisplayName("Simple Test to get Youth Card")
public class SimpleTest extends BaseTest {
    
    /**
     * Простой линейный тест для проверки заполнения полей при оформлении
     * молодежной карты
     * @author vadim
     */
    @Test
    public void SimpleGetYouthCardTest() {
        apptest
                .getHomePage().inputText("playstation")
                .clickButtonFind()
                .clickToProduct("Игровая консоль PlayStation 4")
                .clickToWarnary();
    }

    /**
     * Тест, аналогичный первому, только запуском с тремя наборами параметров
     */
    @Disabled("Пока находится в разработке, отключен по ненадобности")
    //@ParameterizedTest
    @CsvSource({
        "Сергеев,Сергей,Сергеевич,SERGEY SERGEEV,"
                + "12.05.2003,serser@mail.ru,9851274967",
        "Евгеньев,Евгений,Евгеньевич,EVGENY EVGENEV,"
                + "25.10.2004,evgevg@mail.ru,9749369784",
        "Петров,Петр,Петрович,PETR PETROV,"
                + "12.07.2002,petpet@mail.ru,9749689142"
    })
    public void ParameterizedGetYouthCardTest(String lastName, String firstName,
            String middleName, String cardName, String birthDate,
            String email, String phone) {
        /*HomePage homePage = new HomePage(driver);
        DebetCard debetCard = new DebetCard(driver);
        YouthCard youthCard = new YouthCard(driver);

        homePage.clickButtonMenu();
        homePage.clickButtonPodMenu();
        debetCard.checkLabelPage();
        debetCard.checkAndClickCards();
        youthCard.checkLabelPage();
        youthCard.fillInputs(lastName, firstName, middleName, cardName,
                birthDate, email, phone);
        youthCard.clickButtonNext();
        youthCard.isErrorCheckInput();*/
    }
}