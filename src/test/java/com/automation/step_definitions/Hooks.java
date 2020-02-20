package com.automation.step_definitions;

import com.automation.utilities.Driver;
import org.junit.After;

public class Hooks {
    @After
    public void teardown() {
        Driver.closeDriver();
    }

}
