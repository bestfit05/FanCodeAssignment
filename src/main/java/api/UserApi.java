package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    public Response getUsers() {
        return given().get("http://jsonplaceholder.typicode.com/users");
    }
}
