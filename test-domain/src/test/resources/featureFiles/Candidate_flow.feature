@ibucur
Feature: Candidate

  Background:
    Given user is logged as admin

  Scenario: Admin creates a Candidate
    And admin selects the following tab: RecruitmentPage
    When admin clicks on ADD_BUTTON
    And admin fills mandatory fields
      | First Name | Last Name | Email          |
      | Johny      | Lahanta   | lahanta@me.com |
    And admin clicks on SAVE_BUTTON
    Then candidate is successfully saved.

  Scenario: Admin edits a Candidate
    And admin selects the following tab: RecruitmentPage
    When admin fills the Candidate Name field with: Johny Lahanta
    And admin clicks on SEARCH_BUTTON
    And admin selects the Candidate
    And admin clicks on EDIT_BUTTON
    And admin fills next fields
      | Contact No | Comment           |
      | 068956301  | Candidate comment |
    And admin clicks on SAVE_BUTTON
    Then admin receives that  candidate is successfully saved.

  Scenario: Admin deletes a Candidate
    And admin selects the following tab: RecruitmentPage
    When admin fills the Candidate Name field with: Johny Lahanta
    And admin clicks on SEARCH_BUTTON
    And admin clicks on SELECT_ALL
    And admin clicks on DELETE_BUTTON
    And admin clicks on DELETE_CONFIRMATION_BUTTON
    Then candidate is successfully deleted.
