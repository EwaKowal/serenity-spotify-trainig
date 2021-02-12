package pl.serenity.training.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pl.serenity.training.pages.HomePage;
import pl.serenity.training.pages.LoginPage;
import pl.serenity.training.pages.MainPage;

public class LoginSteps extends ScenarioSteps {
    LoginPage loginPage;
    MainPage mainPage;
    HomePage homePage;

    @Step("Login into server with email '{0}' and password '{1}'")
    public void login(String email, String passwod) {
        mainPage.openMainPage();
        mainPage.clickLogin();
        loginPage.loginThroughFacebook(email, passwod);
    }

    @Step("Logout from server")
    public void logout() {
        homePage.logout();
    }
}
