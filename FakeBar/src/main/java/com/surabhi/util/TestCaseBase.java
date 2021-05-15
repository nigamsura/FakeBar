package com.surabhi.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;

public class TestCaseBase {
    public static WebDriver driver;

    @BeforeClass(alwaysRun=true)
    public void setUpBrowser(){
        //Please update webdriver path here
        File file = new File("/Users/surabhinigam/Documents/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();

    }

    @AfterTest (alwaysRun=true)
    public void closeBrowser(){
      driver.quit();

    }
}
