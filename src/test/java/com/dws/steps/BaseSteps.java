package com.dws.steps;

import com.dws.managers.PageManager;
import com.dws.managers.PropertiesManager;

public class BaseSteps {
    protected PageManager apptest = PageManager.getPageManager();
    protected PropertiesManager propertiesManager = PropertiesManager.getPropertiesManager();
}
