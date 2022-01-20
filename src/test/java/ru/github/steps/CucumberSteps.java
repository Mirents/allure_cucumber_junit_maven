package ru.github.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberSteps {
    @Given("first step")
    public void firstStep() {
        System.out.println("First Step");
    }


    @When("second step")
    public void secondStep() {
        System.out.println("Second Step");
    }


    @Then("third step")
    public void thirdStep() {
        System.out.println("Third Step");
    }
}
