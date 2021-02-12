package pl.serenity.training.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AccountSettingsPage extends PageObject {
    private static final String XPATH_MENU_OPTION = "//div[contains(@class,'container')][not(contains(@class,'visible-xs'))]//a[contains(text(),'%s')]";

    public void clickMenuOption(String menuOption) {
        String xpath = String.format(XPATH_MENU_OPTION, menuOption);
        waitFor(xpath);
        WebElement element = getDriver().findElement(By.xpath(xpath));

        JavascriptExecutor je = (JavascriptExecutor) getDriver();
        je.executeScript("arguments[0].scrollIntoView({block: \"center\"})", element);

        element.click();
    }
}
