package com.application_name.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/application_name/step_definitions",
        plugin = {
                "html:target/rerun-default-cucumber-reports",
        }
)
public class FailedRunner {
}
