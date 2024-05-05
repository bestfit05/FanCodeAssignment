package pages;

import api.TodoApi;
import io.restassured.response.Response;

public class TodoPage {
    private TodoApi todoApi = new TodoApi();

    public Response getUserTodos(int userId) {
        return todoApi.getUserTodos(userId);
    }
}
