Feature: Delete Employee by Name

  Scenario: Delete employee by name
    Given employees added to Employee rest service repository:
      | id  | name | passportNumber | education  |
      | 108 | Tom  | TM123456       | University |
      | 109 | Sam  | SM456789       | College    |
      | 110 | John | JN789123       | School     |
      | 111 | John | JN789123       | School     |
    When employee with name "John" is deleted from the repository
    Then the repository should not contain employees with name "John"