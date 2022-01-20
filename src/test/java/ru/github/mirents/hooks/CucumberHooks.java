package ru.github.mirents.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
    @Before
    public void beforeExample() {
        System.out.println("Before Test");
    }

    @After
    public void afterExample() {
        System.out.println("After Test");
    }
}
