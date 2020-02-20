package com.automation.tests.day2;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudTesting {
    public  AndroidDriver driver;
    public static String userName = "gokhanyigit1";
    public static String accessKey = "uLJLW3zyxvAA2KB96qsD";
    public static String URL="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
    private String email = "areatha@uspeakw.com";
    private String password = "Cybertek2020";

    @Test
    public void cloudTestingPixel4() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("device", "Google Pixel 4");
        desiredCapabilities.setCapability("os_version", "10.0");
        desiredCapabilities.setCapability("project", "Calculator");
        desiredCapabilities.setCapability("build", "My First Build");
        desiredCapabilities.setCapability("name", "Calculator Test");
        desiredCapabilities.setCapability("app", "bs://01d87ed510558757d8f480057081dbba2efcdb37");

        driver = new AndroidDriver<>(new URL(URL), desiredCapabilities);
//the biggest problem of selenium is synchronization.
        //basically, it doesn't wait
        //if element will delay to appear, you will get NoSuchElementException
        //to prevent this issue, we can use explicit wait
        //don't use explicit and implicit waits together!
        //how to use explicit wait in appium?
        //in the same way like in selenium
        WebDriverWait wait = new WebDriverWait(driver, 15);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.etsy.android:id/btn_link")));
        WebElement getStarted = driver.findElement(By.id("com.etsy.android:id/btn_link"));
        getStarted.click();

        //username input box
        WebElement usernameElement = driver.findElementById("com.etsy.android:id/edit_username");
        //password input box
        WebElement passwordElement = driver.findElementById("com.etsy.android:id/edit_password");
        //sign in button
        WebElement signinElement = driver.findElementById("com.etsy.android:id/button_signin");

        usernameElement.sendKeys(email);
        passwordElement.sendKeys(password);
        signinElement.click();

        /* Write your Custom code here */

        driver.quit();
    }

}
