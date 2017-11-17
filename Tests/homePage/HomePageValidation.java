
/**
 * Check ads on whole page
 * Hamburger menu
 * Home, newposts, Popular tabs
 * Search icon
 * Top Stories
 * Most polular section with see more popular stories link
 * ForbesBrandVoice 
 * Featured
 * Video
 * Forbes Lists section
 * Login
 */

package homePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectsRepository.OR;
import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;



public class HomePageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Home Page Validation
	// Created by :Shakira
	// Created on :6 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	
	/**
	 * Instantiates a new home page validation.
	 *
	 * @param obj the obj
	 */
	public HomePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new home page validation.
	 */
	public HomePageValidation() {

		// TODO Auto-generated constructor st ub
	}

	/**
	 * Verify home page.
		 */
	public void verifyHomePage() {

		if (currentExecutionMachineName.equalsIgnoreCase("Desktop_1_1")
				|| currentExecutionMachineName.startsWith("iPad")) {
			verifyUSUserZone();
			verifyEuropeUserZone();
			verifyAsiaUserZone();
			verifyAdDisplayedInHomePage();
			
			verifyFollowForbes();
			verifyTopStory();
			verifyVideoOnHomePage();
			 //verifyTopStoriesLinks();
			 getMostPopularLinks();
			 
			 verifyTwitterSocialShare();
				verifyFacebookSocialShare();
				verifyLinkedInSocialShare();
				
			 verifyForbesList();
				verifyFooter();
				verfiyLogin();
			
			//verifySocialWeb();

			 //clickOnBackButton();
			// verifySearch();
			
			// verifyLogout();
			// switchTowindowForFacebook();
			// switchTowindowForGoogle();
			
			
			
			
		} else {
			validateHamburgerMenu();
			validateMobileAdsInHomePage();
			verifyHomePageTabs();
			clickOn(OR.tab_Mob_Home_Page_Home);
			//verifyTopStoriesLinks();
			verifyTopStoryInMobile();
			verifyVideoOnHomePage();
			getMostPopularLinks();
			verifyMostPopularSeeMoreStories();
			verifyHomePageForbesBrandVoice();
			verifyHomePageFeatures();
			validateForbesListsInMobile();
			 verifyRelatedTopicsInMob();
			
		}

	}

	/**
	 * Author : Shakira
	 * Created on : 17 June 2016
	 * 
	 */
	
	/**
	 * Verify Top Story First link 
	 */
	public void verifyTopStoryInMobile()
	{
		try {
			scrollBy(0, 40);
			boolean topStory=elementPresent(OR.txt_Mob_Home_Page_Top_Stories);
			if(topStory==true)
			{
				String topStories=getText(OR.txt_Mob_Home_Page_Top_Stories);
				testStepPassed("First Link of Top Stories ---"+topStories);
			}
			else
			{
				testStepPassed("Top Story is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Verify Twitter social Share by clicking on twitter tab.
	 * And checking twitter content displayed 
	 
	 */
	
	public void verifyTwitterSocialShare()
	{
		testStepInfo("*************************** Social Web ******************************************");
		try {
		
			scrollBy(0, 100);
			waitTime(2);
			takeAdScreenshot(OR.icon_Most_Popular_Social_Web_Twitter, "Twitter");
			boolean twitter=elementPresent(OR.icon_Most_Popular_Social_Web_Twitter);
			if (twitter==true) 
			{
			
				clickOn(OR.icon_Most_Popular_Social_Web_Twitter);
				String getTwitter=getText(OR.txt_Most_Popular_Twitter);
				testStepPassed("First Link of Twitter is --"+getTwitter);
			}
			else
			{
				testStepPassed("Twitter is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Verify Facebook social Share by clicking on twitter tab.
	 * And checking facebook content displayed 
	 
	 */
	public void verifyFacebookSocialShare()
	{
		try {
			
			scrollBy(0, 100);
			waitTime(2);
			takeAdScreenshot(OR.icon_Most_Popular_Social_Web_Facebook, "Facebook");
			boolean facebook=elementPresent(OR.icon_Most_Popular_Social_Web_Facebook);
			if (facebook==true) 
			{
			
				clickOn(OR.icon_Most_Popular_Social_Web_Facebook);
				String getFacebook=getText(OR.txt_Most_Popular_Social_Web_Facebook);
				testStepPassed("First Link of Facebook is --"+getFacebook);
			}
			else
			{
				testStepPassed("Facebook is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Verify LinkedIn social Share by clicking on twitter tab.
	 * And checking LinkedIn content displayed 
	 
	 */
	public void verifyLinkedInSocialShare()
	{
		try {
			
			scrollBy(0, 100);
			waitTime(2);
			takeAdScreenshot(OR.icon_Most_Popular_Social_Web_LinkedIn, "LinkedIn");
			boolean linkedIn=elementPresent(OR.icon_Most_Popular_Social_Web_LinkedIn);
			if (linkedIn==true) 
			{
			
				clickOn(OR.icon_Most_Popular_Social_Web_LinkedIn);
				String getLinkedIn=getText(OR.txt_Most_Popular_Social_Web_LinkedIn);
				testStepPassed("First Link of LinkedIn is --"+getLinkedIn);
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
	
	/*
	public void verifySocialWeb() {
		
		scrollBy(0, 400);
		scrollToElement(OR.icon_Most_Popular_Social_Web_Twitter);
		takeAdScreenshot(OR.icon_Most_Popular_Social_Web_Twitter, "Social Web");
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

	}*/

	/**
	 * Verify forbes list.
	 * Validating Forbes List previous and next 
	 */
	public void verifyForbesList() {
		testStepInfo("****************************Forbes List********************************************");
		try {
			elementPresent(OR.arw_Home_Page_Forbes_List_Prev);
			boolean varForbesList = elementPresent(OR.txt_Home_Page_Forbes_List);
			testStepPassed("Verified the Forbes list is displayed"
					+ varForbesList);
			clickOn(OR.arw_Home_Page_Forbes_List_Prev);
			List<WebElement> allForbesLists = driver
					.findElements(By
							.xpath("//div[@class='bx-wrapper']//div//a//span[@class='name']"));
			int count = allForbesLists.size();
			testStepPassed("Total List of Forbes lists is--" + count);

			clickOn(OR.arw_Home_Page_Forbes_List_Next);
			boolean forbesLists = elementPresent(OR.txt_Home_Page_Forbes_List_Name);
			if (forbesLists == true) {
				testStepPassed("Forbes Lists ticker is working");
			} else {
				testStepPassed("Forbes Lists ticker is not working");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify footer.
	 */
	public void verifyFooter() {
		testStepInfo("******************************Footer**************************************");

		int channel = 1;
		for (channel = 1; channel <= 9; channel++) {
			String footerChannels = "Channels#xpath=//div[@class='channels']//ul[@class='edittools-list']//li["
					+ channel + "]";
			String getChannels = getText(footerChannels);
			testStepPassed("Footer Channels are " + getChannels);
		}

		String mediallc = getText(OR.txt_Home_Page_Media_Forbes);
		testStepPassed("" + mediallc);

	}

	/**
	 * Verfiy login.
	 */
	public void verfiyLogin() {
		testStepInfo("*******************************Login************************************************");
		try {
			clickOn(OR.img_Home_Page_Login);
			/*
			 * typeIn(OR.txt_Home_Page_Login_User_Name,
			 * retrieve("txtUserName")); typeIn(OR.txt_Home_Page_Login_Password,
			 * retrieve("txtPassword"));
			 */

			boolean loginButton = elementPresent(OR.btn_Home_Page_Login_Button);
			if (loginButton == true) {
				testStepPassed("Login form is available");
			} else {
				testStepPassed("Login form is not available");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify logout.
	 */
	public void verifyLogout() {
		testStepInfo("*******************************Logout************************************************");
		clickOn(OR.btn_Home_Page_Logout);
		boolean logout = elementPresent(OR.btn_Home_Page_Login_Button);
		if (logout == true) {
			testStepPassed("Verified Logout Successfully");
		} else {
			testStepPassed("Failed  to Logout");
		}

	}

	// ************************************************************** MOBILE
	// SCRIPT
	// ********************************************************************

	/**
	 * Validate hamburger menu.
	 */
	public void validateHamburgerMenu() {
		testStepInfo("************************************ Hamburger Menu **************************************");
		clickOn(OR.txt_Mob_Header_Navigation_Forbes);
		boolean channel = elementPresent(OR.txt_Mob_Header_Navigation_Business_Channel);
		if (channel == true) {
			testStepPassed("Hamburger menu is displayed");
		/*	clickOn(OR.txt_Mob_Header_Navigation_Business_Channel);
			waitTime(3);
			String businessTitle = getText(OR.txt_Mob_Home_Page_Business_Title);
			testStepPassed("Title is - " + businessTitle);
			clickOnBackButton();*/
			clickOn(OR.txt_Mob_Header_Navigation_Forbes);
		} else {
			testStepPassed("Hamburger menu is not displayed");
		}

	}

	/**
	 * Validate mobile ads in home page.
	 */
	public void validateMobileAdsInHomePage() {
		testStepInfo("************************************ Ads **************************************");
		try {
			boolean topAds = elementPresent(OR.ads_Mob_Home_Page_Top_ads);
			if (topAds == true) {
				takeAdScreenshot(OR.ads_Mob_Home_Page_Top_ads, "Mobile Rec Ads");
				testStepPassed("Mobile Rec Ads is present");

			} else {
				testStepPassed("Mobile Rec Ads is not present");
			}
			verifyBottomAdsInMobile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify home page tabs.
	 */
	public void verifyHomePageTabs() {
		testStepInfo("************************************* Home Page Tabs********************************");
		try {
			clickOn(OR.tab_Mob_Home_Page_Home);
			boolean heading = elementPresent(OR.txt_Mob_Home_Page_Heading);
			if (heading == true) {
				String varHeading = getText(OR.txt_Mob_Home_Page_Heading);
				testStepPassed("Home Tab is working " + varHeading);

			} else {
				testStepPassed("Home Tab is not working ");
			}

			clickOn(OR.tab_Header_Navigation_New_Post);
			boolean newPostsHeading = elementPresent(OR.txt_Mob_Header_Navigation_New_Post);
			if (newPostsHeading == true) {

				String varNewPostsHeading = getText(OR.txt_Mob_Header_Navigation_New_Post);
				testStepPassed("New Posts Tab is working " + varNewPostsHeading);
			} else {
				testStepPassed("New Posts Tab is not working ");
			}
			clickOn(OR.tab_Mob_Header_Navigation_Most_Popular);
			boolean mostPopularHeading = elementPresent(OR.txt_Mob_Home_Page_Most_Popular_Heading);
			if (mostPopularHeading == true) {

				String varMostPopularHeading = getText(OR.txt_Mob_Home_Page_Most_Popular_Heading);
				testStepPassed("Most Popular Tab is working "
						+ varMostPopularHeading);
			} else {
				testStepPassed("Most Popular Tab is not working ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify most popular see more stories.
	 */
	public void verifyMostPopularSeeMoreStories() {
		testStepInfo("************************************* Most Popular See More Stories********************************");
		try {
			scrollBy(0, 200);
			waitTime(3);
			boolean seeMore=elementPresent(OR.txt_Mob_Home_Page_Most_Popular_See_More);
			if (seeMore==true) {
				
				testStepPassed("Most Popular See More Option is displayed");
			}
			else
			{
				testStepPassed("Most Popular See More Option is not displayed");
			}
			/*clickOn(OR.txt_Mob_Home_Page_Most_Popular_See_More);
			boolean moostPopular = elementPresent(OR.txt_Mob_Home_Page_Most_Popular_Heading);
			if (moostPopular == true) {
				scrollBy(0, 300);
				clickOn(OR.txt_Mob_Home_Page_most_Popular_Stories);
				clickOnBackButton();
			} else {
				testStepPassed("See more Most Popular stories not displayed");
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify home page forbes brand voice.
	 */
	// 20 June 2016
	public void verifyHomePageForbesBrandVoice() {
		testStepInfo("************************************* Forbes BrandVoice********************************");
		try {
			scrollBy(0, 300);
			waitTime(4);
			//clickOn(OR.txt_Mob_Home_Page_Forbes_BrandVoice);
			boolean brandVoiceHeading = elementPresent(OR.txt_Mob_Home_Page_Forbes_BrandVoice);
			if (brandVoiceHeading == true) {
				String getHeading = getText(OR.txt_Mob_Home_Page_Forbes_BrandVoice);
				testStepPassed("Forbes Brandvoice is displayed"+getHeading);
				//clickOnBackButton();
			} else {
				testStepPassed("Forbes BrandVoice is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify home page features.
	 */
	public void verifyHomePageFeatures() {
		testStepInfo("************************************* Features ********************************");

		try {
			scrollBy(0, 400);
			waitForElement(OR.txt_Mob_Home_Page_Feature);
			String feature = getText(OR.txt_Mob_Home_Page_Feature);
			testStepPassed("-"+feature+"-");
			boolean featureLink=elementPresent(OR.txt_Mob_Home_Page_Features_Link);
			if (featureLink==true) {
				String featureLinks=getText(OR.txt_Mob_Home_Page_Features_Link);
				testStepPassed("Feature First Link is ---"+featureLinks);
				testStepPassed("Feature Link is displayed");
				
			}
			else
			{
				testStepPassed("Feature Link is not displayed");
			}
			
			/*boolean featuresHeading = elementPresent(OR.txt_Mob_Home_Page_Features_Heading);
			if (featuresHeading == true) {
				String heading = getText(OR.txt_Mob_Home_Page_Features_Heading);
				testStepPassed(heading);
				clickOnBackButton();
			} else {
				testStepPassed("Features Page is not loaded Properly");
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate forbes lists in mobile.
	 */
	public void validateForbesListsInMobile() {
		testStepInfo("************************************* Forbes Lists ********************************");
		scrollBy(0, 300);
		
		boolean forbesList=elementPresent(OR.txt_Mob_Home_Page_Forbes_Lists);
		if (forbesList==true)
		{
			String forbesLists=getText(OR.txt_Mob_Home_Page_Forbes_Lists);
			testStepPassed("Forbes Lists First Link is ---"+forbesLists);
			testStepPassed("Forbes Lists is displayed");
		}
		else
		{
			testStepPassed("Forbes Lists is  not displayed");
		}
		//clickOn(OR.txt_Mob_Home_Page_Forbes_Lists);
		// validateHeading();
		//validateHeading();
	}

/*	*//**
	 * Validate most read on forbes.
	 *//*
	public void validateMostReadOnForbes() {
		testStepInfo("************************************* Most Read on Forbes ********************************");
		try {
			waitTime(3);
			scrollBy(0, 400);
			// scrollToElement(OR.tab_Mob_Home_Page_Most_Read_People);
			String mostRead = getText(OR.txt_Mob_Home_Page_Most_Read);
			testStepPassed(mostRead);
			clickOn(OR.tab_Mob_Home_Page_Most_Read_People);
			wait(2);
			clickOn(OR.tab_Mob_Home_Page_Most_Read_Places);
			clickOn(OR.tab_Mob_Home_Page_Most_Read_Companies);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}*/

	/**
	 * Validate related topics.
	 */
	public void validateRelatedTopics() {
		testStepInfo("************************************* Related Topics ********************************");
		try {
			scrollToElement(OR.txt_Mob_Home_Page_Related_Topics);
			scrollBy(0, 800);
			waitForElement(OR.txt_Mob_Home_Page_Related_Topics);
			String relatedTopics = getText(OR.txt_Mob_Home_Page_Related_Topics);
			testStepPassed(relatedTopics);
			int relatedTopicsCount = 1;
			for (relatedTopicsCount = 1; relatedTopicsCount <= 4; relatedTopicsCount++) {
				String relatedTopic = "Related Topics#xpath=//div[@id='unit']//ul//li["
						+ relatedTopicsCount + "]";
				String topic = getText(relatedTopic);
				testStepPassed(topic);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	/**
	 * Validate most read.
	 */
	public void validateMostReadInMobile() {
		testStepInfo("********************************* Most Read **************************************");

		try {
			waitForElement(OR.txt_Most_Popular_Page_Most_Read);
			//scrollToElement(OR.txt_Most_Popular_Page_Most_Read);
			scrollBy(0, 800);
			
			//clickOn(OR.txt_Most_Popular_Page_Most_Read);
			boolean mostRead=elementPresent(OR.txt_Most_Popular_Page_Most_Read);
			if (mostRead==true) 
			{
				String mostReadLink=getText(OR.txt_Most_Popular_Page_Most_Read);
				testStepPassed(mostReadLink);
			testStepPassed("Most Read is displayed");	
			}
			else
			{
				testStepPassed("Most Read is not displayed");	
			}
			//clickOnBackButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		//testStepPassed("Most Read are displayed");

	}

	
	/**
	 * Author : Shakira
	 * Created On : 28 June 2016
	 */

	/**
	 * Verify US tab is clicking
	 */
	public void verifyUSUserZone()
	{
		testStepInfo("********************************* User Zone Tabs **************************************");
		try {
			boolean usTab=elementPresent(OR.txt_Home_User_Zone_US);
			if (usTab==true) 
			{
				clickOn(OR.txt_Home_User_Zone_US);
				testStepPassed("US tab is displayed");
			}
			else
			{
				testStepPassed("US tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
				
	}

	/**
	 * Verify Europe tab is clicking
	 */
	public void verifyEuropeUserZone()
	{
		
		try {
			boolean europeTab=elementPresent(OR.txt_Home_User_Zone_Europe);
			if (europeTab==true) 
			{
				clickOn(OR.txt_Home_User_Zone_Europe);
				testStepPassed("Europe tab is displayed");
			}
			else
			{
				testStepPassed("Europe tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
				
	}
	
	/**
	 * Verify Asia tab is clicking
	 */
	public void verifyAsiaUserZone()
	{
		
		try {
			boolean asiaTab=elementPresent(OR.txt_Home_User_Zone_Asia);
			if (asiaTab==true) 
			{
				clickOn(OR.txt_Home_User_Zone_Asia);
				testStepPassed("Asia tab is displayed");
			}
			else
			{
				testStepPassed("Asia tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
				
	}
	
	/**
	 * Verifying first link of Top stories
	 */
	public void verifyTopStory()
	{
		try {
			boolean topStory=elementPresent(OR.txt_Home_Page_Top_Stories1);
			if(topStory==true)
			{
				String topStories=getText(OR.txt_Home_Page_Top_Stories1);
				testStepPassed("First Link of Top Stories ---"+topStories);
			}
			else
			{
				testStepPassed("Top Story is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * 
	 */
	
	public void verifyFollowForbes()
	{
		testStepInfo("********************************* Follow Forbes **************************************");
		try {
			int followAvatar=1;
			for(followAvatar=1;followAvatar<=5;followAvatar++)
			{
			String followForbes="Follow Forbes#xpath=//div[@class='follow_links']//ul//li["+followAvatar+"]";
			getText(followForbes);
			boolean follow=elementPresent(followForbes);
			if (follow==true)
			{
			
				testStepPassed("Follow On Forbes Avataras are present");
			}
			else
			{
				testStepPassed("Follow On Forbes Avataras are not present");
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Verify Video is played
	 */
	public void verifyVideoOnHomePageIniPad() {

		testStepInfo("****************************Top Video***************************************");
		try {
			
			testStepPassed("Before Video plays");
			takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
			waitTime(3);
			boolean playButton = elementPresent(OR.vidHomePageVideo);
			if (playButton == true) {
				clickOn(OR.vidHomePageVideo);
				waitTime(6);
				testStepPassed("Video Played for 6 seconds");
				takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
			} else {
				testStepPassed("Video Play button is not loaded");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
}
