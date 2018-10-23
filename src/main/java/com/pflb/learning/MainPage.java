package com.pflb.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private By profileSelector = By.cssSelector("#profile span");
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(profileSelector));
        wait.until(drv -> {return drv.findElement(profileSelector).isDisplayed();});
    }

    public String getCurrentUser() {
        return driver.findElement(profileSelector).getText();
    }
}
