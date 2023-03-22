package io.github.mirents.pages.base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.mirents.managers.DriverManager;
import io.github.mirents.managers.PropertiesManager;
import io.github.mirents.managers.WaitManager;
import io.github.mirents.pages.utils.ProperitesConstant;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PageBase {
    protected static final Logger LOGGER = LogManager.getLogger(PageBase.class);
    protected Actions action = new Actions(DriverManager.getDriver());
    
    public PageBase() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
    
    public <T extends PageBase> T findBrokenLinks() {
        List<WebElement> links = DriverManager.getDriver().findElements(By.tagName("a"));
 
        if(links.size() > 0) {
            for(int i=0;i<links.size();i++)
            {
                WebElement element = links.get(i);
                String url = element.getAttribute("href");
                isBrokenLink(url);
            }
        }
        return (T) this;
    }

    public <T extends PageBase> T findBrokenImage() {
        List<WebElement> images = DriverManager.getDriver().findElements(By.tagName("img"));

        if(images.size() > 0) {
            for(int index=0;index<images.size();index++)
            {
                WebElement image = images.get(index);
                String imageURL= image.getAttribute("src");
                
                isBrokenLink(imageURL);

                try {
                    boolean imageDisplayed =
                            execScript("return (typeof arguments[0]"
                                    + ".naturalWidth !=\"undefined\" "
                                    + "&& arguments[0].naturalWidth > 0);"
                                    , image);
                    if(!imageDisplayed) {
                        Assertions.fail("On the screen - a broken image with a link - "
                        + imageURL);
                    }
                } catch (Exception ex) {
                    Assertions.fail("Image verification error by reference - "
                    + imageURL);
                }
            }
        }
        return (T) this;
    }

    private void isBrokenLink(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
 
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400) {
                Assertions.fail("Broken link - " + linkUrl + " - "
                        + httpURLConnect.getResponseMessage());
            }
        } catch (IOException ignore) {}
    }
    
    private boolean execScript(String script, WebElement element) {
        return (Boolean) ((JavascriptExecutor) DriverManager.getDriver())
                        .executeScript(script, element);
    }
    
    public boolean isElementExist(By by) {
        boolean flag = false;
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            DriverManager.getDriver().findElement(by);
            flag = true;
        } catch (NoSuchElementException ignore) {}
        finally {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(
                    Integer.parseInt(PropertiesManager.getPropertiesManager()
                            .getProperty(ProperitesConstant.DRIVER_IMPLICITY_WAIT)), TimeUnit.SECONDS);
        }
        return flag;
    }
    
    protected void clickToElementFromList(List<WebElement> list, String name) {
        WebElement element = getElemFromListToName(list, name);
        element.click();
    }
    
    protected void mouseMoveToElementFromList(List<WebElement> list, String name) {
        WebElement element = getElemFromListToName(list, name);
        action.moveToElement(element).build().perform();
    }

    protected WebElement getElemFromListToName(List<WebElement> list, String name) {
        for (WebElement element: list) {
            if (element.getText().equalsIgnoreCase(name)) {
                WaitManager.getWaitManager().until(ExpectedConditions.visibilityOf(element));
                return element;
            }
        }
        String msg = "Element to name '" + name + "' not found to "
                + this.getClass().getName();
        LOGGER.error(msg);
        Assertions.fail(msg);
        return null;
    }
    
    public WebElement getElemFromListToBy(List<WebElement> list, By by) {
        for (WebElement element: list) {
            WaitManager.getWaitManager().until(ExpectedConditions.visibilityOf(element));
            WebElement findElement = element.findElement(by);
            return findElement;
        }
        String msg = "Element to by '" + by + "' not found to "
                + this.getClass().getName();
        LOGGER.error(msg);
        Assertions.fail(msg);
        return null;
    }
}
