package org.epam.api;

import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CRUDTest {

    private String URL = "https://jsonplaceholder.typicode.com/users";
    private static final Logger logger = LogManager.getLogger(CRUDTest.class);

    String body = """
                 {
                  "name": "Leanne Graham",
                  "username": "Bret",
                  "email": "Sincere@april.biz",
                  "address": {
                    "street": "Kulas Light",
                    "suite": "Apt. 556",
                    "city": "Gwenborough",
                    "zipcode": "92998-3874",
                    "geo": {
                      "lat": "-37.3159",
                      "lng": "81.1496"
                    }
                  },
                  "phone": "1-770-736-8031 x56442",
                  "website": "hildegard.org",
                  "company": {
                    "name": "Romaguera-Crona",
                    "catchPhrase": "Multi-layered client-server neural-net",
                    "bs": "harness real-time e-markets"
                  }
                }
                """;

    @Test
    @Step
    public void createOperationTest(){

        given()
                .body(body)
                .when()
                .post(URL)
                .then()
                .statusCode(201)
                .body("id", equalTo(11));

        logger.info("New entry created with id 11");
    }

    @Test(dependsOnMethods = {"createOperationTest"})
    @Step
    public void updateOperationTest(){

        given()
                .body(body)
                .when()
                .put(URL + "/2")
                .then()
                .statusCode(200);

        logger.info("Updated entry with id 2");
    }

    @Test(dependsOnMethods = "updateOperationTest")
    @Step
    public void deleteOperationTest(){
        given()
                .when()
                .delete(URL + "/2")
                .then()
                .statusCode(200);

        logger.info("Deleted entry with id 2");
    }
}
