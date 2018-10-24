package com.pflb.learning.day7;

import com.pflb.learning.annotationbased.LoginPage;
import com.pflb.learning.annotationbased.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MatrixBoardTest {
    WebDriver driver = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        new LoginPage(driver)
                .fillUserName("user")
                .fillPassword("user")
                .submit();
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals("user", mainPage.getCurrentUser());
    }
}
