/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.dns_shop.pages.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import static ru.dns_shop.pages.managers.DriverManager.getDriver;

/**
 *
 * @author Raven
 */
public class Screenshoter {
    public void takeScreenshot() { 
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(getDriver());
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path)); 
            System.out.println(String.format("Create Screenshot to file %s", path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
    }
}
