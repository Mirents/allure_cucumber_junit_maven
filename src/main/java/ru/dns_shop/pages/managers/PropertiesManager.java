package ru.dns_shop.pages.managers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesManager {
    private final Properties properties = new Properties();
    
    private static PropertiesManager INSTANCE = null;
    
    private PropertiesManager() {
        loadApplicationProperites();
        loadCustomProperites();
    }
    
    public static PropertiesManager getPropertiesManager() {
        if(INSTANCE == null) {
            INSTANCE = new PropertiesManager();
        }
        return INSTANCE;
    }
    
    /**
     * Метод загрузки параметров работы тестов
     * По умолчанию загружается файл "applications.properties", но если
     * в папке resources расположен файл с другим именем и его имя передано
     * системной переменной propFile - тогда будет загружен этот файл
     * 
     */
    private void loadApplicationProperites() {
        // Посмотреть, чтобы название кастомной системной переменной не
        // совпадало с реальными переменными всех ОС
        try {
            properties.load(new FileInputStream(new File(
                    "src/main/resources/" +
                            System.getProperty("propFile", "applications") +
                            ".properties")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Метод загрузки переменной из системных переменых, заданной вручнуу.
     * Уточнить, каким путем это можно сделать
     */
    private void loadCustomProperites() {
        properties.forEach((key, value) -> System.getProperties()
        .forEach((customUserKey, customUserValue) -> {
        if(key.toString().equals(customUserKey.toString()) &&
                !value.toString().equals(customUserValue.toString())) {
                properties.setProperty(key.toString(), customUserValue.toString());
        }
        }));
    }
}
