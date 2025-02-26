Feature: Delete Employee by Name

  Scenario: Successfully delete an employee by name
    Given an employee with name "John Doe" exists
    When I delete the employee with name "John Doe"
    Then the employee with name "John Doe" should no longer exist in the system
