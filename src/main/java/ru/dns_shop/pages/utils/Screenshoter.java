package ru.dns_shop.pages.utils;

import java.io.File;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import static ru.dns_shop.pages.managers.DriverManager.getDriver;

@Slf4j
public class Screenshoter {
    public void takeScreenshot() { 
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(getDriver());
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path)); 
            log.debug("Create Screenshot to file '{}'", path);
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
    }
}
