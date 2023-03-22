package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    @Given("an example scenario")
    public void anExampleScenario() {
        System.out.println("Step run: anExampleScenario");
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
        System.out.println("Step run: allStepDefinitionsAreImplemented");
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
        System.out.println("Step run: theScenarioPasses");
    }

}
