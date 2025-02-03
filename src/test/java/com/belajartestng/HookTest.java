package com.belajartestng;

import com.belajartestng.drivers.DriverSingleton;
import com.belajartestng.drivers.utils.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class HookTest {

    @BeforeTest
    public void init() {
        System.out.println("init");
        DriverSingleton.getDriver(BrowserType.EDGE);
    }

    @AfterTest
    public void teardown() {
        System.out.println("teardown");
        DriverSingleton.quitDriver();
    }
}
