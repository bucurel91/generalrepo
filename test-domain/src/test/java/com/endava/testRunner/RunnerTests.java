package com.endava.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty:target/cucumber-pretty.txt" },
        features = {"src/test/resources/featureFiles"},
        glue = {"com.endava.stepsdefinition"},
        tags = {"@ibucur"},
        monochrome = true
)

public class RunnerTests {
}
