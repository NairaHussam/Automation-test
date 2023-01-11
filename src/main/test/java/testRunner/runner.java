package testRunner;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class runner {

        @RunWith(Cucumber.class)
        @CucumberOptions
                (
                        features = "src/main/resources/features",
                        glue = "StepDefinition",
                        tags = "@smoke",
                        plugin = {"pretty",
                                "html:target/cucumber.html",
                                "json:target/cucumber.json",
                                "junit:target/cukes.xml",
                                "rerun:target/rerun.txt"}

                )

        public class runners  {
        }
}