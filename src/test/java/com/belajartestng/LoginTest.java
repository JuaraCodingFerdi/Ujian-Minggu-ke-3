package com.belajartestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private EdgeOptions options;

    @BeforeClass
    public void setup() {
        // Konfigurasi EdgeOptions
        options = new EdgeOptions();
        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"); // Path ke binary Edge
        driver = new EdgeDriver(options); // Inisialisasi EdgeDriver
        driver.manage().window().maximize();
        driver.get("http://localhost:8000/admin");
    }

    @Test
    public void siginTest() throws InterruptedException {
        WebElement fieldUsername = driver.findElement(By.id("id_username"));
        WebElement fieldPassword = driver.findElement(By.id("id_password"));
        WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input"));

        TimeUnit.SECONDS.sleep(1);
        fieldUsername.sendKeys("admin");
        TimeUnit.SECONDS.sleep(1);
        fieldPassword.sendKeys("123q");
        TimeUnit.SECONDS.sleep(1);
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expected = "Welcome to Demo SQA Testing Portal";
        String actual = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();

        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void closing() {
        if (driver != null) {
            driver.quit(); // Menggunakan quit() untuk menutup browser sepenuhnya
        }
    }
}
