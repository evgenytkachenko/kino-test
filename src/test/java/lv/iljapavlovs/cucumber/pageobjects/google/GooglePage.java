package lv.iljapavlovs.cucumber.pageobjects.google;


import static lv.iljapavlovs.cucumber.config.ApplicationProperties.ApplicationProperty.APP_URL;
import static lv.iljapavlovs.cucumber.config.ApplicationProperties.ApplicationProperty.GOOGLE_URL;

import lv.iljapavlovs.cucumber.config.ApplicationProperties;
import lv.iljapavlovs.cucumber.core.WebElementHelper;
import lv.iljapavlovs.cucumber.pageobjects.base.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends Page {

    @FindBy(how = How.NAME, using = "q")
    private WebElement inputField;

    public GooglePage() {
        wait.until(ExpectedConditions.visibilityOf(inputField));
    }

    public static GooglePage navigate() {
        WebElementHelper.navigateToPage(ApplicationProperties.getString(GOOGLE_URL));
        return new GooglePage();
    }

    public GoogleSearchResultPage searchFor(String textToSearchFor) {
        WebElementHelper.sendKeys(inputField, textToSearchFor, Keys.ENTER);
        return new GoogleSearchResultPage();
    }

}