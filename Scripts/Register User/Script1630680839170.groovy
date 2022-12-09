import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Mengirim Request Pada Endpoint Get Single User'
GlobalVariable.response = WS.sendRequest(findTestObject('Get Single User'))

'Menyimpan Value Email'
GlobalVariable.email = WS.getElementPropertyValue(GlobalVariable.response, 'data.email')

'Mengirim Request Pada Endpoint Register'
GlobalVariable.regis = WS.sendRequest(findTestObject('Register'))

'Memastikan Response Status Code 200'
WS.verifyResponseStatusCode(GlobalVariable.regis, 200)

System.out.println(GlobalVariable.email)

'Memastikan Value dari data id yaitu 1'
WS.verifyElementPropertyValue(GlobalVariable.regis, 'id', 1)

'Memastikan Value dari data token yaitu QpwL5tke4Pnpja7X1'
WS.verifyElementPropertyValue(GlobalVariable.regis, 'token', 'QpwL5tke4Pnpja7X1')

