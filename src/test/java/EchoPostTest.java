import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EchoPostTest {

    @Test
    void postShouldReturnSentData() {
        String sentData = "some data";

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(sentData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                // Здесь JSON-путь обращается к полю "data", которое содержит отправленное тело
                .body("data", equalTo(sentData));
    }


}