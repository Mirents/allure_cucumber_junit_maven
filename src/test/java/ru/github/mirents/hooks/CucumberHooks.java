package ru.github.mirents.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.dns_shop.pages.managers.InitManager;

public class CucumberHooks {
    
    @Before
    public void setUp() {
        InitManager.initFramework();
    }

    @After
    public void tearDown() {
        InitManager.quitFramework();
    }
}
