package pl.serenity.training.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageObject {

    private static final String XPATH_LINK_LOGOUT = "//span[contains(text(),'Profil')]/ancestor::li//a[contains(text(),'Wyloguj się')]";
    private static final String XPATH_LINK_LOGIN = "//a[contains(text(),'Zaloguj się')]";
    private static final String JS_COMMAND_CLICK = "document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()";

    @FindBy(xpath = "//div[contains(@class,'mh-profile-title')]//ancestor::button")
    private WebElement buttonProfile;

    @FindBy(xpath = "//button[contains(text(),'Dismiss')]")
    private WebElementFacade buttonDismiss;

    @FindBy(xpath = "(//header//button)[last()]")
    private WebElementFacade buttonUserMenu;

    @FindBy(xpath = "//a[contains(text(),'Account')]")
    private WebElementFacade linkAccount;

    public void logout() {
        this.buttonProfile.click();
        waitFor(XPATH_LINK_LOGOUT);
        clickViaJs(XPATH_LINK_LOGOUT);
        waitFor(XPATH_LINK_LOGIN);
    }

    public void clickDismiss() {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.of(7, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(1, ChronoUnit.SECONDS))
                .ignoring(NoSuchElementException.class);

        try {
            wait.until(webDriver -> {
                if (buttonDismiss.isPresent() && buttonDismiss.isDisplayed()) {
                    buttonDismiss.click();
                    return true;
                }

                return false;
            });
        } catch (TimeoutException ex) {
            // ignore
        }
    }

    public void clickButtonUserMenu() {
        this.buttonUserMenu.click();
    }

    public void clickLinkAccount() {
        this.linkAccount.click();
    }

    public void switchTab(int i) {
        List<String> list = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(list.get(i));
    }

    private void clickViaJs(String xpath) {
        JavascriptExecutor jsExec = (JavascriptExecutor) getDriver();
        jsExec.executeScript(JS_COMMAND_CLICK, xpath);
    }
}
