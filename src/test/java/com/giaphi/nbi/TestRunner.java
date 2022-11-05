package com.giaphi.nbi;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = { "src/test/java/com/giaphi/nbi/features" },
    glue = { "com.giaphi.nbi.steps" },
    plugin = {
        "pretty",
        "html:reports"
    },
    monochrome = true
)
public class TestRunner {
}
