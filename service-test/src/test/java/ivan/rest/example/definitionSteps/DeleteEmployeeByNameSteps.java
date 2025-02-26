package ivan.rest.example.definitionSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class DeleteEmployeeByNameSteps {

    // Mock repository for employees
    private Map<String, Employee> employeeRepository = new HashMap<>();

    @Given("the following employees exist in the repository:")
    public void theFollowingEmployeesExistInTheRepository(List<Map<String, String>> employees) {
        for (Map<String, String> employee : employees) {
            String name = employee.get("name");
            String passportNumber = employee.get("passportNumber");
            String education = employee.get("education");
            employeeRepository.put(name, new Employee(name, passportNumber, education));
        }
    }

    @When("I delete the employee with name {string}")
    public void iDeleteTheEmployeeWithName(String name) {
        employeeRepository.remove(name);
    }

    @Then("the employee with name {string} should not exist in the repository")
    public void theEmployeeWithNameShouldNotExistInTheRepository(String name) {
        assertFalse(employeeRepository.containsKey(name));
    }
}