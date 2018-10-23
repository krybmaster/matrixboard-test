package com.pflb.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By userNameLocator = By.id("login-username");
    private By passwordLocator = By.id("login-password");
    private By submitLocator = By.id("login-button");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://at.pflb.ru/matrixboard2");
    }

    public void fillUserName(String text) {
        driver.findElement(userNameLocator).sendKeys(text);
    }

    public void fillPassword(String text) {
        driver.findElement(passwordLocator).sendKeys(text);
    }

    public void submit() {
        driver.findElement(submitLocator).click();
    }
}
