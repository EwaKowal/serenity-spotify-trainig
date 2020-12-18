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

    @Step("Login into server")
    public void login() {
        mainPage.openMainPage();
        mainPage.clickLogin();
        loginPage.loginThroughFacebook("serenity.test.ek@gmail.com", "RcAZqvHT6AI2lCcK!");
    }

    @Step("Logout from server")
    public void logout() {
        homePage.logout();
    }
}
