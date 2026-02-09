package ru.perm.v.companies.restassured;

import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@DisplayName("Tests REST HelloWorldResource")
public class HelloResourceTest {

    private final static String Hello_PATH = VARS.HOST + "hello/";

    @Epic("REST API HelloWorldResource")
    @Feature("Verify Operations getMessage()")

    @DisplayName("Hello GET message is status=200")
    @Severity(SeverityLevel.NORMAL)
    @Description(value = "Verify the HTTP answer of Hello service is status=200")
    @Test
    public void getHelloIsStatusCode_200() {
        given().when().get(Hello_PATH + "1").then().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("Hello GET message check body")
    @Severity(SeverityLevel.NORMAL)
    @Description(value = "Verify the HTTP answer Hello service message check body")
    @Test
    public void getHelloCheckMessage() {
        String message = "Message";
        given().pathParam("message", message).when()
                .get(Hello_PATH + "{message}").then().body(is(String.format("%s", message)));
    }

// PathParam
//    @RequestMapping("/hi/{name}")
//    public String sayHello(@PathVariable("name") String name) {
//        return "Hi " + name;
//    }
//    @Test
//    public void shouldGetStringOfHi() {
//        String name = "QAShahin";
//        given()
//                .pathParam("name", name)
//                .when()
//                .get("hi/{name}")
//                .then()
//                .body(is(String.format("Hi %s", name)));
//    }

// https://www.thetestroom.com/2020/06/13/rest-assured-testing-using-request-parameters/
//    @Test
//    public void shouldGetPersonName() {
//        String name = "QAShahin";
//
//        given()
//                .param("name", name)
//                .when()
//                .get("/hello")
//                .then()
//                .body("name", is(name));
//    }
}
