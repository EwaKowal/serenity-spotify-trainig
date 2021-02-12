package pl.serenity.training.steps;

import net.thucydides.core.annotations.Step;
import pl.serenity.training.pages.MainPage;

public class YearSummarySteps {

    private MainPage mainPage;

    @Step("Show music year summary")
    public void showYearSummary() {
        mainPage.openMainPage();
        mainPage.acceptCookies();
        mainPage.clickShowSummary();
    }
}
