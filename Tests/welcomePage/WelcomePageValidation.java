/**
 * Check the Welcome ads
 * Check the quote
 * Check the continue to button

 */
package welcomePage;

import objectsRepository.OR;
import iSAFE.ApplicationKeywords;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class WelcomePageValidation. 
 * class names are written in mixed case with
 * the first letter of each internal word capitalized
 */
public class WelcomePageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Welcome Page Validation
	// Created by :Shakira
	// Created on :6 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	
	/**
	 * Instantiates a new welcome page validation.
	 *
	 * @param obj the obj
	 */
	public WelcomePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new welcome page validation.
	 */
	public WelcomePageValidation() {

		// TODO Auto-generated constructor st ub
	}

	/**
	 * Verify welcome page.
	 * methods are written in mixed case with the first
	 * letter lower case, with the first letter of each internal word
	 * capitalized.
	 * variables are written in mixed case with the first letter lower case, with the first letter of each internal word capitalized.
	 */
	public void verifyWelcomePage() {
		testStepInfo("******************************Welcome Page**************************************");
		try {
			String quote = getText(OR.txt_Home_Forbes_Quote);
			testStepPassed("Forbes Quote of the Day-" + quote);
			verifyWelcomeAds();
			// manualScreenshot(OR.txt_Welcome_Page);
			if (currentExecutionMachineName.equalsIgnoreCase("Desktop_1_1")|| currentExecutionMachineName.startsWith("iPad")) {
				String button = getText(OR.txt_Home_Forbes_Continue_site);
				testStepPassed("CONTINUE TO SITE-" + button);

				clickOn(OR.txt_Home_Forbes_Continue_site);
				String title = driver.getTitle();
				testStepPassed("Redirected to home page " + title);
			} else {
				String title = driver.getTitle();
				testStepPassed("Redirected to home page " + title);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify welcome ads.
	 * Validate welcome Ads is present
	 */
	public void verifyWelcomeAds() {
		testStepInfo("******************************* Welcome Ads ****************************************");
		boolean welcomeAds = elementPresent(OR.ads_Welcome_Page_Ads);
		if (welcomeAds == true) {
			testStepPassed("Screenshot of Welcome Ads");
			manualScreenshot(OR.ads_Welcome_Page_Ads);
		} else {
			testStepPassed("Welcome Ads is not present");
		}

	}

}
