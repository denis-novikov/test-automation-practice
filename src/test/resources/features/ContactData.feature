Feature: I as a user who is managing user contact data

  Background: : Some scenario
    Given Widgets Gallery Page is open
    And User is navigating to 'Editing' > 'Data Validation' page
    And select 'Angular' framework
    And switch to demo frame

  Scenario: I want to add valid email to contact data
    When user adds new contact
    And enter an 'test-1@gmail.com' address in email field
    Then email field is highlighted with GREEN

  Scenario Outline: I want to be informed about invalid email
    When user adds new contact
    And enter an '<email>' address in email field
    Then email field is highlighted with RED
    And error '<message>' is shown

    Examples:
      | email               | message           |
      | test                | Email is invalid  |
      | test.test@gmail.com | Email is invalid  |
