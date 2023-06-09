package com.herokuapp.Common
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GVar
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
//import com.vv.util.waitUtility as wait
import org.testng.Assert


import com.common.util.commonActions as actions
import com.common.util.waitUtility as wait
import internal.GlobalVariable as GVar

class Herokuapp_LoginPage {
	@Keyword
	public static void launchUrl(){
		try{
			WebUI.openBrowser('')
			WebUI.navigateToUrl(GVar.G_web_URL)
			actions.userComment("Able to launch URL")
			actions.userComment("Launched URL is : "+GVar.G_web_URL)
			WebUI.maximizeWindow()
			actions.waitForLoading()

		}catch(Exception e){
			actions.userComment("Unable to launch URL")
			throw new RuntimeException(e.getMessage());
		}
	}

}