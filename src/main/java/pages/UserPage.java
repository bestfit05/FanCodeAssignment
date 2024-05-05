package pages;

import api.UserApi;
import io.restassured.response.Response;

public class UserPage {
    private UserApi userApi = new UserApi();

    public Response getUsers() {
        return userApi.getUsers();
    }
}
