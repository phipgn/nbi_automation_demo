package com.giaphi.nbi.steps;

import com.giaphi.nbi.poms.admin.BookingsPage;
import com.giaphi.nbi.poms.admin.VenueDetailPage;
import com.giaphi.nbi.poms.admin.VenuesPage;
import com.giaphi.nbi.poms.login.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

public class BookingStep extends BaseStep {
    private VenuesPage venuesPage;
    private VenueDetailPage venueDetailPage;
    private BookingsPage bookingsPage;
    private String expectedVenueName;
    private String expectedBookingName;

    @Given("^Login and navigate to Admin Portal page$")
    public void loginAndNavigateToAdminPortalPage() {
        var loginPage = new LoginPage(driver);
        var confirmationModal = loginPage.login(username, password);
        Assert.assertTrue(confirmationModal.isDisplayed());

        venuesPage = confirmationModal.clickAdminPortalButton();
        Assert.assertTrue(venuesPage.venueQuantities() > 0, "No venues to test!");
    }

    @When("^Click on venue at row ([1-9]+)$")
    public void clickOnTheFirstVenue(int row) {
        // get name of the first venue in Venues page
        expectedVenueName = venuesPage.venueName(row);

        // click the first venue
        venueDetailPage = venuesPage.clickVenueName(row);
        Assert.assertEquals(venueDetailPage.venueName(), "Venue: " + expectedVenueName);
    }

    @When("^Navigate to bookings page of selected venue$")
    public void navigateToBookingsPageOfSelectedVenue() {
        bookingsPage = venueDetailPage.clickOpenRestaurantButton();
        switchToTab(1);
        bookingsPage.waitFinishedLoading(30);
        Assert.assertEquals(bookingsPage.pageName(), "Bookings");
        Assert.assertEquals(bookingsPage.venueName(), expectedVenueName);
    }

    @When("^Make a walk-in booking with a random booking name$")
    public void makeAWalkInBookingWithARandomCustomerName() {
        expectedBookingName = RandomStringUtils.randomAlphanumeric(10);
        var walkInModal = bookingsPage.clickWalkInButton();
        walkInModal.createNewBooking(expectedBookingName);
    }

    @Then("^Booking should be added successfully$")
    public void bookingShouldBeAddedSuccessfully() {
        Assert.assertTrue(validateBookingHasBeenCreated(bookingsPage, expectedBookingName));
    }

    @After
    public void dispose() {
        driver.quit();
    }

    private boolean validateBookingHasBeenCreated(BookingsPage bookingsPage, String expectedBookingName) {
        var attempt = 2;
        do {
            bookingsPage.bookingsList().waitListTab().click();
            if (checkBookingsList()) return true;

            bookingsPage.bookingsList().bookingsTab().click();
            if (checkBookingsList()) return true;

            bookingsPage.bookingsList().seatedTab().click();
            if (checkBookingsList()) return true;

            // because of timezone different on local machine,
            // booking created today might be added to the day before
            bookingsPage.datePickerLeftArrow().click();
            attempt--;
        } while(attempt > 0);
        return false;
    }

    private boolean checkBookingsList() {
        for (var row = 1; row <= bookingsPage.bookingsList().numberOfBookings(); row++) {
            var bookingName = bookingsPage.bookingsList().bookingName(row).toLowerCase();
            if (expectedBookingName.toLowerCase().equals(bookingName))
                return true;
        }
        return false;
    }
}
