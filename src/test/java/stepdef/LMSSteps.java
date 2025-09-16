package stepdef;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LMSPage;
import org.junit.Assert;

public class LMSSteps {
    private LMSPage lmsPage;

    public LMSSteps(){
        // ambil page object yang sudah dibuat di Hooks
        this.lmsPage = Hooks.lmsPage;
    }

    @Given("User open lms login page")
    public void userOpenLMSPage(){
        Assert.assertTrue(lmsPage.verifyLoginPage());

    }

    @When("User click username {string} and password {string}")
    public void userClickUsernameAndPassword(String username, String password) {
    lmsPage.enterUsername(username);
    lmsPage.enterPassword(password);
    lmsPage.clickLoginButton();
    }

    @And("User click login")
    public void userClickLogin() {
    }

    @Then("User succesfully login")
    public void userSuccesfullyLogin() {
    }

    @Given("User login with username {string} and password {string}")
    public void userLoginWithUsernameAndPassword(String userName, String password) {
        lmsPage.enterUsername(userName);
        lmsPage.enterPassword(password);
        lmsPage.clickLoginButton();
    }

    @When("User open task and complete task")
    public void userOpenTaskAndCompleteTask() {
    lmsPage.clickOpenDealTeamSetup();
    }
}
