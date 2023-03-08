package runner;

import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters(
        {
                @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty"),
                @ConfigurationParameter(key=GLUE_PROPERTY_NAME, value = "steps")
        })
public class RunCucumberTest {
}
