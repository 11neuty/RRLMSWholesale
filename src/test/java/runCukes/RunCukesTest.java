package runCukes;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {
                "hooks",
                "stepdef"
        },
        features = {"classpath:features/"},
        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber/cucumber.json"},
        tags = "@test"
)

public class RunCukesTest {

}