package ivan.rest.example.definitionSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class DeleteEmployeeByNameSteps {

    @Given("an employee with name {string} exists")
    public void an_employee_with_name_exists(String name) {
        // Code to add an employee with the given name
    }

    @When("I delete the employee with name {string}")
    public void i_delete_the_employee_with_name(String name) {
        // Code to delete the employee by name
    }

    @Then("the employee with name {string} should no longer exist in the system")
    public void the_employee_should_no_longer_exist(String name) {
        // Code to verify that the employee no longer exists
    }
}