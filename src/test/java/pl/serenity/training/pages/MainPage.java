package pl.serenity.training.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("")
public class MainPage extends PageObject {

    private static final String XPATH_LINK_LOGO_AON_LOGIN_PAGE = "//a[contains(@class,'spotify-logo')]";
    @FindBy(xpath = "//a[contains(text(),'Zaloguj się')]")
    private WebElement linkLogin;

    public void clickLogin() {
        linkLogin.click();
        By linkLogoAonLoginPage = By.xpath(XPATH_LINK_LOGO_AON_LOGIN_PAGE);
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.visibilityOfElementLocated(linkLogoAonLoginPage));
    }

    public void openMainPage() {
        getDriver().get("https://www.spotify.com/pl/");
    }
}
