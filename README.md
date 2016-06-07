**This is an example of using Cucumber test automation framework**

**Pre-requisites:**
* Eclipse Mars
* JRE 1.7+, jars from "lib" added to Project Properties -> Libraries, JAVA_HOME environment variable should point to its root dir
* Selenium 2.53: selenium-release.storage.googleapis.com/2.53, jars (also from "lib") added to Project Properties -> Libraries
* IE Driver: selenium-release.storage.googleapis.com/2.53/IEDriverServer_x64_2.53.1.zip, should be unzipped into .\utils sub-directory
* JUnit 4.12, mvnrepository.com/artifact/junit/junit/4.11, path to the jar added to CLASSPATH, JUNIT_HOME environment variable should point to its root dir
* Cucumber jars, mvnrepository.com, added to Project Properties -> Libraries:
  - cucumber-core 1.2.4, cucumber-html 0.2.3, cucumber-java 1.2.4, cucumber-junit 1.2.4, cucumber-jvm-deps 1.0.3, gherkin 2.12.2 
* Cucumber eclipse plug-in: cucumber.github.com/cucumber-eclipse/update-site

**Project description**

1) Configuration: .\resources\config.properties:
* uncomment the one you need (comment the other one)

2) Main file: CountryKeyFiguresTest.feature, here is the summary of what it does:
  -  Goto worldbank.org -> Data -> By Country -> High Income:
     - get for each country: GDP, Population, CO2
  - Go home, close browser
  - For top 3 countries:
     - perform validation 
     - log GDP, Population, CO2 per country to stdout
     - export GDP, Population, CO2 per country to csv files in .\out sub-dir   

**How to run**
* Make sure pre-requisites mentioned above are in place
* Navigate to CountryKeyFiguresTest.feature, Run -> Run (Ctrl+F11)

