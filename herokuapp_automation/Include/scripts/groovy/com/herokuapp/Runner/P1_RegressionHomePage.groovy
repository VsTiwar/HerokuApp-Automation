package com.herokuapp.Runner
import org.junit.runner.RunWith
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber

@RunWith(Cucumber.class)
@CucumberOptions(features="Include/features/HerokuAppFeature/HomePage/Regression", glue="", plugin = ["pretty",
	"junit:Reports/cucumber.xml",
	"html:Reports",
	"json:Reports/cucumber.json","rerun:Reports/rerun.txt"],tags=['@TC=C00003'])

class P1_RegressionHomePage {
	
}