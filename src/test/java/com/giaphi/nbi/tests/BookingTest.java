package com.giaphi.nbi.tests;

import com.giaphi.nbi.poms.admin.BookingsPage;
import com.giaphi.nbi.poms.login.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest extends BaseTest {

    public BookingTest() {}

    @Test
    public void testMakeABooking() {
        var loginPage = new LoginPage(driver);
        var confirmationModal = loginPage.login(username, password);
        Assert.assertTrue(confirmationModal.isDisplayed());

        // click Admin Portal button
        var venuesPage = confirmationModal.clickAdminPortalButton();
        Assert.assertTrue(venuesPage.venueQuantities() > 0, "No venues to test!");

        // get name of the first venue in Venues page
        var expectedVenueName = venuesPage.venueName(1);

        // click the first venue
        var venueDetailPage = venuesPage.clickVenueName(1);
        Assert.assertEquals(venueDetailPage.venueName(), "Venue: " + expectedVenueName);

        // click Open Restaurant button
        var bookingsPage = venueDetailPage.clickOpenRestaurantButton();
        switchToTab(1);
        bookingsPage.waitFinishedLoading(30);
        Assert.assertEquals(bookingsPage.pageName(), "Bookings");
        Assert.assertEquals(bookingsPage.venueName(), expectedVenueName);

        // make a booking and save
        var expectedBookingName = RandomStringUtils.randomAlphanumeric(10);
        var walkInModal = bookingsPage.clickWalkInButton();
        walkInModal.createNewBooking(expectedBookingName);

        // validate booking has been added successfully
        Assert.assertTrue(validateBookingHasBeenCreated(bookingsPage, expectedBookingName));
    }

    private boolean validateBookingHasBeenCreated(BookingsPage bookingsPage, String expectedBookingName) {
        bookingsPage.bookingsList().waitListTab().click();
        for (var row = 1; row <= bookingsPage.bookingsList().numberOfBookings(); row++) {
            var bookingName = bookingsPage.bookingsList().bookingName(row).toLowerCase();
            if (expectedBookingName.toLowerCase().equals(bookingName))
                return true;
        }

        bookingsPage.bookingsList().seatedTab().click();
        for (var row = 1; row <= bookingsPage.bookingsList().numberOfBookings(); row++) {
            var bookingName = bookingsPage.bookingsList().bookingName(row).toLowerCase();
            if (expectedBookingName.toLowerCase().equals(bookingName))
                return true;
        }

        return false;
    }
}
