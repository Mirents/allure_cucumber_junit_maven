package steps;

import io.cucumber.java.ru.И;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CartSteps extends BaseSteps {
    
    @И("^проверить соответствие общей стоимости добавленных товаров в корзине$")
    public void clickToLeftMenuStep() {
        apptest
                .getCartPage()
                .assertTotalPrice();
    }
}
