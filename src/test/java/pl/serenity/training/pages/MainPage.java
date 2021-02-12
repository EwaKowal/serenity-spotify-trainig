package pl.serenity.training.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("")
public class MainPage extends PageObject {

    private static final String XPATH_LINK_LOGO_AON_LOGIN_PAGE = "//a[contains(@class,'spotify-logo')]";
    private static final String XPATH_BUTTON_ACCEPT_COOKIES_FILES = "//button[contains(text(),'Akceptuj pliki cookie')]";
    private static final String XPATH_BUTTON_ACCEPT_COOKIES = "//button[contains(text(),'Accept Cookies')]";
    @FindBy(xpath = "//a[contains(text(),'Zaloguj się')]")
    private WebElement linkLogin;
    @FindBy(xpath = "//a[contains(text(),'Zobacz Twoje podsumowanie')]")
    private WebElement linkShowSummary;

    @FindBy(xpath = XPATH_BUTTON_ACCEPT_COOKIES_FILES)
    private WebElement buttonAcceptCookiesFiles;

    @FindBy(xpath = XPATH_BUTTON_ACCEPT_COOKIES)
    private WebElement buttonAcceptCookies;

    public void clickLogin() {
        waitFor(linkLogin);
        linkLogin.click();
        By linkLogoAonLoginPage = By.xpath(XPATH_LINK_LOGO_AON_LOGIN_PAGE);
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.visibilityOfElementLocated(linkLogoAonLoginPage));
    }

    public void acceptCookiesFiles() {
        waitFor(XPATH_BUTTON_ACCEPT_COOKIES_FILES);
        buttonAcceptCookiesFiles.click();
    }

    public void acceptCookies() {
        waitFor(XPATH_BUTTON_ACCEPT_COOKIES);
        buttonAcceptCookies.click();
    }

    public void clickShowSummary() {
        new Actions(getDriver())
                .moveToElement(linkShowSummary)
                .perform();

        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//a[contains(text(),'Zobacz Twoje podsumowanie')]"))
                );
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        executor.executeScript("arguments[0].scrollIntoView({block: 'center'})", linkShowSummary);


        linkShowSummary.click();
    }

    public void openMainPage() {
        getDriver().get("https://www.spotify.com/pl/");
    }

}
