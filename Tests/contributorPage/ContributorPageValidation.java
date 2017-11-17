/**
 * Check Contributor Home page
 * Check on Contributor Image & Name
 * Click on Follow button
 * Click on Full Bio
 * Click on Show More

 */

package contributorPage;

import objectsRepository.OR;
import iSAFE.ApplicationKeywords;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ContributorPageValidation.
  */
public class ContributorPageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Contributor Page Validation
	// Created by :Shakira
	// Created on :6 June 2016

	// ///////////////////////////////////////////////////////////////////////////////
	/** The obj. */
	BaseClass obj;

	/**
	 * Instantiates a new contributor page validation.
	 *
	 * @param obj the obj
	 */
	public ContributorPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new contributor page validation.
	 */
	public ContributorPageValidation() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate contributor page.
	 */
	public void validateContributorPage() {
		testStepInfo("************************************************** Contributor Page ****************************************************");
		
		if (currentExecutionMachineName.startsWith("Desktop"))
		{
			clickOnMainArticle();
			clickOn(OR.img_Article_Page_Contributor);
			verifyAuthorName();
			clickOnBackButton();
			clickOn(OR.txt_Article_Page_Author_Name);
			verifyAuthorName();
			
			// clickOnBackButton();
			verifyFullBio();
			verifyFollowInDeskyop();
			verifyShowMoreInDesktop();

		}
		else
		{
		
			clickOnMainArticle();
			clickOn(OR.txt_Mob_Contributor_Page_Article);
			verifyContributorDetailsInMobile();
			verifyAuthorNameInMobile();
			verifyFullBio();
			verifyFollowInMobile();
			verifyNewPostsInMobile();
			verifyShowMoreInMobile();
		}
		
	}

	/**
	 * Verify author name.
	 */
	public void verifyAuthorName() {
		try {
			boolean authorName = elementPresent(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
			if (authorName == true) {
				String contributor = getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);

				testStepPassed("Navigated to Contributor Page--" + contributor);
				//clickOnBackButton();
			} else {
				testStepPassed("Failed to navigate to the author page");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void verifyFullBio()
	{
		testStepInfo("******************************************** Full Bio *******************************************************");
		try {
			waitTime(3);
			boolean varFullBio=elementPresent(OR.btn_Contributor_Page_Full_Bio);
			if (varFullBio==true) {
				testStepPassed("Full Bio is displayed");
				clickOn(OR.btn_Contributor_Page_Full_Bio);
				String fullBio = getText(OR.txt_Contributor_Page_Full_Bio_Details);
				testStepPassed(fullBio);
				clickOn(OR.btn_Contributor_Page_Full_Bio);
				
			}
			else {
			testStepPassed("Full Bio is not displayed ");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void verifyFollowInDeskyop()
	{
		testStepInfo("******************************************** Follow *******************************************************");
		try {
			boolean follow=elementPresent(OR.btn_Contributor_Page_Follow);
			if(follow==true)
			{
			mouseOver(OR.btn_Contributor_Page_Follow);
			testStepPassed("Follow is displayed");
			manualScreenshot(OR.btn_Contributor_Page_Follow);
			}
			else
			{
				testStepPassed("Follow is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void verifyShowMoreInDesktop()
	{
		testStepInfo("******************************************** Show More *******************************************************");
		try {
			//waitForElement(OR.btn_Contributor_Page_Show_More);
			scrollBy(0, 300);
		//	scrollToElement(OR.btn_Contributor_Page_Show_More);
			waitTime(3);
			boolean showMore=elementPresent(OR.btn_Contributor_Page_Show_More);
			if (showMore==true)
			{
			
				clickOn(OR.btn_Contributor_Page_Show_More);
				testStepPassed("Show More button is displayed");
			}
			else
			{
				testStepPassed("Show More button is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Author : Shakira
	 * Created on : 23 June 2016
	 * 
	 */
	public void verifyContributorDetailsInMobile()
	{
		testStepInfo("************************************* Contributor Details ************************************************");
		try {
			waitTime(3);
			boolean authorName=elementPresent(OR.txt_Mob_Contributor_Page_Author_Name);
			if(authorName==true)
			{
				testStepPassed("Author name is displayed");
				clickOn(OR.txt_Mob_Contributor_Page_Author_Name);
			}
			else
			{
				testStepPassed("Author name is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void verifyFollowInMobile()
	{
		testStepInfo("******************************************** Follow *******************************************************");
		try {
			boolean follow=elementPresent(OR.btn_Contributor_Page_Follow);
			if (follow==true) {
				testStepPassed("Follow button is displayed");
				clickOn(OR.btn_Contributor_Page_Follow);
				boolean socialShare=elementPresent(OR.img_Mob_Contributor_Page_Social_Share);
				if (socialShare==true) {
					testStepPassed("Social Shares are displayed");
					clickOn(OR.btn_Mob_Contributor_Page_Close);
				}
				else
				{
					testStepPassed("Social Shares are not displayed");
				}
				
			}
			else
			{
				testStepPassed("Follow button is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void verifyAuthorNameInMobile()
	{
		try {
			boolean auhtorImage=elementPresent(OR.img_Mob_Contributor_Page_Author_Image);
			if(auhtorImage==true)
			{
				testStepPassed("Author image is displayed");
			}
			else
			{
				testStepPassed("Author image is not displayed");
			}
			
			
			boolean author=elementPresent(OR.txt_Mob_Contributor_Page_Author);
			if (author==true) {
				String authorName=getText(OR.txt_Mob_Contributor_Page_Author);
				testStepPassed("Author Name is ---"+authorName);
				testStepPassed("Author Name is displayed");
			}
			else
			{
				testStepPassed("Author Name is not displayed");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Created On : 24 June 2016
	 */
	
	public void verifyNewPostsInMobile()
	{
		
		try {
			scrollToElement(OR.tab_Mob_Contributor_Page_Posts_Latest);
			scrollBy(0, -60);
			waitTime(3);
			boolean latest=elementPresent(OR.tab_Mob_Contributor_Page_Posts_Latest);
			if(latest==true)
			{
				testStepPassed("Latest tab is displayed");	
				
			}
			else
			{
				testStepPassed("Latest tab is not displayed");	
			}
			//scrollBy(0, 200);
			boolean archive=elementPresent(OR.tab_Mob_Contributor_Page_Posts_Archive);
			if (archive==true) {
				clickOn(OR.tab_Mob_Contributor_Page_Posts_Archive);
				testStepPassed("Archive tab is displayed");
			}
			else
			{
				testStepPassed("Archive tab is not displayed");	
			}
			waitTime(2);
			clickOn(OR.tab_Mob_Contributor_Page_Posts_Latest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void verifyShowMoreInMobile()
	{
		testStepInfo("******************************************** Show More *******************************************************");
		try {
			
			waitTime(3);
			scrollBy(0, 100);
			takeAdScreenshot(OR.btn_Contributor_Page_Show_More, "Show more");
			boolean showMore=elementPresent(OR.btn_Contributor_Page_Show_More);
			if (showMore==true)
			{
			
				clickOn(OR.btn_Contributor_Page_Show_More);
				testStepPassed("Show More button is displayed");
			}
			else
			{
				testStepPassed("Show More button is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
}
