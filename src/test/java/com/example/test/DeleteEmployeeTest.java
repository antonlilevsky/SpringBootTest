import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class DeleteEmployeeTest {

    @Test
    public void testDeleteEmployeeByName() {
        String employeeName = "John Doe";

        // Assuming the endpoint to delete an employee is /employees/delete
        given()
            .pathParam("name", employeeName)
        .when()
            .delete("/employees/delete/{name}")
        .then()
            .statusCode(200)
            .body("message", equalTo("Employee deleted successfully"));
    }
}