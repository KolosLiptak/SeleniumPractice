package org.epam.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class APITest {

    private String URL = "https://jsonplaceholder.typicode.com/users";
    private static final Logger logger = LogManager.getLogger(APITest.class);


    @Test
    public void verifyStatusCodeTest(){
        given()
                .when()
                .get(URL)
                .then()
                .assertThat()
                .statusCode(200);

        logger.info("Status code verified on thread {}", Thread.currentThread().threadId());
    }

    @Test
    public void verifyResponseHeaderTest(){

        String expectedHeader = "application/json; charset=utf-8";

        given()
                .when()
                .get(URL)
                .then()
                .assertThat()
                .statusCode(200)
                .header("Content-Type", equalTo(expectedHeader));

        logger.info("Header verified on thread {}", Thread.currentThread().threadId());
    }

    @Test
    public void verifyResponseBodyTest(){
        given()
                .when()
                .get(URL)
                .then()
                .assertThat()
                .statusCode(200)
                .body("", hasSize(10));

        logger.info("Body verified on thread {}", Thread.currentThread().threadId());
    }
}
