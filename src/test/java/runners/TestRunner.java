package runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "stepdefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {
}