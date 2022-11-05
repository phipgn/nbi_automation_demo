package com.giaphi.nbi.poms.admin;

import com.giaphi.nbi.poms.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VenueDetailPage extends BasePage {
    public VenueDetailPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byOpenRestaurantButton = By.xpath("//button[text()='Open Restaurant']");
    By byVenueName = By.xpath("//h2[contains(text(), 'Venue:')]");

    // Elements
    public WebElement openRestaurantButton() { return getElement(byOpenRestaurantButton); }
    public String venueName() { return getElement(byVenueName).getText(); }

    // Actions
    public BookingsPage clickOpenRestaurantButton() {
        openRestaurantButton().click();
        return new BookingsPage(driver);
    }
}
