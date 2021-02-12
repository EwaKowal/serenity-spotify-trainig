package pl.serenity.training.steps;

import net.thucydides.core.annotations.Step;
import pl.serenity.training.pages.AccountSettingsPage;
import pl.serenity.training.pages.PrivacySetupPage;

public class PrivacySetupSteps {
    private AccountSettingsPage accountSettingsPage;
    private PrivacySetupPage privacySetupPage;

    @Step
    public void goToPrivacySettingsAccountOptions() {
        accountSettingsPage.clickMenuOption("Ustawienia prywatności");
    }

    @Step
    public void turnOffFacebookDataInteraction() {
        privacySetupPage.clickToggle("Przetwarzaj moje dane z serwisu Facebook");
        privacySetupPage.clickButtonInDialog("Dane z serwisu Facebook", "Tak – wyłącz");
//        privacySetupPage.assertToggleColor("Przetwarzaj moje dane z serwisu Facebook", PrivacySetupPage.ToggleColor.GREY);
    }

    @Step("Assert toggle color {color}")
    public void assertToggleColor(String color) {
        PrivacySetupPage.ToggleColor colorEnum = PrivacySetupPage.ToggleColor.valueOf(color);
        privacySetupPage.assertToggleColor("Przetwarzaj moje dane z serwisu Facebook", colorEnum);
    }

    @Step
    public void turnOnFacebookDataInteraction() {
        privacySetupPage.clickToggle("Przetwarzaj moje dane z serwisu Facebook");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        privacySetupPage.assertToggleColor("Przetwarzaj moje dane z serwisu Facebook", PrivacySetupPage.ToggleColor.GREEN);
    }
}
