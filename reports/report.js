$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("booking.feature");
formatter.feature({
  "line": 1,
  "name": "Booking",
  "description": "",
  "id": "booking",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "As a user, I want to make a walk-in booking",
  "description": "",
  "id": "booking;as-a-user,-i-want-to-make-a-walk-in-booking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Login and navigate to Admin Portal page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Click on venue at row 1",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Navigate to bookings page of selected venue",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Make a walk-in booking with a random customer name",
  "keyword": "When "
});
formatter.match({
  "location": "BookingStep.loginAndNavigateToAdminPortalPage()"
});
formatter.result({
  "duration": 7986841500,
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
  "duration": 757419300,
  "status": "passed"
});
formatter.match({
  "location": "BookingStep.navigateToBookingsPageOfSelectedVenue()"
});
formatter.result({
  "duration": 32703130800,
  "status": "passed"
});
formatter.match({
  "location": "BookingStep.makeAWalkInBookingWithARandomCustomerName()"
});
formatter.result({
  "duration": 1673824200,
  "status": "passed"
});
formatter.after({
  "duration": 699061000,
  "status": "passed"
});
});