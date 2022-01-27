package com.dws.steps;

import io.cucumber.java.ru.И;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TopMenuSteps {
    @И("^в верхнем меню пользователь вводит текст \"([^\"]*)\"$")
    public void enterTextToFindInput(String text) {
        log.info("enterTextToFindInput");
    }
    
    @И("^в верхнем меню нажать кнопку согласия выбора города$")
    public void confirmToThisCityStep() {
        log.info("confirmToThisCityStep");
    }
}
