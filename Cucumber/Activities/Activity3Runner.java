package testRunner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;

import io.cucumber.junit.platform.engine.Constants;

@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
@ConfigurationParameter(
  key = Constants.GLUE_PROPERTY_NAME,
  value = "StepDefination")
@ConfigurationParameter(
		  key = Constants.FILTER_NAME_PROPERTY_NAME,
		  value = "Activity3")


public class Activity3Runner {

}
