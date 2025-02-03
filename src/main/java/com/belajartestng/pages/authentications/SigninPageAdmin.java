package com.belajartestng.pages.authentications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SigninPageAdmin {
    private WebDriver driver;

    // Locator untuk elemen-elemen login
    private By usernameField = By.id("id_username");
    private By passwordField = By.id("id_password");
    private By loginButton = By.xpath("//*[@id='login-form']/div[3]/input");
    private By header = By.xpath("//*[@id='content']/h1");
    private By errorMessage = By.className("errornote");

    public SigninPageAdmin(WebDriver driver) {
        this.driver = driver;
    }

    // Method untuk melakukan login
    public void signIn(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fieldUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement fieldPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        fieldUsername.clear();
        fieldUsername.sendKeys(username);
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
        btnLogin.click();
    }

    // Method untuk mendapatkan teks header setelah login
    public String getHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        return headerElement.getText();
    }

    // Method untuk mendapatkan pesan error
    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElement.getText();
    }
}
