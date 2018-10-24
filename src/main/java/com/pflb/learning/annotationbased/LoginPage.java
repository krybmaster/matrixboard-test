package com.pflb.learning.annotationbased;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "login-username")
    private WebElement txtUsername;

    @FindBy(id = "login-password")
    private WebElement txtPassword;

    @FindBy(id = "login-button")
    private WebElement btnSubmit;

//    {
//        driver.get("http://at.pflb.ru/matrixboard2");
//    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        driver.get(url);
    }

    public LoginPage fillUserName(String text) {
        txtUsername.sendKeys(text);
        return this;
    }

    public LoginPage fillPassword(String text) {
        txtPassword.sendKeys(text);
        return this;
    }

    public void submit() {
        btnSubmit.click();
    }
}
