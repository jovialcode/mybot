package com.jovialcode.service.searcher.strategy;

import com.jovialcode.config.SearchConst.SEARCH_STRATEGY;
import com.jovialcode.model.vo.SearchVO;
import com.jovialcode.util.PropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumStrategy extends AbstractSearchStrategy {
    public static final String WEB_DRIVER_ID = PropertyUtil.getProperty("WEB_DRIVER_ID");
    public static final String WEB_DRIVER_PATH = PropertyUtil.getProperty("WEB_DRIVER_PATH");

    private WebDriver driver;

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
    public String search(SearchVO searchVO) {
        String searchWord = searchVO.getWord();
        try{
            driver.get(searchVO.getUrl());
            WebElement searchInput = driver.findElement(By.xpath(searchVO.getXPath()));
            if(searchInput == null){
                throw new RuntimeException("ERROR.noElement");
            }
            //element 못 찾을 때 에러 반환
            searchInput.sendKeys(searchWord);
            searchInput.submit();
            Thread.sleep(5000);
            return driver.getPageSource();
        }catch(RuntimeException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.close();
        }
        return null;
    }

    @Override
    public SEARCH_STRATEGY getSearchStrategy() {
        return SEARCH_STRATEGY.SELENIUM;
    }
}
