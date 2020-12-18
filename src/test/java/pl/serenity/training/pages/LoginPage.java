package pl.serenity.training.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("")
public class LoginPage extends PageObject {

    public static final String BUTTON_LOGIN_XPATH = "//button[contains(@name,'login')]";
    public static final String AFTER_LOGIN_XPATH = "//span[contains(text(),'Profil')]";
    public static final String ACCEPT_ALL_BUTTON_XPATH = "//button[contains(text(),'Accept All')]";
    @FindBy(xpath = "//a[contains(@class,'btn-facebook')]")
    private WebElement linkContinueWithFacebook;
    @FindBy(id = "email")
    private WebElement inputEmail;
    @FindBy(id = "pass")
    private WebElement inputPass;
    @FindBy(xpath = BUTTON_LOGIN_XPATH)
    private WebElement buttonLogin;
    @FindBy(xpath = ACCEPT_ALL_BUTTON_XPATH)
    private WebElement buttonAcceptAll;

    public void loginThroughFacebook(String login, String password) {
        linkContinueWithFacebook.click();

        waitFor(ACCEPT_ALL_BUTTON_XPATH);
        buttonAcceptAll.click();
        inputEmail.clear();
        inputEmail.sendKeys(login);
        inputPass.clear();
        inputPass.sendKeys(password);
        buttonLogin.click();
        waitFor(AFTER_LOGIN_XPATH);
    }

    private void waitFor(String xpath) {
        By locator = By.xpath(xpath);
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(locator)
                );
    }

}
