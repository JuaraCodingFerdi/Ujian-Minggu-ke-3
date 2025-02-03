package com.belajartestng.authentication;

import com.belajartestng.drivers.strategies.DriverStrategyImplementer;
import com.belajartestng.pages.authentications.SigninPageAdmin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTestAdmin {
    private WebDriver driver;
    private SigninPageAdmin signinPage;

    @BeforeMethod
    public void setUp() {
        // Menggunakan DriverStrategyImplementer untuk menentukan driver berdasarkan browser
        DriverStrategyImplementer driverStrategy = new DriverStrategyImplementer();
        driver = driverStrategy.setStrategy("edge"); // Ganti dengan "chrome" atau "firefox" jika perlu
        driver.manage().window().maximize();
        signinPage = new SigninPageAdmin(driver);
    }

    @Test
    public void signInPositiveTest() throws InterruptedException {
        System.out.println("Memulai tes login positif...");
        driver.get("http://localhost:8000/admin");

        // Panggil fungsi sign-in dengan kredensial yang benar
        signinPage.signIn("admin", "123");

        Thread.sleep(5000); // Tunggu sebentar untuk simulasi

        String actual = signinPage.getHeaderText();
        String expected = "Welcome to Demo SQA Testing Portal";

        Assert.assertEquals(actual, expected);
        System.out.println("Tes login positif selesai.");
    }

    @Test
    public void signInNegativeTest_InvalidCredentials() {
        System.out.println("Memulai tes login negatif...");
        driver.get("http://localhost:8000/admin");

        // Panggil fungsi sign-in dengan kredensial yang salah
        signinPage.signIn("wrong_user", "wrong_password");

        String actualErrorMessage = signinPage.getErrorMessage();
        String expectedErrorMessage = "Please enter the correct username and password for a staff account. Note that both fields may be case-sensitive.";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        System.out.println("Tes login negatif selesai.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Tutup browser
        }
    }

    // Method untuk mengakses driver dari luar kelas ini
    public WebDriver getDriver() {
        return driver;
    }

    // Method untuk login dari luar kelas ini
    public void signIn(String username, String password) {
        signinPage.signIn(username, password);
    }
}
