package com.giaphi.nbi.poms.admin;

import com.giaphi.nbi.poms.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WalkInModal extends BasePage {
    public WalkInModal(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byCustomerWalkInTab = By.cssSelector("md-tab-item span[data-e2e-new-booking-tab='customer']");
    By byCustomerNameInput = By.cssSelector("input[name='firstName']");
    By bySaveButton = By.xpath("//button//span[text()='Save']");

    // Elements
    public WebElement customerWalkInTab() { return getElement(byCustomerWalkInTab); }
    public WebElement customerNameInput() { return getElement(byCustomerNameInput); }
    public WebElement saveButton() { return getElement(bySaveButton); }

    // Actions
    public void createNewBooking(String name) {
        customerWalkInTab().click();
        inputText(customerNameInput(), name);
        saveButton().click();
        pressKey(Keys.ESCAPE);
    }
}
