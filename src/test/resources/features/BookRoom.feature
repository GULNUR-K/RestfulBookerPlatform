@jira-2255
@regression
Feature: Book a room

  Scenario:Error message is received if only input boxes are entered
    When user is on main page
    Then user scrolls to book this room button
    Then user can see "book this room" button
    Then user can click "book this room" button
    And  user can see calendar
    Then user can see "book" button
    Then user can click "book" button
    And  user gets "red error" message
    Then user can see "cancel" button
    Then user fills for "firstname"
    Then user can click "book" button
    And  user gets "red error" message
    Then user fills for "lastname"
    Then user can click "book" button
    And  user gets "red error" message
    Then user fills for "email"
    Then user can click "book" button
    And  user gets "red error" message
    Then user fills for "phone"
    Then user can click "book" button
    And  user gets "red error" message
    And  user can click "book" button
    And  user gets "red error" message
    Then user can click "cancel" button
    Then user can see "book this room" button

  Scenario:Error message is received if only the input boxes are filled and one future date is selected
    When user is on main page
    Then user scrolls to book this room button
    Then user can see "book this room" button
    Then user can click "book this room" button
    And  user can see calendar
    Then user can see "book" button
    Then user can see "cancel" button
    Then user fills for "firstname"
    And  user fills for "lastname"
    Then user fills for "email"
    And user fills for "phone"
    Then user can click "next" button
    And  user can select "one" date
    And  user can click "book" button
    And  user gets "red error" message

  Scenario:Error message is received if only the input boxes are filled and one old date is selected
    When user is on main page
    Then user scrolls to book this room button
    Then user can see "book this room" button
    Then user can click "book this room" button
    And  user can see calendar
    Then user can see "book" button
    Then user can see "cancel" button
    Then user fills for "firstname"
    And  user fills for "lastname"
    Then user fills for "email"
    And user fills for "phone"
    Then user can click "back" button
    And  user can select "one" date
    And  user can click "book" button
    And  user gets "red error" message

  Scenario:Successful message is received if the input boxes are filled and dates are selected
    When user is on main page
    Then user scrolls to book this room button
    Then user can see "book this room" button
    Then user can click "book this room" button
    And  user can see calendar
    Then user can see "book" button
    Then user can see "cancel" button
    Then user fills for "firstname"
    And  user fills for "lastname"
    Then user fills for "email"
    And user fills for "phone"
    Then user can click "next" button
    And  user can select "more than one" date
    And  user can click "book" button
    And  user gets "successful" message
    Then user can see "close" button