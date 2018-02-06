package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.SearchSteps;

public class SearchStepDefs {
    @Steps
    private SearchSteps searchSteps;

    @Given("^I am on main page$")
    public void openMainPage() {
        searchSteps.openMainPage();
    }

    @When("^I (?:enter|input) search request \"([^\"]*)\"$")
    public void inputSearchRequest(String request) {
        searchSteps.inputRequest(request);
    }

    @And("^I (?:submit|click on) search button$")
    public void submitSearchButton() {
        searchSteps.clickSearchButton();
    }

    @Then("^I should be on search page$")
    public void assertThatUserOnSearchPage() {
        searchSteps.assertThatUserOnSearchPage();
    }

    @And("^Page title should be equal to searched request \"([^\"]*)\"$")
    public void assertThatPageTitleEqualsToRequest(String request) {
        searchSteps.assertThatPageTitleEqualsToRequest(request);
    }
}
