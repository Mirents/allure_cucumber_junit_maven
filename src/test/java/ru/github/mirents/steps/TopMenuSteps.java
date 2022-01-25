package ru.github.mirents.steps;

import io.cucumber.java.ru.И;

public class TopMenuSteps extends BaseSteps {
    @И("^в верхнем меню пользователь вводит текст \"([^\"]*)\"$")
    public void enterTextToFindInput(String text) {
        apptest
                .getTopMenu()
                .getFindMenu()
                .inputTextToFind(text)
                .clickButtonFind();
    }
    
    @И("^в верхнем меню нажать кнопку согласия выбора города$")
    public void confirmToThisCityStep() {
        apptest
                .getTopMenu()
                .confirmToThisCity();
    }
}
