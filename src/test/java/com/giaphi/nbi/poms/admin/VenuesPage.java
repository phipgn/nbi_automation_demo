package com.giaphi.nbi.poms.admin;

import com.giaphi.nbi.poms.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VenuesPage extends BasePage {
    public VenuesPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byVenueQuantities = By.cssSelector(".data-table tbody tr[role='button']");
    By byVenueName(int row) { return By.xpath("((//table[contains(@class, 'data-table')]//tbody/tr[@role='button'])[" + row + "])/td[2]"); }

    // Elements
    public int venueQuantities() { return getElements(byVenueQuantities).size(); }
    public String venueName(int row) { return getElement(byVenueName(row)).getText(); }

    // Actions
    public VenueDetailPage clickVenueName(int row) {
        var element = getElement(byVenueName(row));
        element.click();
        return new VenueDetailPage(driver);
    }
}
