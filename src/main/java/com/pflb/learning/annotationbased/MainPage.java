package com.pflb.learning.annotationbased;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
    @FindBy(css = "#profile span")
    private WebElement profileContainer;

    public MainPage(WebDriver driver) {
        super(driver);
        //wait.until(ExpectedConditions.presenceOfElementLocated(profileSelector));
        wait.until(drv -> {return profileContainer.isDisplayed();});
    }

    public String getCurrentUser() {
        return profileContainer.getText();
    }
}
