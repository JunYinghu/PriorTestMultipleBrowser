import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DemoTestStep {

    @Given("^User is on \"(.*)\" page$")
    public void user_on_page(String url) {
        SearchDemo.openUrl(url);
    }

    @When("^User enter \"(.*)\" in search box \"(.*)\"$")
    public void userEnterInSearchBox(String searchKeywords, String textBoxId) {
        SearchDemo.userEnterKeywords(searchKeywords, textBoxId);
    }

    @And("^User clicks on Search button \"(.*)\"$")
    public void userClicksOnSearchButton(String searchButtonId) {
        SearchDemo.clickOnSearchButton(searchButtonId);
    }

    @Then("^user should see \"(.*)\"$")
    public void userShouldSee(String expectedResult) {
        SearchDemo.userShouldSee(expectedResult);
    }


}

