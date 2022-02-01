package com.dws.steps;

import io.cucumber.java.ru.И;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductListSteps extends BaseSteps {
    
    @И("^в списке товаров выбрать \"([^\"]*)\"$")
    public void clickToLeftMenuStep(String product) {
        apptest
                .getProductListPage()
                .clickToProduct(product);
    }
}
