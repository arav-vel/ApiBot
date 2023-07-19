package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(features = "src/test/java/features",
				 glue= {"steps", "hooks"},
				 monochrome = true,
				 snippets = SnippetType.CAMELCASE,
				 dryRun = false)
public class RunTests extends AbstractTestNGCucumberTests{

}
