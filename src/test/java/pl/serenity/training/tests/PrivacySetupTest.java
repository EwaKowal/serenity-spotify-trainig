package pl.serenity.training.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import pl.serenity.training.steps.HomeSteps;
import pl.serenity.training.steps.LoginSteps;
import pl.serenity.training.steps.PrivacySetupSteps;

@RunWith(SerenityRunner.class)
public class PrivacySetupTest extends BaseTest {
    @Steps
    private PrivacySetupSteps privacySetupSteps;
    @Steps
    private HomeSteps homeSteps;
    @Steps
    private LoginSteps loginSteps;

    //    @Test
    public void testPrivacySetupTest() {
        loginSteps.login("serenity.test.ek@gmail.com", "RcAZqvHT6AI2lCcK!");
        homeSteps.acceptCookies();
        privacySetupSteps.goToPrivacySettingsAccountOptions();
        privacySetupSteps.turnOffFacebookDataInteraction();
        privacySetupSteps.turnOnFacebookDataInteraction();
    }
}
