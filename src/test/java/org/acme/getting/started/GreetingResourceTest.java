package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {

        // MODO DEVELOPMENT ENVIRONMENT
        // given()
        //     .when().get("/hello")
        //     .then()
        //         .statusCode(200)
        //         .body(is("HolaDevelop"));

        // MODO PRODUCTION ENVIRONMENT
        // given()
        //     .when().get("/hello")
        //     .then()
        //         .statusCode(200)
        //         .body(is("Hola Mundo"));

        // MODO STAGING ENVIRONMENT
        given()
            .when().get("/hello")
            .then()
                .statusCode(200)
                .body(is("Aloha"));

    }

}