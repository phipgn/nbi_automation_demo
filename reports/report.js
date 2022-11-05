$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("booking.feature");
formatter.feature({
  "line": 1,
  "name": "Booking",
  "description": "",
  "id": "booking",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "As a user, I want to make a walk-in booking",
  "description": "",
  "id": "booking;as-a-user,-i-want-to-make-a-walk-in-booking",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@booking"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Login and navigate to Admin Portal page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Click on venue at row 1",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Navigate to bookings page of selected venue",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Make a walk-in booking with a random booking name",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Booking should be added successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "BookingStep.loginAndNavigateToAdminPortalPage()"
});
formatter.result({
  "duration": 14504556600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 22
    }
  ],
  "location": "BookingStep.clickOnTheFirstVenue(int)"
});
formatter.result({
  "duration": 1568865100,
  "status": "passed"
});
formatter.match({
  "location": "BookingStep.navigateToBookingsPageOfSelectedVenue()"
});
formatter.result({
  "duration": 14319410700,
  "status": "passed"
});
formatter.match({
  "location": "BookingStep.makeAWalkInBookingWithARandomCustomerName()"
});
formatter.result({
  "duration": 3625266600,
  "status": "passed"
});
formatter.match({
  "location": "BookingStep.bookingShouldBeAddedSuccessfully()"
});
formatter.result({
  "duration": 12811381200,
  "status": "passed"
});
formatter.after({
  "duration": 1133714400,
  "status": "passed"
});
});