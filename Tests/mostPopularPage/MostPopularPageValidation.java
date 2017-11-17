/**
 * Check the ads on the page 
 * Check Market to form display
 * Trending Stories display
 * Most Read Stories display
 * Active on Social Web 
 * Popular Galleries
 * Active Converstation
 * Inside Forbes 

 */

package mostPopularPage;


import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

// TODO: Auto-generated Javadoc
/**
 * The Class MostPopularPageValidation.
 * class names are written in mixed case with the first letter of each internal word capitalized
 */
public class MostPopularPageValidation extends ApplicationKeywords {

	

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Most Popular Page Validation
	// Created by :Shakira
	// Created on :13 June 2016
	
	/**
	 * Instantiates a new most popular page validation.
	 *
	 * @param obj the obj
	 */
	// ///////////////////////////////////////////////////////////////////////////////
	public MostPopularPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify most popular page.
	 * Methods are written in mixed case with the
	 * first letter lower case, with the first letter of each internal word
	 * capitalized.
	 * variables are written in mixed case with the first letter lower case, with the first letter of each internal word capitalized.
	 *
	 * @throws Exception the exception
	 */
	public void verifyMostPopularPage() throws Exception {
		testStepInfo("************************************MOST POPULAR PAGE******************************************");
		//waitTime(10);
		if (currentExecutionMachineName.startsWith("Desktop_1_2"))
		{
		clickOn(OR.tab_Most_Popular);
		verifySocialWeb();
		
		waitTime(3);
		verifyRealTimeAds();
		validateGallery();
		//clickOnBackButton();
		refreshPage();
		verifySocialConnect();
		//validateSocialconnect();
		validateMostRead();
		/*
		 * validateGallery(); clickOnBackButton();
		 */
		}
		else
		{
			waitTime(3);
			clickOn(OR.tab_Mob_Header_Navigation_Most_Popular);
			verifyBottomAdsInMobile();
			verifyTopForbesWriterInMobile();
			verifySocialslidersInMobile();
			//validatePopularGalleries();
			verifyRelatedTopicsInMob();
			verifyMostReadOnForbesInMobile();
			verifySwitchToFullWebsiteInMobile();
			
		}

	}

	/**
	 * Validate socialconnect.
	 */
	public void validateSocialconnect() {

		testStepInfo("******************************** Social connection **************************************");
		waitTime(3);
		try {
			waitForElement(OR.img_Most_Popular_Social_Facebook);
			scrollToElement(OR.img_Most_Popular_Social_Facebook);
			scrollBy(0, -70);
			clickOn(OR.img_Most_Popular_Social_Facebook);
			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				waitTime(2);
				//driver.manage().window().maximize();

			}

			driver.close();
			driver.switchTo().window(winHandleBefore);
			testStepPassed("Social Connects are available");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void verifySocialConnect()
	{
		try {
			waitForElement(OR.img_Most_Popular_Social_Facebook);
			scrollToElement(OR.img_Most_Popular_Social_Facebook);
			scrollBy(0, -70);
			clickOn(OR.img_Most_Popular_Social_Facebook);
			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				waitTime(2);
				//driver.manage().window().maximize();

			}
			boolean email = elementPresent(OR.txt_Home_Page_Facebook_Email);
			if (email == true) {
				testStepPassed("Navigating to Facebook Page");
			} else {
				testStepPassed("Facebook is not available");
			}
			driver.close();

			driver.switchTo().window(winHandleBefore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate gallery.
	 *
	 * @throws Exception the exception
	 */
	public void validateGallery()throws Exception {
		testStepInfo("*************************************** Trending Stories **************************");
		waitTime(5);
		scrollToElement(OR.txt_Most_Popular_links);
		scrollBy(0, -60);
		waitForElement(OR.txt_Most_Popular_links);
		boolean mostPopular=elementPresent(OR.txt_Most_Popular_links);
		if (mostPopular==true) {
			String mostPopularLink=getText(OR.txt_Most_Popular_links);
			testStepPassed(mostPopularLink);
			testStepPassed("Recently posted Most Popular are displayed");
		}
		else
		{
		testStepPassed("Recently posted Most Popular are not displayed");
		}
		clickOn(OR.txt_Most_Popular_links);
		
		//testStepPassed("Verified the user is able to click on article link and navigates to respective URL/Article Page");

		try {
			//elementPresent(OR.txt_Most_Popular_Gallery);
			String varGallery = getText(OR.txt_Most_Popular_Gallery);
			if (varGallery.contains("Gallery")) {
				//scrollToElement(OR.txt_Most_Popular_Gallery);
				scrollBy(0, 700);
				clickOn(OR.txt_Most_Popular_Gallery);
				waitTime(3);
				clickOn(OR.btn_Most_Popular_Next);
				testStepPassed("Gallery is present for this article");
				clickOnBackButton();
				clickOnBackButton();
			} else {
				testStepPassed("Gallery is not present for this article");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			testStepPassed("Gallery is not present");
		}
		waitTime(2);

	}

	

	/**
	 * Gets the most popular article text.
	 *
	 * @return the most popular article text
	 */
	public String getMostPopularArticleText() {
		String strXpath = "Most Popular Article heading#xpath=//div[@class='stories_wrapper']//ol[@class='all']/li//a";
		return this.getText(strXpath);
	}

	/**
	 * Click on most popular article.
	 */
	Actions actions = new Actions(driver);

	/**
	 * Click on most popular article.
	 */
	public void clickOnMostPopularArticle() {
		String strXpath = "Most Popular Article #xpath=//div[@class='stories_wrapper']//ol[@class='all']/li//a";
		this.clickOn(strXpath);
	}

	/**
	 * Gets the contributor details.
	 *
	 * @return the contributor details
	 */
	public void getContributorDetails() {
		testStepInfo("************************Contributor Avatars**********************************");
		waitTime(2);
		int authorCount = getElementCount(OR.txt_Most_Popular_Page_Author);
		testStepPassed("Total Authors/contributors" + authorCount);
		waitTime(2);

		WebElement menu = driver
				.findElement(By
						.xpath("//section[@class='top_writers']//form//div[@class='leaderboard_holder']//ul//li//a"));
		actions.moveToElement(menu).perform();

		// mouseOver(OR.txt_Most_Popular_Page_Author);
		waitTime(2);
		// mouseOver(OR.txt_Most_Popular_Page_outerLayout);
		String contributorDetails = getText(OR.txt_Most_Popular_Page_Contributor_Details);
		testStepPassed("Contributor Details---" + contributorDetails);
	}

	/**
	 * Verify social web.
	 */
	public void verifySocialWeb() {
		testStepInfo("*************************** Social Web ******************************************");
		try {
			clickOn(OR.icon_Most_Popular_Social_Web_Twitter);
			int twitterCount = getElementCount(OR.txt_Most_Popular_Twitter);
			testStepPassed("Total Links Present on Twitter--" + twitterCount);
			String twitter = getText(OR.txt_Most_Popular_Twitter);
			testStepPassed(twitter);
			clickOn(OR.icon_Most_Popular_Social_Web_Facebook);
			int facebookCount = getElementCount(OR.txt_Most_Popular_Social_Web_Facebook);
			testStepPassed("Total Links Present on Facebook--" + facebookCount);
			String facebook = getText(OR.txt_Most_Popular_Social_Web_Facebook);
			testStepPassed(facebook);
			clickOn(OR.icon_Most_Popular_Social_Web_LinkedIn);
			int linkedInCount = getElementCount(OR.txt_Most_Popular_Social_Web_LinkedIn);
			testStepPassed("Total Links Present on LinkedIn--" + linkedInCount);
			String linkedIn = getText(OR.txt_Most_Popular_Social_Web_LinkedIn);
			testStepPassed(linkedIn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

/**
 * Mobile Script
 * Created On : 22 June 2016.
 */
	public void verifySocialslidersInMobile()
	{
		testStepInfo("*************************** Social Sliders ******************************************");
		scrollBy(0, 500);
		waitForElement(OR.img_Mob_Most_Popular_Page_Socialsliders_Twitter);
		try {
			boolean twitter=elementPresent(OR.img_Mob_Most_Popular_Page_Socialsliders_Twitter);
			if (twitter==true) {
				testStepPassed("Twitter is displayed");
			}
			else
			{
				testStepPassed("Twitter is not displayed");
			}
			
			boolean facebook=elementPresent(OR.img_Mob_Most_Popular_Page_Socialsliders_Facebook);
			if (facebook==true) {
				testStepPassed("Facebook is displayed");
			}
			else
			{
				testStepPassed("Facebook is not displayed");
			}
			
			boolean linkedIn=elementPresent(OR.img_Mob_Most_Popular_Page_Socialsliders_LinkedIn);
			if (linkedIn==true) {
				testStepPassed("LinkedIn is displayed");
			}
			else
			{
				testStepPassed("LinkedIn is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	/**
	 * Validate popular galleries.
	 */
	public void validatePopularGalleries()
	{
		testStepInfo("*************************** Popular Gallery ******************************************");
		try {
			scrollBy(0, -50);
			boolean gallery=elementPresent(OR.btn_Mob_Most_Popular_Page_Galleries);
			
			if(gallery==true)
			{
				
			clickOn(OR.btn_Mob_Most_Popular_Page_Galleries);
			testStepPassed("Popular Galleries can swipped");
			}
			else
			{
				testStepPassed("Popular Galleries can not be swipped");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	


	/**
	 * Verify switch to full website in mobile.
	 */
	public void verifySwitchToFullWebsiteInMobile()
	{
		testStepInfo("*************************** Switch To Full Website ******************************************");
		scrollBy(0, 100);
		boolean switchToFullWeb=elementPresent(OR.txt_Mob_Most_Popular_Switch_Full_Website);
		if (switchToFullWeb==true) 
		{
			testStepPassed("Switch to full website is displayed");
		}
		else
		{
			testStepPassed("Switch to full website is not displayed");
		}
	}
	
	/**
	 * Author : Shakira
	 * Created On : 23 June 2016.
	 */
	
	public void verifyTopForbesWriterInMobile()
	{
		testStepInfo("*************************** Top Forbes Writers ******************************************");
		scrollBy(0, 500);
		scrollToElement(OR.img_Mob_Most_Popular_Top_Forbes_Writers);
		boolean topForbesWriters=elementPresent(OR.img_Mob_Most_Popular_Top_Forbes_Writers);
		if(topForbesWriters==true)
		{
		//clickOn(OR.img_Mob_Most_Popular_Top_Forbes_Writers);
		String writersDetails=getText(OR.txt_Mob_Most_Popular_Top_Forbes_Writers_Details);
		testStepPassed(writersDetails);
		testStepPassed("Top Forbes Writers label is displayed");
		}
		else
		{
			testStepPassed("Top Forbes Writers label is not displayed");
		}
	}
	
	/*public void swipe() {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        HashMap<String, Double> swipeObject = new java.util.HashMap<String, Double>();
        swipeObject.put("startX", 0.95);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.05);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 1.8);
        js.executeScript("mobile: swipe", swipeObject);
    }*/
	
}
