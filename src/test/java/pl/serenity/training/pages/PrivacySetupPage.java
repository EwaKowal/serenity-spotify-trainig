package pl.serenity.training.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PrivacySetupPage extends PageObject {
    private final String XPATH_PATTERN_TOGGLE = "//b[contains(text(),'%s')]/ancestor::div[contains(@class,'privacy-category-state-section')]//input";
    private final String XPATH_PATTERN_TOGGLE_SPAN = "//b[contains(text(),'%s')]/ancestor::div[contains(@class,'privacy-category-state-section')]//span";
    private final String XPATH_WINDOW_YES = "//h3[contains(text(),'%s')]//ancestor::div[contains(@class,'modal-content')]//button[contains(text(),'%s')]";

    public void clickToggle(String toggleText) {
        String xpath = String.format(XPATH_PATTERN_TOGGLE, toggleText);
        WebElement element = getDriver().findElement(By.xpath(xpath));
        JavascriptExecutor je = (JavascriptExecutor) getDriver();
        je.executeScript("arguments[0].scrollIntoView({block: \"center\"})", element);
//        waitFor(element);
        element.click();
    }

    public void clickButtonInDialog(String dialogHeader, String buttonText) {
        clickByXpathPattern(XPATH_WINDOW_YES, dialogHeader, buttonText);
    }

    public void assertToggleColor(String toggleText, ToggleColor expectedColor) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.of(7, ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(1, ChronoUnit.SECONDS))
                .ignoring(NoSuchElementException.class);

        try {
            wait.until(webDriver -> {
                String xpath = String.format(XPATH_PATTERN_TOGGLE_SPAN, toggleText);
                WebElement element = getDriver().findElement(By.xpath(xpath));
                String actual = element.getCssValue("background-color");

                return expectedColor.colorHex.equals(actual);
            });
        } catch (TimeoutException ex) {
            throw new AssertionError("Cannot detect color " + expectedColor, ex);
        }
    }

    private void clickByXpathPattern(String xpathPattern, Object... toggleText) {
        String xpath = String.format(xpathPattern, toggleText);
        waitFor(xpath);
        WebElement element = getDriver().findElement(By.xpath(xpath));
        element.click();
    }

    public enum ToggleColor {
        GREEN("rgba(30, 215, 96, 1)"),
        GREY("rgba(217, 218, 220, 1)");
        private final String colorHex;

        ToggleColor(String colorHex) {
            this.colorHex = colorHex;
        }
    }
}
