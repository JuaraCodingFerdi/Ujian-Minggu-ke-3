package com.belajartestng.drivers.managers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager {
    public static WebDriver make() {
        // Konfigurasi opsi untuk Microsoft Edge
        EdgeOptions options = new EdgeOptions();
        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"); // Path ke executable Edge
        options.addArguments("--start-maximized"); // Membuka browser dalam mode full screen

        // Mengembalikan instance WebDriver untuk Edge
        return new EdgeDriver(options);
    }
}
