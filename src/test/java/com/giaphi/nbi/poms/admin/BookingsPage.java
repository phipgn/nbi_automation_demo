package com.giaphi.nbi.poms.admin;

import com.giaphi.nbi.poms.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingsPage extends BasePage {
    public BookingsPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byVenueName = By.cssSelector("h5[class='venue-name']");
    By byPageName = By.cssSelector("header[page-title='bookings.title'] .header-text h2");
    By byDatePickerLeftArrow = By.xpath("//date-picker//md-icon[contains(@class, 'mdi-chevron-left')]");
    By byAddBookingButton = By.cssSelector("button[data-e2e='add-booking']");
    By byWalkInButton = By.cssSelector("button[data-e2e='icon-buttonwalkIn']");

    // Elements
    public String venueName() { return getElement(byVenueName).getText(); }
    public String pageName() { return getElement(byPageName).getText(); }
    public WebElement datePickerLeftArrow() { return getElement(byDatePickerLeftArrow); }
    public WebElement addBookingButton() { return getElement(byAddBookingButton); }
    public WebElement walkInButton() { return getElement(byWalkInButton); }
    public BookingsList bookingsList() { return new BookingsList(driver); }

    // Actions
    public void waitFinishedLoading(int timeoutInSeconds) {
        waitHelper.waitUntilDisplayed(byVenueName, timeoutInSeconds);
    }
    public WalkInModal clickWalkInButton() {
        walkInButton().click();
        return new WalkInModal(driver);
    }
}
