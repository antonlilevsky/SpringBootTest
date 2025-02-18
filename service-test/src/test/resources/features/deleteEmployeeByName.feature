@employee
@resetWireMock
Feature: Delete Employee by Name
  This feature contains BDD scenarios for deleting an employee from the repository by name

  Scenario Outline: 01 | Delete employee by name - happy path
    Given employees added to Employee rest service repository:
      | id  | name | passportNumber | education  |
      | 108 | Tom  | TM123456       | University |
      | 109 | Sam  | SM456789       | College    |
      | 110 | John | JN789123       | School     |
      | 111 | John | JN789123       | School     |
    And the entity is deleted from 'EXPECTED_RESULT' list by name = <employeeName> in test session

#    configure WireMock
    And the 'STUB_REQUEST' variable is initialized in test session with "null" value
    And the 'STUB_RESPONSE' variable is initialized in test session with "null" value
    And wiremock stub is set for DELETE request with "/externalClient/name/<employeeName>" URL

#    configure WireMock
    And the 'STUB_REQUEST' variable is initialized in test session with 'null' value
    And the 'STUB_RESPONSE' variable is created in test session
      | employeeHashValue | 12345 |
    And wiremock stub is set for GET request with "/externalClient/" URL

    When the DELETE request is sent to the '/employee/name/{name}' endpoint with params:
      | name | <employeeName> |
    Then the status code is 200
    And wiremock stub received DELETE request with "/externalClient/name/<employeeName>" URL
    And employee with name <employeeName> is deleted from the repository

    Examples:
      | employeeName |
      | Tom          |
      | Sam          |