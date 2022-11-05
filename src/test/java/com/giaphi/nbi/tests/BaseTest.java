package com.giaphi.nbi.tests;

import com.giaphi.nbi.helpers.ConfigHelper;
import com.giaphi.nbi.helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected String username = ConfigHelper.getConfig("admin.username");
    protected String password = ConfigHelper.getConfig("admin.password");

    public BaseTest() {
        driver = DriverHelper.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigHelper.getConfig("site.url"));
    }

    protected void switchToTab(int index) {
        var tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    @AfterTest
    public void dispose() {
        driver.quit();
    }
}
