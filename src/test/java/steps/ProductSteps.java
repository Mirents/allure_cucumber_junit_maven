package steps;

import io.cucumber.java.ru.И;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductSteps extends BaseSteps {
    
    @И("^добавить в хранилище текущую стоимость и количество продукта$")
    public void saveToStorageThisProductStep() {
        apptest
                .getProductPage()
                .saveToStorageThisProduct();
    }
    
    @И("^проверить соответствие цвета всплывающего окна уведомления \"([^\"]*)\"$")
    public void assertBarNotificationColorStep(String color) {
        apptest
                .getProductPage()
                .assertBarNotificationColor(color);
    }
    
    @И("^проверить соответствие текста всплывающего окна уведомления \"([^\"]*)\"$")
    public void assertBarNotificationTextStep(String text) {
        apptest
                .getProductPage()
                .assertBarNotificationText(text);
    }
    
    @И("^нажать кнопку добавления товара в корзину$")
    public void clickButtonAddToCartStep() {
        apptest
                .getProductPage()
                .clickButtonAddToCart();
    }
    
    @И("^ввести текст в поле количества товара \"([^\"]*)\"$")
    public void inputQuanityEnterTextStep(String text) {
        apptest
                .getProductPage()
                .inputQuanityEnterText(text);
    }
    
    @И("^ввести число в поле количества товара \"([^\"]*)\"$")
    public void inputQuanityEnterNumberStep(String number) {
        apptest
                .getProductPage()
                .inputQuanityEnterNumber(number);
    }

    @И("^установить в хранилище значение количества данного товара \"([^\"]*)\"$")
    public void saveToThisProductQuanityInStorageStep(String number) {
        apptest
                .getProductPage()
                .saveToThisProductQuanityInStorage(number);
    }

    @И("^очистить поле количества товара$")
    public void inputQuanityClearStep() {
        apptest
                .getProductPage()
                .inputQuanityClear();
    }
}
