package com.pflb.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MatrixBoardTest {
    private WebDriver driver = null;
    private WebDriverWait wait = null;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void loginTest() {
        driver.get("http://at.pflb.ru/matrixboard2/");
        WebElement loginField = driver.findElement(By.id("login-username"));
        WebElement passwordField = driver.findElement(By.cssSelector("#login-password"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id='login-button']"));

        loginField.sendKeys("user");
        passwordField.sendKeys("user");
        submitButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#profile span")));
        WebElement userNameContainer = driver.findElement(By.cssSelector("#profile > a > span"));
        Assert.assertEquals("user", userNameContainer.getText());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
