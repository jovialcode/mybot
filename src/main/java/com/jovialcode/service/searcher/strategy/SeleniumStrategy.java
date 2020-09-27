package com.jovialcode.service.searcher.strategy;

import com.jovialcode.model.vo.SearchRuleVO;
import com.jovialcode.service.searcher.rule.SearchRule;
import com.jovialcode.util.PropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeleniumStrategy implements SearchStrategy {
    public static final String WEB_DRIVER_ID = PropertyUtil.getProperty("WEB_DRIVER_ID");
    public static final String WEB_DRIVER_PATH = PropertyUtil.getProperty("WEB_DRIVER_PATH");

    private WebDriver driver;
    private SearchRule searchRule;

    public SeleniumStrategy(){
        initDriver();
    }

    private void initDriver(){
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver(getOption());
    }

    private ChromeOptions getOption(){
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        options.addArguments("--start-maximized"); //전체 화면
        options.addArguments("--headless"); // 브라우저를 띄우지 않음
        options.addArguments("--disable-gpu"); // GPU 사용하지 않음
        options.addArguments("--disable-popup-blocking"); // 팝업 무시
        return options;
    }

    @Override
    public String search(String query) {
        List<String> result = new ArrayList<>();
        try{
            driver.get(query);
            return driver.getPageSource();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.close();
        }
        return null;
    }

    @Override
    public void setSearchRule(SearchRule searchRule) {
        this.searchRule = searchRule;
    }
}
