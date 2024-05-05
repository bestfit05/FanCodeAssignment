package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TodoApi {
    public Response getUserTodos(int userId) {
        return given().param("userId", userId).get("http://jsonplaceholder.typicode.com/todos");
    }
}
