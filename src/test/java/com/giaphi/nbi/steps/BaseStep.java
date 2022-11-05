package com.giaphi.nbi.steps;

import com.giaphi.nbi.helpers.ConfigHelper;
import com.giaphi.nbi.helpers.DriverHelper;
import com.giaphi.nbi.poms.admin.VenuesPage;
import com.giaphi.nbi.poms.login.ConfirmationModal;
import com.giaphi.nbi.poms.login.LoginPage;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseStep {
    protected WebDriver driver;
    protected String username = ConfigHelper.getConfig("admin.username");
    protected String password = ConfigHelper.getConfig("admin.password");


    public BaseStep() {
        driver = DriverHelper.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigHelper.getConfig("site.url"));
    }

    protected void switchToTab(int index) {
        var tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }
}
