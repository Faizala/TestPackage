/**
 * Check the page with ads
 * Check for the video played default.
 * Pause the video
 * Check all the social web icons
 * Check Recommended label with the video stream horizontal.
 * Check next and previous icons
 * Click on the previous and next buttons to check the videos
 * Click on any video from recommended section
 * Check for the featured section
 * Check Most popular section
 * Check Search Forbes Video with search tab and icon
 * Check for the latest videos label

 */

package videoPage;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoPageValidation.
 * class names are written in mixed case with the first letter of each internal word capitalized
 */
public class VideoPageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Video Page Validation
	// Created by :Shakira
	// Created on :14 June 2016

	// ///////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Instantiates a new video page validation.
	 *
	 * @param obj the obj
	 */
	public VideoPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new video page validation.
	 */
	public VideoPageValidation() {

	}

	/**
	 * Verify video page.
	 * methods are written in mixed case with the first letter lower case, with the first letter of each internal word capitalized.
	 * variables are written in mixed case with the first letter lower case, with the first letter of each internal word capitalized.
	 */
	public void verifyVideoPage() {
		testStepInfo("********************************** VIDEO *****************************************************");
		if(currentExecutionMachineName.startsWith("Desktop"))
		{
		clickOn(OR.tab_Home_Page_Video);
		elementPresent(OR.vidHomePageVideo);
		waitTime(5);
		takeAdScreenshot(OR.vidHomePageVideo, "Video Page Video");
		testStepPassed("Verified the first video in any landing page is autoplayed");
		// mouseOver(OR.vidHomePageVideo);
		clickOn(OR.vidHomePageVideo);
		waitTime(5);
	//	testStepPassed("Video is paused");
		verifySocialWeb();
		verifyAds();
		verifyRecommended();
		verifyLoadMoreInDesktop();
		
		// ValidateRecommended();
		validateFeatured();
		}
		else
		{
			driver.get("http://www.forbes.com/video/");
			verifyBottomAdsInMobile();
			verifyVideoOnHomePage();
			verifyRecommendedInMobile();
			verifyRelatedTopicsInMob();
			verifyMostReadOnForbesInMobile();
		
		}
	}

	/**
	 * Validate featured.
	 */
	public void validateFeatured() {
		testStepInfo("************************************** Featured ****************************************");
		try {
			clickOn(OR.img_Video_Page_Featured);
			waitTime(5);
			String featured = getText(OR.txt_Video_Page_Featured_Link);
			testStepPassed("" + featured);
			clickOn(OR.vidHomePageVideo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify social web.
	 */
	public void verifySocialWeb() {
		testStepInfo("************************************** Social Web ******************************************");
		try {
			clickOn(OR.btn_Video_Page_Social_Web);
			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				waitTime(2);
				driver.manage().window().maximize();

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
	 * Verify ads.
	 */
	public void verifyAds() {
		testStepInfo("***************************************** Ads  *********************************************");
		try {
			boolean topAds = elementPresent(OR.adsHomePageTopAds);
			boolean topxAds = elementPresent(OR.adsHomePageTopxAds);
			if (topAds == true || topxAds == true) {
				testStepPassed("Top Ads in Video Page");
				takeAdScreenshot(OR.adsHomePageTopAds, "Top Ads");
				testStepPassed("Topx Ads in Video Page");
				takeAdScreenshot(OR.adsHomePageTopxAds, "Topx Ads");
			} else {
				testStepPassed("Top Ads is not present");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify recommended.
	 */
	public void verifyRecommended() {
		testStepInfo("*********************************** Recommended **************************************************");
		try {
			waitForElement(OR.img_Video_Page_Recommended_Article);
			String varRecommended = getText(OR.img_Video_Page_Recommended_Article);
			testStepPassed("Recommended Article is --" + varRecommended);
			clickOn(OR.btn_Video_Page_Recommended_Next);
			takeAdScreenshot(OR.btn_Video_Page_Recommended_Next, "Next Recommended");
			String varNextRecommended = getText(OR.img_Video_Page_Recommended_Next_Article);
			testStepPassed("Recommended Next Article is --" + varNextRecommended);
			clickOn(OR.img_Video_Page_Recommended_Next_Article);
			waitTime(5);
			clickOn(OR.vidHomePageVideo);
			takeAdScreenshot(OR.vidHomePageVideo, "Video Page Video");
			testStepPassed("Verified the first video in any landing page is autoplayed");
			clickOn(OR.vidHomePageVideo);
			testStepPassed("Video is paused");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify load more in desktop.
	 */
	public void verifyLoadMoreInDesktop()
	{
		testStepInfo("***************************** Load More *************************************");
		try {
			boolean video=elementPresent(OR.txt_Video_Page_Most_Popular_videos);
			if(video==true)
			{
			takeAdScreenshot(OR.txt_Video_Page_Most_Popular_videos, "Videos");
			testStepPassed("Video is displayed");
			}
			else
			{
				testStepPassed("Video is not displayed");
			}
			clickOn(OR.btn_Video_Page_Recommended_Load_More);
			String loadMore = getText(OR.txt_video_Page_Load_More_Next_Events);
			takeAdScreenshot(OR.txt_video_Page_Load_More_Next_Events,
					"Next Details");
			testStepPassed("Verified the LOAD MORE option is displayed to load more details of the page"
					+ loadMore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Validate recommended.
	 */
	public void validateRecommended() {
		testStepInfo("*********************************** Recommended **************************************************");
		try {
			String varNext;
			String varXpath = null;
			// waitForElement(OR.txt_Video_Page_Recommended);
			String varRecom = getText(OR.txt_Video_Page_Recommended);
			testStepPassed(varRecom);
			int nextButton = 2;
			for (nextButton = 2; nextButton <= 3; nextButton++) {

				varNext = "Next#xpath=//ol[@class='flex-control-nav flex-control-paging']//li//a[text()="
						+ nextButton + "]";
				clickOn(varNext);
				takeAdScreenshot(varNext, "recom");
				int profile = 1;
				for (profile = 1; profile < 15; profile++) {
					varXpath = "Recommended Profile#xpath=//div[@class='flex-viewport']//ul[@class='slides clearfix']//li["
							+ profile + "]//a/..//h4";
					if (profile >= 1 || profile <= 15) {
						String recom = getText(varXpath);
						testStepPassed("Recommended Article is--" + recom);
						// takeAdScreenshot(varXpath, "Recommended");
					}

				}

			}

			testStepPassed("Verified the Forbes RECOMMENDED articles are displayed in the page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * Verify recommended in mobile.
	 */
	public void verifyRecommendedInMobile()
	{
		testStepInfo("*********************************** Recommended **************************************************");
		
			scrollBy(0, 400);
			String varRecom = getText(OR.txt_Video_Page_Recommended);
			testStepPassed(varRecom);
			boolean nextButton=elementPresent(OR.btn_Mob_Video_Page_Next);
			if (nextButton==true) {
				clickOn(OR.btn_Mob_Video_Page_Next);
				takeAdScreenshot(OR.btn_Mob_Video_Page_Next, "Recommended");
				testStepPassed("Recommended Swipe is working");
			}
			else
			{
				testStepPassed("Recommended Swipe is working");
			}
		
		
	}

}
