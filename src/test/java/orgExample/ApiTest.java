package orgExample;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {
    @Test
    void testGetUsers(){
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }
    /*
    Задача 3. Проверка конкретных данных
Напиши тест testSingleUser. Запроси https://jsonplaceholder.typicode.com/users/1 и проверь:
id равен 1.
name равно "Leanne Graham".
username равно "Bret".
     */
    @Test
    void testSingleUser(){
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .body("id", equalTo(1))
                .body("name",equalTo("Leanne Graham"))
                .body("username", equalTo("Bret"));
    }
    /*
    Задача 4. Проверка вложенных полей

Запроси https://jsonplaceholder.typicode.com/users/1 и проверь:

город (address.city) равно "Gwenborough".
индекс (address.zipcode) равно "92998-3874".
     */void checkFields(){
         given()
                 .when()
                 .get("https://jsonplaceholder.typicode.com/users/1")
                 .then()
                 .body("adress.city",equalTo("Gwenborough"))
                 .body("address.zipcode", equalTo("92998-3874"));
    }
    @Test
    void negativeTest(){
         given()
                 .when()
                 .get("https://jsonplaceholder.typicode.com/users/9999")
                 .then()
                 .statusCode(404);
    }
}
