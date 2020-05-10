Feature: I as a user who is managing user contact data

  Background:
    Given I am on BasePage
    And I am navigating to DataValidation page
    And I am switching to Angular framework
    And starting to work with widget

  Scenario: I want to add valid email to contact data
    When I am adding new contact
    And enter an test-1@gmail.com address in email field
    Then email field is highlighted with green


  Scenario Outline: I want to be informed about invalid email
    When I am adding new contact
    And enter an <email> address in email field
    Then email field is highlighted with red
    And I can see an error <message>

    Examples:
      | email               | message           |
      |                     | Email is required |
      | test                | Email is invalid  |
      | test.test@gmail.com | Email is invalid  |
