package pl.serenity.training.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject {

    private static final String XPATH_LINK_LOGOUT = "//span[contains(text(),'Profil')]/ancestor::li//a[contains(text(),'Wyloguj się')]";
    private static final String XPATH_LINK_LOGIN = "//a[contains(text(),'Zaloguj się')]";
    private static final String JS_COMMAND_CLICK = "document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()";

    @FindBy(xpath = "//div[contains(@class,'mh-profile-title')]//ancestor::button")
    private WebElement buttonProfile;
    @FindBy(xpath = XPATH_LINK_LOGOUT)
    private WebElement buttonLogout;

    public void logout() {
        this.buttonProfile.click();
        waitFor(XPATH_LINK_LOGOUT);
        clickViaJs(XPATH_LINK_LOGOUT);
        waitFor(XPATH_LINK_LOGIN);
    }

    private void clickViaJs(String xpath) {
        JavascriptExecutor jsExec = (JavascriptExecutor) getDriver();
        jsExec.executeScript(JS_COMMAND_CLICK, xpath);
    }

    private void waitFor(String xpath) {
        By locator = By.xpath(xpath);
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(locator)
                );
    }
}
