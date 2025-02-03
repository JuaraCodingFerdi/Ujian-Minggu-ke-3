package com.belajartestng.drivers.strategies;

import com.belajartestng.drivers.managers.ChromeDriverManager;
import com.belajartestng.drivers.managers.FirefoxDriverManager;
import com.belajartestng.drivers.managers.EdgeDriverManager;
import com.belajartestng.drivers.utils.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverStrategyImplementer implements IDriverStrategy {

    @Override
    public WebDriver setStrategy(String strategy) {
        switch (strategy) {
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
            case BrowserType.FIREFOX:
                return FirefoxDriverManager.make();
            case BrowserType.EDGE:
                return EdgeDriverManager.make();
            default:
                return ChromeDriverManager.make();

        }
    }
}
