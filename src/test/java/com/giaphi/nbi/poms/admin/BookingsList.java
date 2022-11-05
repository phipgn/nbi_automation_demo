package com.giaphi.nbi.poms.admin;

import com.giaphi.nbi.poms.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingsList extends BasePage {
    public BookingsList(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byWaitListTab = By.xpath("//bookings-list//button[contains(@aria-label, 'Wait list')]");
    By byBookingsTab = By.xpath("//bookings-list//button[contains(@aria-label, 'Bookings')]");
    By bySeatedTab = By.xpath("//bookings-list//button[contains(@aria-label, 'Seated')]");
    By byNumberOfBookings = By.cssSelector("bookings-list md-list-item");
    By byBookingName(int row) { return By.xpath("(//bookings-list//md-list-item)[" + row + "]//booking-info//span[contains(@class, 'name')]"); }

    // Elements
    public WebElement waitListTab() { return getElement(byWaitListTab); }
    public WebElement bookingsTab() { return getElement(byBookingsTab); }
    public WebElement seatedTab() { return getElement(bySeatedTab); }
    public int numberOfBookings() { return getElements(byNumberOfBookings).size(); }
    public String bookingName(int row) { return getElement(byBookingName(row)).getText(); }
}
