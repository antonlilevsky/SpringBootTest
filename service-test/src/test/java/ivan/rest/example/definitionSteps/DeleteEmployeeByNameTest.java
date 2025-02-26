import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class DeleteEmployeeByNameTest {

    @Test
    public void testDeleteEmployeeByName() {
        String nameToDelete = "John";
        // Delete employee by name
        Response deleteResponse = given()
            .when()
            .delete("/employee/byName/" + nameToDelete)
            .then()
            .extract()
            .response();

        // Verify deletion response
        assertThat(deleteResponse.getStatusCode()).isEqualTo(204);

        // Verify employee no longer exists
        Response getResponse = given()
            .when()
            .get("/employee")
            .then()
            .extract()
            .response();

        List<Employee> employees = getResponse.jsonPath().getList("", Employee.class);
        assertThat(employees).noneMatch(employee -> employee.getName().equals(nameToDelete));
    }
}