package com.giaphi.nbi.tests;

import com.giaphi.nbi.poms.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private final LoginPage loginPage;

    public LoginTest() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin_HappyCase() {
        loginPage.usernameInput().sendKeys("z.d.r.a.v.k.o.stojkoski@gmail.com");
        loginPage.passwordInput().sendKeys("ThePassword01##!!");

        var confirmationModal = loginPage.clickLoginButton();
        Assert.assertTrue(confirmationModal.isDisplayed());
    }
}
