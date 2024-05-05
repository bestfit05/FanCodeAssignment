package stepdefinitions;


import api.UserApi;
import api.TodoApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import pages.UserPage;
import pages.TodoPage;
import java.util.List;

public class UserTodoStepDefinitions {
    private UserPage userPage = new UserPage();
    private TodoPage todoPage = new TodoPage();
    private Response userResponse;
    private Response todoResponse;
    private List<Integer> userIdsInFanCodeCity;
    //private int userId;

    @Given("User with id {int} belongs to the city FanCode")
    public void userBelongsToFanCodeCity(Integer userId) {
        System.out.println("inside");

        userResponse = userPage.getUsers();
        userIdsInFanCodeCity = userResponse.jsonPath().getList("findAll { user -> user.id == " + userId + " && user.address.geo.lat >= -40 && user.address.geo.lat <= 5 " +
                "&& user.address.geo.lng >= 5 && user.address.geo.lng <= 100 }.id");
        Assert.assertFalse(userIdsInFanCodeCity.isEmpty(), "User with id " + userId + " does not belong to the FanCode city.");

    }

    @When("^User (.*) has the todo tasks$")
    public void userHasTodoTasks(String userID) {
        int userId = Integer.parseInt(userID);
        todoResponse = todoPage.getUserTodos(userId);
        Assert.assertTrue(todoResponse.jsonPath().getList("$").size() > 0, "User has no todo tasks.");
    }

    @Then("^User (.*) Completed task percentage should be greater than 50%$")
    public void verifyCompletedTaskPercentage(String userID) {
        int userId = Integer.parseInt(userID);
        List<Boolean> completedList = todoResponse.jsonPath().getList("findAll { todo -> todo.userId == " + userId + " }.completed");
        long completedCount = completedList.stream().filter(Boolean::booleanValue).count();
        double completedPercentage = (completedCount * 100.0) / completedList.size();

        Assert.assertTrue(completedPercentage > 50, "User " + userId + " has less than 50% completed tasks.");
    }


}
