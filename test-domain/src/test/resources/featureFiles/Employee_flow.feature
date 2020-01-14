@mmusteata
Feature: Employee

  Background:
    Given user is logged as admin

  Scenario: Admin creates a new Employee
    And admin selects the following tab: PIM
    When admin clicks on ADD_BUTTON
    And admin fills mandatory fields on add Employee page
      | First Name | Last Name |
      | Alex       | Frost     |
    And admin clicks on SAVE_BUTTON
    Then admin is on Personal Details page of Employee

  Scenario: Admin edits specific Employee
    And admin selects the following tab: PIM
    And admin fills in Employee Name field: Alex Frost
    And admin clicks on SEARCH_BUTTON
    And admin click Employee last name: Frost
    When admin clicks on EDIT_BUTTON
    And admin adds next Driver's License Number number: B
    And admin clicks on SAVE_BUTTON
    Then admin receives message: Successfully saved

  Scenario: Admin deletes specific Employee
    And admin selects the following tab: PIM
    And admin fills in Employee Name field: Alex Frost
    And admin clicks on SEARCH_BUTTON
    When admin clicks on SELECT_ALL
    And admin clicks on DELETE_BUTTON
    And admin clicks on DELETE_CONFIRMATION_BUTTON
    Then admin receives message: Successfully deleted
