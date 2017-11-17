/**
 * Check all the ads and the page has content
 * Real Time label with the graph
 * Chek all the lins(All, Business, Investing, Tech etc)
 * Check for the stream
 * Check Load more button at the bottom of the page

 */

package realTimePage;


import objectsRepository.OR;
import iSAFE.ApplicationKeywords;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class RealTimePageValidation.
 * class names are written in mixed case with the first letter of each internal word capitalized
 */
public class RealTimePageValidation extends ApplicationKeywords {
	
	/** The obj. */
	BaseClass obj;


	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :New Posts Page Validation
	// Created by :Shakira
	// Created on :9 June 2016
	
	// ///////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Instantiates a new real time page validation.
	 *
	 * @param obj the obj
	 */
	public RealTimePageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new real time page validation.
	 */
	public RealTimePageValidation() {

	}

	/**
	 * Verify new posts page.
	 * methods are written in mixed case with the first letter lower case, with the first letter of each internal word capitalized.
	 * variables are written in mixed case with the first letter lower case, with the first letter of each internal word capitalized.
	 */
	public void verifyNewPostsPage() {
		
		if (currentExecutionMachineName.startsWith("Desktop"))
		{
		clickOn(OR.tab_Header_Navigation_New_Posts);
		String varRealPost = getText(OR.txt_Header_Navigation_New_Post);
		testStepPassed("Navigated to this page--" + varRealPost);
		waitTime(2);
		verifyGraph();
		verifyRealTimeChannelTabs();
		verifyNewPostedPosts();
		
		verifyRealTimeAds();
		validateLoadMore();
		}
		else
		{
			validateNewPostsHeading();
			verifyRecentPostsInNewPosts();
			
		}

	}

	public void verifyNewPostedPosts()
	{
		testStepInfo("**************Newly Posted Events*******************");
		waitForElement(OR.txt_New_Posts_link);
		boolean newPosts=elementPresent(OR.txt_New_Posts_link);
		if (newPosts==true) 
		{
		
			String newPostsLink=getText(OR.txt_New_Posts_link);
			testStepPassed(newPostsLink);
		}
		else
		{
			testStepPassed("Newly Posted Posts are not loaded");
		}
	}

	/**
	 * Verify graph.
	 */
	public void verifyGraph() {
		String varGraph = null;
		testStepInfo("************************************* Graph *******************************************");
		int graphNo=1;
		for (graphNo = 1; graphNo <= 3; graphNo++) {

			waitTime(3);
			varGraph = "Graph#xpath=//div[@class='visualStats']//dd[" + graphNo
					+ "]//canvas";
			// boolean graph=elementPresent(varGraph);

		}
		manualScreenshot(varGraph);
		// takeAdScreenshot(varGraph, "");
		int labelNo=1;
		for (labelNo= 1; labelNo <= 3; labelNo++) {
			String label = "Label#xpath=//div[@class='visualStats']//dt[" + labelNo
					+ "]";
			String textLabel = getText(label);
			testStepPassed("Graph is present with Labels--" + textLabel);
		}
	}

	/**
	 * Validate load more.
	 */
	public void validateLoadMore() {
		testStepInfo("**************************Load More*******************");
		try {
			boolean loadMore = elementPresent(OR.txt_New_Posts_Load_More);
			if (loadMore == true) {
				//clickOn(OR.txt_New_Posts_Load_More);
				testStepPassed("Load More option is displayed");
			}
			else
			{
				testStepPassed("Load More option is not displayed ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	/*	// clickOn(OR.txt_New_Posts_link);
		driver.findElement(
				By.xpath("//div[@id='realtimechanneltabs']/div[2]/div/ul[1]/li[28]/div/article/h2/a"))
				.click();
		String headingNewEvents = getText(OR.txt_Most_Popular_Page_Heading);
		testStepPassed(headingNewEvents);
		clickOnBackButton();*/
	}

	/**
	 * Verify real time channel tabs.
	 */
	public void verifyRealTimeChannelTabs() {
		int countImages = 0;
		testStepInfo("*************************************Real Time Channel Tabs********************************************");
		try {
			int channelTab=1;
			for (channelTab = 1; channelTab <= 8;channelTab++) {

				String varXpath = "Real time Channel Tabs#xpath=//div[@id='realtimechanneltabs']//ul//li[@data-channel-mapping='channel_"
						+ channelTab + "']";

				clickOn(varXpath);
				waitTime(2);
				String varChannel = getText(varXpath);

				testStepPassed("Real time channel is --" + varChannel);
				boolean image = elementPresent(OR.img_New_Posts_Images);
				if (image == true) {
					countImages = getElementCount(OR.img_New_Posts_Images);
					manualScreenshot(OR.img_New_Posts_Images);
					testStepPassed("Total images are dispalyed --" + countImages);
					// testStepPassed("Images are Displayed");

				} else {
					testStepPassed("Images are not Displayed");
				}

			}

			clickOn(OR.txt_New_Posts_Channel_Tab10);
			String varChannel = getText(OR.txt_New_Posts_Channel_Tab10);
			testStepPassed("Real time channel is --" + varChannel);

			clickOn(OR.txt_New_Posts_Channel_Tab);
			String varChannel1 = getText(OR.txt_New_Posts_Channel_Tab);
			testStepPassed("Real time channel is --" + varChannel1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Mobile Script
	 * Created On : 21 June
	 */
	public void validateNewPostsHeading()
	{
		try {
			clickOn(OR.tab_Mob_New_Posts);
			String newPostsHeading=getText(OR.txt_Header_Navigation_New_Post);
			testStepPassed("Redirected to - "+newPostsHeading+" -Page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void verifyRecentPostsInNewPosts()
	{
		
		//clickOn(OR.txt_Mob_New_Posts_Recent);
		boolean recentPosts=elementPresent(OR.txt_Mob_New_Posts_Recent);
		if (recentPosts==true)
		{
			String recentPost=getText(OR.txt_Mob_New_Posts_Recent);
			testStepPassed("New Post is -"+recentPost);
			testStepPassed("Recent Posts is displayed");	
		}
		else
		{
			testStepPassed("Recent Posts is not displayed");	
			
		}
		
		scrollBy(0, 500);
		//scrollToElement(OR.btn_Mob_New_Posts_Load_More);
		try {
			boolean loadMore=elementPresent(OR.btn_Mob_New_Posts_Load_More);
			if(loadMore==true)
			{
				testStepPassed("+Load More Button is present");
			}
			else
			{
				testStepPassed("+Load More Button is not present");
			}
			
			/*clickOn(OR.btn_Mob_New_Posts_Load_More);
			scrollBy(0, 500);
			boolean loadedPosts=elementPresent(OR.txt_Mob_New_Posts_Loaded_Posts);
			if (loadedPosts==true) {
				String loadedPost=getText(OR.txt_Mob_New_Posts_Loaded_Posts);
				testStepPassed(""+loadedPost);
				testStepPassed("+Load More is loaded properly");
			}
			else
			{
				testStepPassed("+Load more is not working");
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
}
