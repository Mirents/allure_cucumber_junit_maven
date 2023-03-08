package steps;

import io.cucumber.java.ru.И;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MenuSteps extends BaseSteps {
    
    @И("^в левом меню нажать \"([^\"]*)\"$")
    public void clickToLeftMenuStep(String text) {
        apptest
                .getMenuToPage()
                .clickLeftMenu(text);
    }
    
    @И("^в верхнем меню в категории \"([^\"]*)\" выбрать \"([^\"]*)\"$")
    public void clickToSubcategoriesInTopMenu(String categories, String subCategories) {
        apptest
                .getMenuToPage()
                .mouseMoveToTopMenu(categories)
                .clickTopSubMenu(subCategories);
    }
    
    @И("^в верхнем меню проверить соответствие количества товаров добавленных в корзину$")
    public void assertCartQuanity() {
        apptest
                .getMenuToPage()
                .assertLabelShoppingCartQuantity();
    }
    
    @И("^в верхнем меню нажать на кнопку перехода в корзину$")
    public void goToCart() {
        apptest
                .getMenuToPage()
                .goToCart();
    }
}
