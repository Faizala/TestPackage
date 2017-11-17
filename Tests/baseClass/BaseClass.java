package baseClass;

import iSAFE.ApplicationKeywords;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseClass.
 */
public class BaseClass extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :
	// Purpose :
	// Parameters :
	// Return Value :
	// Created by :
	// Created on :
	// Remarks :
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new base class.
	 */
	public BaseClass() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Setup.
	 *
	 * @param machineName
	 *            the machine name
	 * @param host
	 *            the host
	 * @param port
	 *            the port
	 * @param browser
	 *            the browser
	 * @param os
	 *            the os
	 * @param browserVersion
	 *            the browser version
	 * @param osVersion
	 *            the os version
	 * @param sheetNo
	 *            the sheet no
	 */
	public void setup(String machineName, String host, String port,
			String browser, String os, String browserVersion, String osVersion,
			String sheetNo) {
		testDataSheetNo = Integer.parseInt(sheetNo);
		setEnvironmentTimeouts();

		openBrowser(machineName, host, port, browser, os, browserVersion,
				osVersion);
		testResultsFolder(machineName.replace(" ", ""), host, port, browser,
				os, browserVersion, osVersion);
		currentExecutionMachineName(machineName.replace(" ", ""));
	}

	/**
	 * Sets the environment timeouts.
	 */
	public void setEnvironmentTimeouts() {
		setTimeouts();
	}

	/**
	 * Close all sessions.
	 */
	public void closeAllSessions() {
		driver.quit();
	}

}
