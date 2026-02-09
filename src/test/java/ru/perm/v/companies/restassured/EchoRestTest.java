package ru.perm.v.companies.restassured;

import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

//Иерархия над методами (не на КЛАССЕ!)
//@Epic → @Feature → @Story):
//Пример:
//@Epic(value = "Математика")
//@Feature(value = "Простые математические операции")
//@Story(value = "Вычитание")

//Результаты ОДНИХ И ТЕХ ЖЕ ТЕСТОВ можно отразить в разных ветках. Аннотации размещать над МЕТОДАМИ.
//@Epics(value = {@Epic(value = "Математика"), @Epic(value = "Геометрия")})
//@Features(value = {@Feature(value = "Тригонометрия"), @Feature(value = "Простые математические операции")})
//@Stories(value = {@Story(value = "Синус"), @Story(value = "Синусоида")})

@DisplayName("Tests REST Echo")
public class EchoRestTest {

    private final static String ECHO_PATH = VARS.HOST + "echo/";

    @Epic("REST API Echo")
    @Feature("Verify Operations getMessage()")

    @DisplayName("Echo GET message is status=200")
    @Severity(SeverityLevel.NORMAL)
    @Description(value = "Verify the HTTP answer of Echo service is status=200")
    @Test
    public void getEchoIsStatusCode_200() {
        given().when().get(ECHO_PATH + "1").then().statusCode(HttpStatus.SC_OK);
    }

    @DisplayName("Echo GET message check body")
    @Severity(SeverityLevel.NORMAL)
    @Description(value = "Verify the HTTP answer Echo service message check body")
    @Test
    public void getEchoCheckMessage() {
        String message = "Message";
        given().pathParam("message", message).when()
                .get(ECHO_PATH + "{message}").then().body(is(String.format("%s", message)));
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
