package lv.iljapavlovs.cucumber.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lv.iljapavlovs.cucumber.config.ApplicationProperties;
import lv.iljapavlovs.cucumber.pageobjects.LoginPage;

import static lv.iljapavlovs.cucumber.config.ApplicationProperties.ApplicationProperty.TEST_USER_NAME;
import static lv.iljapavlovs.cucumber.config.ApplicationProperties.ApplicationProperty.TEST_USER_PASSWORD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LoginSteps {
    private LoginPage loginPage;

    @When("^Login - default user logs in$")
    public void userLogsInWithFollowingCredentials() throws Throwable {
        loginPage.login(ApplicationProperties.getString(TEST_USER_NAME), ApplicationProperties.getString(TEST_USER_PASSWORD));
    }

    @Then("^Login - is displayed$")
    public void loginIsDisplayed() throws Throwable {
        loginPage = new LoginPage();
        assertThat(loginPage.isPageDisplayed()).isTrue();
    }
}
