package com.pflb.learning.annotationbased;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        //Explicit wait
        new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}
