package countryKeyFiguresTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import countryKeyFiguresTest.pageObjects.CountryPage; // Page Object for Countries table page  
import countryKeyFiguresTest.pageObjects.WorldBankHomePage; // Page Object for web site's home page 

import countryKeyFiguresTest.shared.*; // misc utility classes

public class CountryKeyFiguresTest {

	static Logger logger = null;
	static InitWebDriver initWebDriver = null;
	static WorldBankHomePage worldBankHomePage = null;
	static CountryPage countryPage = null;
	ArrayList<Country> Countries = null; // country name & URL pairs, will be used to navigate to key value pairs
	
	static String [][] TopThreeCountries = new String[3][4]; // will store top three country key values

	@Before
	public static void SetUp()  throws IOException {
		logger = new Logger();
		logger.LogMessage("Starting Country Key Figures Test Suite", "stdout");
		
		initWebDriver = new InitWebDriver();	
	}
	
	@Given ("^On Country Table Page$")
	// test case prerequisites, navigate to high income country list page 
	public void gotoCountryTablePage () {	
		worldBankHomePage = PageFactory.initElements(initWebDriver.GetDriver(), WorldBankHomePage.class); // Test Step #1
		
		worldBankHomePage.gotoData(); // Test Step #2
		worldBankHomePage.gotoByCountry(); // Test Step #3
		worldBankHomePage.gotoHighIncome(); // Test Step #4
	}
	
	@When ("^Got Country Key Figures$")
	public void getCountryKeyFigures () {		
		
		Countries = worldBankHomePage.getCountries();
		
		countryPage = PageFactory.initElements(initWebDriver.GetDriver(), CountryPage.class);		
		
		int i=0, j=0;

		// Test Steps #5-8
		for (Country currCountry : Countries) {	
			
			countryPage.openCountryPage(currCountry.getCountryURL()); // navigation back does not work, have to open the page every time
			
			// reading actual values
			if ((i<5)&&((i++%2)==0)){
				TopThreeCountries[j][0] = currCountry.getCountryName();
				TopThreeCountries[j][1] = countryPage.getGDP();
				TopThreeCountries[j][2] = countryPage.getPopulation();
				TopThreeCountries[j++][3] = countryPage.getCO2();
			} else if (!(i<5))  { 
				countryPage.getGDP();
				countryPage.getPopulation();
				countryPage.getCO2();
			}
		}
	}
	@Then ("^Validate Country Key Figures$")
	public void validateCountryKeyFigures (DataTable table) {
		
		List<List<String>> TopThreeCountries_values_expected = table.raw();
		
		for (int j=1, n=0;j<4;j++){	
			for (int i=0;i<3;i++, n++) {
				assertEquals(TopThreeCountries_values_expected.get(n).get(1), TopThreeCountries[i][j]);
			}
		}	
	}
	
	@After
	public void CloseAndLogResults () {
		countryPage.gotoHome(); // Test Step #9
		initWebDriver.GetDriver().quit(); // Test Step #10		
	
		// Test Steps #11-13
		logger.LogResults(TopThreeCountries, "GDP", "stdout"); 
		logger.LogResults(TopThreeCountries, "Population", "stdout");
		logger.LogResults(TopThreeCountries, "CO2", "stdout");
		
		// Test Step #14
		logger.LogResults(TopThreeCountries, "GDP", "file");
		logger.LogResults(TopThreeCountries, "Population", "file");
		logger.LogResults(TopThreeCountries, "CO2", "file");
		
		logger.LogMessage("Country Key Figures Test Suite finished", "stdout");	
	}				
}

