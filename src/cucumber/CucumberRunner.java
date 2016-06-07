package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)	
@CucumberOptions(
	plugin = {"pretty", "json/target/"},
	features = {"src/countryKeyFiguresTest/"}
)
public class CucumberRunner {

}
