package com.belajartestng.pages.authentications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    @FindBy(id = "id_username")
    WebElement usernameElement;

    @FindBy(id = "id_password")
    WebElement passwordElement;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement buttonSignInElement;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String username) {
        usernameElement.sendKeys(username);
    }

    public void fillPassword(String password) {
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        buttonSignInElement.click();
    }

    public void loginActivity(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLoginButton();
    }
}
