Feature: Booking

  Scenario: As a user, I want to make a walk-in booking
    Given Login and navigate to Admin Portal page
    When Click on venue at row 1
    When Navigate to bookings page of selected venue
    When Make a walk-in booking with a random booking name
    Then Booking should be added successfully

