package ru.dns_shop.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.dns_shop.pages.base.BasePage;
import ru.dns_shop.pages.managers.*;
import static ru.dns_shop.pages.managers.DriverManager.getDriver;

/**
 * Класс карточки продукта.
 * @author vadim
 */
public class ProductPage extends BasePage {
    
    @FindBy(xpath = "//select[contains(@class, 'select')]")
    private WebElement selectWarnary;
    
    public ProductPage clickToWarnary() {
        Actions actions = new Actions(getDriver());
        actions.click(selectWarnary);
        actions.pause(1000);
        actions.click(getTwoYear(selectWarnary));
        actions.pause(1000);
        actions.perform();
        /*WaitManager.getWait()
                        .until(ExpectedConditions
                                .elementToBeClickable(selectWarnary));
        selectWarnary.click();*/
        return apptest.getProductPage();
    }
    
    private WebElement getTwoYear(WebElement elem) {
        return elem.findElement(By.xpath("//option[@value='1']"));
    }
}
