import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class StackSteps {

    private Stack stacks;
    private Object object;



    @Given("^an empty stack$")
    public void an_empty_stack() throws Throwable {
     stacks = new Stack();

    }

    @When("^I push an item into the stack$")
    public void i_push_an_item_into_the_stack() {
        stacks = new Stack();
        object = new Object();
        stacks.push(object);

    }

    @Then("^the stack contains one item$")
    public void the_stack_contains_one_item() {
        assertEquals(1, stacks.size());
    }


}
