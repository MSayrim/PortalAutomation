package org.selenium.pom.pages;

import groovy.util.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.Models.User;
import org.selenium.pom.base.BasePage;
import org.testng.Assert;
import org.testng.IResultMap;

public class LoginPage extends BasePage {

    private final By userNameFld = By.name("username");
    private final By passwordFld = By.name("password");
    private final By loginBtn = By.className("btn-success");
    private final By courselView = By.id("carouselNews");
    private final By failModal = By.id("mat-dialog-1");
    private final By modalDissmiss = By.className("btn-danger");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUserName(String userName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFld));
        e.clear();
        e.sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld));
        e.clear();
        e.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        return this;
    }

    private LoginPage waitForLoginBtnToDisappear() {


        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtn));
        return this;
    }

    public LoginPage login(User user) {

        return enterUserName(user.getUserName()).
                enterPassword(user.getPassword()).
                clickLoginBtn().waitForLoginBtnToDisappear();
    }

    public LoginPage load() {
        load("/");
        return this;
    }


}
