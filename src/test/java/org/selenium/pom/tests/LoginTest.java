package org.selenium.pom.tests;

import org.selenium.pom.Models.User;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws Exception{
        User user = new User().
                setUserName("kftest2022@hotmail.com").
                setPassword("Yunus168");

        LoginPage loginPage = new LoginPage(getDriver()).load();
        loginPage.load();
        loginPage.login(user);


    }

}
