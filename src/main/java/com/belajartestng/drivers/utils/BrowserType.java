package com.belajartestng.drivers.utils;

public class BrowserType {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String EDGE = "edge";


    // mencegah instantiate
    private BrowserType() {
        throw new UnsupportedOperationException("This is a constant class and cannot be instantiate");
    }
}
