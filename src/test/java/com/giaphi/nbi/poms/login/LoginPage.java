package com.giaphi.nbi.poms.login;

import com.giaphi.nbi.poms.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver _driver) {
        super(_driver);
    }

    // Locators
    By byUsernameInput = By.id("input_0");
    By byPasswordInput = By.id("input_1");
    By byLoginButton = By.cssSelector("button[type='submit']");

    // Elements
    public WebElement usernameInput() { return getElement(byUsernameInput); }
    public WebElement passwordInput() { return getElement(byPasswordInput); }
    public WebElement loginButton() { return getElement(byLoginButton); }

    // Actions
    public ConfirmationModal login(String username, String password) {
        inputText(usernameInput(), username);
        inputText(passwordInput(), password);
        return clickLoginButton();
    }

    public ConfirmationModal clickLoginButton() {
        loginButton().click();
        return new ConfirmationModal(driver);
    }
}
