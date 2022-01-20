package ru.github.mirents.steps;

import io.cucumber.java.ru.И;

public class TopMenuSteps extends BaseSteps {
    @И("^в верхнем меню пользователь вводит текст \"([^\"]*)\"$")
    public void firstStep(String text) {
        apptest
                .getTopMenu()
                .getFindMenu()
                .inputTextToFind(text)
                .clickButtonFind();
    }
}
