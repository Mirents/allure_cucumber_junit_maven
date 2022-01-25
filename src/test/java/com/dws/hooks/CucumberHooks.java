package com.dws.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.dws.managers.InitManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CucumberHooks {
    
    @Before
    public void setUp() {
        log.info("Start Before");
        InitManager.initFramework();
        log.info("End Before");
    }

    @After
    public void tearDown() {
        log.info("Start After");
        InitManager.quitFramework();
        log.info("End After");
    }
}
