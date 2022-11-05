package com.giaphi.nbi.poms.login;

import com.giaphi.nbi.poms.BasePage;
import com.giaphi.nbi.poms.admin.VenuesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationModal extends BasePage {
    public ConfirmationModal(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byHeader = By.cssSelector("h2[class='loginConfirmation--heading']");
    By byRestaurantDiaryButton = By.xpath("//button[text()='Restaurant Diary']");
    By byAdminPortalButton = By.xpath("//button[text()='Admin Portal']");

    // Elements
    public WebElement header() { return getElement(byHeader); }
    public WebElement restaurantDiaryButton() { return getElement(byRestaurantDiaryButton); }
    public WebElement adminPortalButton() { return getElement(byAdminPortalButton); }

    // Actions
    public boolean isDisplayed() {
        return header().isDisplayed();
    }

    public void clickRestaurantDiaryButton() {
        restaurantDiaryButton().click();
    }

    public VenuesPage clickAdminPortalButton() {
        adminPortalButton().click();
        return new VenuesPage(driver);
    }
}
