package pl.serenity.training.steps;

import net.thucydides.core.annotations.Step;
import pl.serenity.training.pages.HomePage;
import pl.serenity.training.pages.MainPage;

public class HomeSteps {
    private MainPage mainPage;
    private HomePage homePage;

    @Step
    public void acceptCookies() {
        mainPage.acceptCookies();
    }

    @Step
    public void clickDismiss() {
        homePage.clickDismiss();
    }

    @Step
    public void openAccountDetails() {
        homePage.clickButtonUserMenu();
        homePage.clickLinkAccount();
        homePage.switchTab(1);
    }
}
