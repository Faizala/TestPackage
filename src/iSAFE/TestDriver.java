package iSAFE;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;

import Utilities.Common;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDriver.
 */
public class TestDriver extends ApplicationKeywords {

	/**
	 * Instantiates a new test driver.
	 *
	 * @param obj
	 *            the obj
	 */
	public TestDriver(BaseClass obj) {
		super(obj);
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {

			Common common = new Common();
			common.startup();
			TestNG testng = new TestNG();
			List<String> suites = new ArrayList<String>();
			suites.add("./Config/testng.xml");
			testng.setOutputDirectory(outputDirectory + "/testng");
			testng.setTestSuites(suites);
			testng.run();

		} catch (Exception e) {
			writeToLogFile("error", e.toString());
		} finally {
			try {
				cleanup();
				sendMailOnFailure();
			} catch (Exception e) {
				writeToLogFile("error", e.toString());
			} finally {
				writeToLogFile("INFO", "###################################");
				writeToLogFile("INFO", "Script Execution Complete");
				writeToLogFile("INFO", "####################################");

			}

		}
	}

}