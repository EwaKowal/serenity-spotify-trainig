package pl.serenity.training.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pl.serenity.training.steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {
    @Steps
    private LoginSteps loginSteps;

    @Managed
    private WebDriver driver;

    //    @Test
    public void loginAndLogout() {
        loginSteps.login("serenity.test.ek@gmail.com", "RcAZqvHT6AI2lCcK!");
        loginSteps.logout();
    }
}
