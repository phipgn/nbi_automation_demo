package com.giaphi.nbi.poms;

import com.giaphi.nbi.helpers.WaitHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected final WebDriver driver;
    protected final WaitHelper waitHelper;

    public BasePage(WebDriver _driver) {
        driver = _driver;
        waitHelper = new WaitHelper(driver);
    }

    protected WebElement getElement(By by) {
        return driver.findElement(by);
    }

    protected List<WebElement> getElements(By by) {
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(by);
        } catch (NoSuchElementException e) {
            elements = new ArrayList<>();
        }
        return elements;
    }

    protected void inputText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void pressKey(CharSequence key) {
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }
}
