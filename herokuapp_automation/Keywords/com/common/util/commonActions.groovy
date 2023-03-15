package com.common.util

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

public class commonActions {

	/**
	 * Check if element present in timeout
	 * @param to Katalon test object, timeout, FailureHandling.STOP_ON_FAILURE
	 * @return true if element present, otherwise false
	 */
	def static userComment(String message) {
		WebUI.comment(message)
		print(message)
	}

	def static waitForLoading(){
		try {
			long startTime = System.currentTimeMillis()
			//somethingWentWrongErr()
			boolean loadingcheck = WebUI.verifyElementVisible(findTestObject('Object Repository'), 20, FailureHandling.OPTIONAL)
			while(loadingcheck && ((System.currentTimeMillis()-startTime) < 120000)){
			loadingcheck = WebUI.verifyElementVisible(findTestObject('Object Repository'), 20, FailureHandling.OPTIONAL)
		}
		//somethingWentWrongErr()
		userComment("Loading time : "+(System.currentTimeMillis()-startTime)/1000 +" Seconds")
	}catch(Exception exp) {
		exp.getMessage()
	}
}
}
