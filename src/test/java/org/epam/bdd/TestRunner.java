package org.epam.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/org/epam/bdd/features",
        glue = "org.epam.bdd.stepdefinitions",
        tags = "@smoke or @saucedemo",
        plugin = "pretty"

)
public class TestRunner extends AbstractTestNGCucumberTests {
}
