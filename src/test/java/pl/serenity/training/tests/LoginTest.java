package pl.serenity.training.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pl.serenity.training.steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class LoginTest {
    @Steps
    LoginSteps loginSteps;

    @Managed
    WebDriver driver;

    @Test
    public void loginAndLogout() {
        loginSteps.login();
        loginSteps.logout();
    }
}
