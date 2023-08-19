package com.giaphi.nbi.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverHelper {
    public static WebDriver getDriver() {
        var path = System.getProperty("user.dir");
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
