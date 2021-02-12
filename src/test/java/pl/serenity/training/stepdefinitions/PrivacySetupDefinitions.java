package pl.serenity.training.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pl.serenity.training.steps.HomeSteps;
import pl.serenity.training.steps.LoginSteps;
import pl.serenity.training.steps.PrivacySetupSteps;

public class PrivacySetupDefinitions {
    @Steps
    private PrivacySetupSteps privacySetupSteps;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private HomeSteps homeSteps;

    @Given("Login as '{login}' with password '{password}'")
    public void login(String login, String password) {
        loginSteps.login(login, password);
        homeSteps.acceptCookies();
        homeSteps.clickDismiss();
    }

    @When("Go to privacy settings account options")
    public void goToPrivacySettingsAccountOptions() {
        homeSteps.openAccountDetails();
        privacySetupSteps.goToPrivacySettingsAccountOptions();
    }

    @When("Turn off Facebook data interaction")
    public void turnOffFacebookDataInteraction() {
        privacySetupSteps.turnOffFacebookDataInteraction();
    }

    @When("Turn on Facebook data interaction")
    public void turnOnFacebookDataInteraction() {
        privacySetupSteps.turnOnFacebookDataInteraction();
    }

    @Then("Check if Facebook data integration is off")
    public void checkIfFacebookDataIntegrationIsOff() {
        privacySetupSteps.assertToggleColor("GREY");
    }

    @Then("Check if Facebook data integration is on")
    public void checkIfFacebookDataIntegrationIsOn() {
        privacySetupSteps.assertToggleColor("GREEN");
    }
}
