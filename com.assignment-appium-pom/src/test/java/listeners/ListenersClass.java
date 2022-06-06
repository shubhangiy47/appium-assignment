package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportGenerator;

public class ListenersClass extends ReportGenerator implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("The test has Started");
		
	}
	
	public void onTestSuccess(ITestResult result) {
	
		test.log(LogStatus.PASS, "The test case has Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, "The test case has failed");
	}
	
	
	public void onFinish(ITestContext context) {
		reports.flush();
		reports.endTest(test);
	}

}
