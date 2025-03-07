package SwagLabs.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	/**
	 * IretryAnalyzer is a interface, we have implementing the unimplemented methods.
	 * how many times, that failed testcases need to be rerun.To make sure, the testcases is passed or fail.
	 *  it only trigger, when testcase failed.
	 *  And we have to specify, in which testcase we feel, that would fail. where we explicitly tell, how many times it should rerun.
	 */

	
		
		int count = 0;
		int maxTry = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxTry) {
			count++;
			return true;
		}
		
		return false;
	}
	
	

}
