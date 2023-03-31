package com.restfulBookerPlatform.tests.step_defs;

import com.restfulBookerPlatform.tests.utilities.ConfigurationReader;
import com.restfulBookerPlatform.tests.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.*;

public class Hooks {

    @Before
    public void setUp() {
        String browser =ConfigurationReader.get("browser");

        if(!browser.contains(("mobile"))) {
            Driver.get().manage().window().maximize();
        }
        Driver.get().get(ConfigurationReader.get("mainPageUrl"));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver.closeDriver();
    }
}