Feature: Verify completed task percentage for users in FanCode city

  Scenario Outline: Verify completed task percentage for users in FanCode city
    Given User with id <userId> belongs to the city FanCode
    When User <userId> has the todo tasks
    Then User <userId> Completed task percentage should be greater than 50%

  Examples:
    | userId |
    | 1      |
