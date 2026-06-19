package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int counter = 0;
	int retrylimit = 3;
	
	public boolean retry(ITestResult result) {
		
		if(counter<retrylimit) {
			counter++;
			return true;
		}
		
		return false;
	}
}
