package com.automation.herokuapp

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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.*
import com.common.util.commonActions as actions
import com.common.util.waitUtility as wait
import internal.GlobalVariable as GVar

public class HomePageModule {
	private static WebDriver driver = DriverFactory.getWebDriver()
	
	@Keyword
	public static void getLink() {
		try {
			
			WebDriver driver = DriverFactory.getWebDriver()
			List<WebElement>link=driver.findElements(By.tagName("a"))
			int count= link.size()
			actions.userComment("Number of link available: "+count)
			for (int i=1;i<count;i++) {
				WebElement ele=link.get(i)
				String linkName=ele.getText()
				String linkhref=ele.getAttribute("href")
				actions.userComment(i+": Linke Name:  "+linkName)
				actions.userComment(i+" : Link href:  "+linkhref)
			}
			actions.userComment("User get the all link")
			
		} catch (Exception e) {
			actions.userComment("Unable to get the all link")
			WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)
			throw new Exception()
		}
	}
	
	@Keyword
	public static void brokenLink() {
		try {
			
			WebDriver driver = DriverFactory.getWebDriver()
			List<WebElement>link=driver.findElements(By.tagName("a"))
			int count= link.size()
			int brokenlink=0
			actions.userComment("Number of link available: "+count)
			for (WebElement ele:link) {
				String url=ele.getAttribute("href")
				if(url==null || url.isEmpty()) {
					actions.userComment("No URL available Empty")
				}
				URL links=new URL(url)
				HttpURLConnection httpcon=(HttpURLConnection)links.openConnection()
				httpcon.connect()
				if(httpcon.getResponseCode()>=400) {
					actions.userComment(httpcon.getResponseCode()+":"+url+ ": Broken Link")
					brokenlink++;
				}
				else {
					actions.userComment(httpcon.getResponseCode()+":"+url+ ": Valid Link ")
				}
			}
			actions.userComment("No of broken link: "+brokenlink)
			actions.userComment("user verified broken links")
		} catch (Exception e) {
			actions.userComment("Unable to verify broken link")
			WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)
			throw new Exception()
		}
	}
	
	@Keyword
	public static void navigateToFirstLink() {
		try {
			WebUI.waitForElementPresent(findTestObject('Object Repository/HerokuApp/firstLink'), 2, FailureHandling.STOP_ON_FAILURE)
			WebUI.click(findTestObject('Object Repository/HerokuApp/firstLink'))
			actions.userComment("User Navigated to First Link")
			
			
		} catch (Exception e) {
			actions.userComment("Unable to navigate to first link")
			WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)
			throw new Exception()
		}
	}
	
	@Keyword
	public static void verifyElementOnLink() {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			List<WebElement>link=driver.findElements(By.tagName("a"))
			int count= link.size()
			actions.userComment("Number of link available: "+count)
			for (int i=1;i<count;i++) {
				WebElement ele=link.get(i)
				String linkName=ele.getText()
				String linkhref=ele.getAttribute("href")
				actions.userComment(i+": Linke Name:  "+linkName)
				actions.userComment(i+" : Link href:  "+linkhref)
			}
			actions.userComment("User get the all link")
			String title=driver.getTitle()
			actions.userComment("Title of the page: "+title)
			WebUI.waitForElementPresent(findTestObject('Object Repository/HerokuApp/txtlink'),2,FailureHandling.STOP_ON_FAILURE )
			String txt=WebUI.getText(findTestObject('Object Repository/HerokuApp/txtlink'))
			actions.userComment("Text Present on Link: "+txt)
			
		} catch (Exception e) {
			actions.userComment("Unable to verify the element on link")
			WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)
			throw new Exception()
		}
	}
	
	@Keyword
	public static void navigateToAuthLink() {
		try {
			WebUI.waitForElementPresent(findTestObject('Object Repository/HerokuApp/linkAuth'),2,FailureHandling.STOP_ON_FAILURE )
			String Text=WebUI.getText(findTestObject('Object Repository/HerokuApp/linkAuth'))
			actions.userComment("Link Text: "+Text)
			if(Text.equals("Basic Auth")) {
				WebUI.navigateToUrl(GVar.G_Auth_URL)
				actions.userComment("User clicke on Auth ;Link")
 			}
			else {
				actions.userComment("No Auth Match link present")
			}
			
			
		} catch (Exception e) {
			actions.userComment("Unable to navigate to auth link")
			WebUI.takeScreenshot(FailureHandling.STOP_ON_FAILURE)
			throw new Exception()
		}
	}
	
}
