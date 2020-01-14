@vbanaru
Feature: System Users

  Background:
    Given user is logged as admin

  Scenario: Admin creates a new System User
    Given admin selects the following tab: Admin
    When admin clicks on ADD_BUTTON
    And admin fills mandatory fields with valid data
      | Employee Name | Username   | Password | Confirm Password |
      | John Smitt    | johnsmitt2 | 12345678 | 12345678         |
    And admin clicks on SAVE_BUTTON
    Then admin successfully saved System User

  Scenario: Admin edits System User
    Given admin selects the following tab: Admin
    When admin fills in username field: johnsmitt2
    And admin clicks on SEARCH_BUTTON
    And admin select systemUser: johnsmitt2
    And admin clicks on EDIT_BUTTON
    And admin changes to johnsmitt3 username
    And admin clicks on SAVE_BUTTON
    Then admin receives message - Successfully updated

  Scenario: Admin user can delete System User
    Given admin selects the following tab: Admin
    When admin fills in username field: johnsmitt3
    And admin clicks on SEARCH_BUTTON
    And admin clicks on SELECT_ALL
    And admin clicks on DELETE_BUTTON
    When admin clicks on DELETE_CONFIRMATION_BUTTON
    Then admin receives message - Successfully deleted
