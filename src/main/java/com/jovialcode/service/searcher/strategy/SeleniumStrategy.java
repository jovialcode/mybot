package com.jovialcode.service.searcher.strategy;

import com.jovialcode.util.PropertyUtil;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumStrategy implements SearchStrategy<WebElement> {

    private WebDriver driver;

    public static final String WEB_DRIVER_ID = PropertyUtil.getProperty("WEB_DRIVER_ID");
    public static final String WEB_DRIVER_PATH = PropertyUtil.getProperty("WEB_DRIVER_PATH");

    private void initDriver(){
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver(options);
    }

    @Override
    public WebElement search(String query) {
        initDriver();
        try{
            driver.get(query);
            return driver.findElement(By.tagName("body"));
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.close();
        }
        return null;
    }
}
