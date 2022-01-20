package ru.github.mirents.steps;

import ru.dns_shop.pages.managers.PageManager;
import ru.dns_shop.pages.managers.PropertiesManager;

public class BaseSteps {
    protected PageManager apptest = PageManager.getManager();
    protected PropertiesManager propertiesManager = PropertiesManager.getPropertiesManager();
}
