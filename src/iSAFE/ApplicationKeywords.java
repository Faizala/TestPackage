/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  AutomationFramework.APIKeywords
 *  baseClass.BaseClass
 *  org.openqa.selenium.By
 *  org.openqa.selenium.WebElement
 *  org.openqa.selenium.remote.RemoteWebDriver
 */
package iSAFE;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import objectsRepository.OR;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationFramework.APIKeywords;
import AutomationFramework.GenericKeywords;
import Utilities.Mailing;
import Utilities.ZipReportFile;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationKeywords.
 *
 * @author indium
 */

public class ApplicationKeywords extends APIKeywords {

	/**
	 * Instantiates a new application keywords.
	 *
	 * @param obj
	 *            the obj
	 */
	
	public static String executionReportStatus = "Pass";
	
	public ApplicationKeywords(BaseClass obj) {
		super(obj);
	}

	/**
	 * Instantiates a new application keywords.
	 */
	public ApplicationKeywords() {
	}

	public static void sendMailOnFailure()
	 {
	  if(executionReportStatus.equals("Fail") && GenericKeywords.getConfigProperty("SendMailOnFailure").equalsIgnoreCase("yes"))
	  {
	   ZipReportFile.zipReport();
	   Mailing.sendMail(".//TestResults//"+GenericKeywords.timeStamp+".zip");
	  }
	 }
	/**
	 * Take ad screenshot.
	 *
	 * @param element
	 *            the element
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(WebElement element, String screenshotName) {
		try {
			this.driver.executeScript("arguments[0].scrollIntoView();",
					new Object[] { element });
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Take ad screenshot.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(String objLocator, String screenshotName) {
		try {
			this.scrollToElement(objLocator);
			this.scrollBy(0, -60);
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Scroll to element.
	 *
	 * @param objLocator
	 *            the obj locator
	 */
	public void scrollToElement(String objLocator) {
		this.waitForElement(objLocator);
		this.driver.executeScript("arguments[0].scrollIntoView();",
				new Object[] { this.webElement });
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) ("Scroll to " + this.locatorDescription));
	}

	/**
	 * Scroll by.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void scrollBy(int x, int y) {
		this.driver.executeScript("window.scrollBy(" + x + "," + y + ")",
				new Object[0]);
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) "Scroll to location: ");
	}

	/**
	 * Verify ad.
	 *
	 * @param adNumber
	 *            the ad number
	 */
	public void verifyAd(int adNumber) {
		this.scrollToElement("Ad place holder#id=article-0-ad-" + adNumber);
		this.takeAdScreenshot("Ad " + adNumber + "#id=inline-article-0-ad-"
				+ adNumber, "Ad No:" + adNumber);
	}

	/**
	 * Test step info.
	 *
	 * @param message
	 *            the message
	 */
	public void testStepInfo(String message) {
		this.writeHtmlTestStepReport("<font style='color:blue'>stepNo"
				+ message + "</font><br/>", this.currentExecutionMachineName,
				this.currentTestCaseName);
	}

	/**
	 * Gets the article heading.
	 *
	 * @param articleNumber
	 *            the article number
	 * @return the article heading
	 */
	public String getArticleHeading(int articleNumber) {
		String strXpath = "Article(" + articleNumber
				+ ")#xpath=//article[@id='article-container-" + --articleNumber
				+ "']//h1[@class='article-headline ng-binding ng-scope']";
		return this.getText(strXpath);
	}

	/**
	 * Gets the main article text.
	 *
	 * @return the main article text
	 */
	public String getMainArticleText() {
		String strXpath = "Main Article heading#xpath=//article[@class='feature promostory promostory-1']/div[@class='feature-headline']/h3/a";
		return this.getText(strXpath);
	}

	/**
	 * Click on main article.
	 */
	public void clickOnMainArticle() {
		String strXpath = "Main Article #xpath=//article[@class='feature promostory promostory-1']";
		this.clickOn(strXpath);
	}

	/**
	 * Click on top stories.
	 *
	 * @param topStoryNumber
	 *            the top story number
	 * @return the string
	 */
	public String clickOnTopStories(int topStoryNumber) {
		String strXpath = "Top Stories (" + topStoryNumber
				+ ") #xpath=//li[@class='promostory promostory-"
				+ (topStoryNumber += 2) + " ']/h4/a";
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		strXpath = "Top Story - " + articleLinkText
				+ "#xpath=//li[@class='promostory promostory-" + topStoryNumber
				+ " ']/h4/a";
		this.clickOn(strXpath);
		return articleLinkText;
	}

	/**
	 * Click on most popular.
	 *
	 * @param mostPopularNumber
	 *            the most popular number
	 * @return the string
	 */
	public String clickOnMostPopular(int mostPopularNumber) {
		String strXpath = "Top Stories ("
				+ mostPopularNumber
				+ ") #xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3[mostPopularNumber]";

		// section[@class='popular_top_stories' or
		// @id='stackMostPopular']//ol//li//h3
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		/*
		 * strXpath = "Most Popular- " + articleLinkText +
		 * "#xpath=//li[@class='promostory promostory-" + mostPopularNumber +
		 * " ']/h4/a"; this.clickOn(strXpath);
		 */
		return articleLinkText;
	}

	/**
	 * Go to home page.
	 */
	public void goToHomePage() {
		String strXpath = "Forbes logo#xpath=//article[@id='article-container-0']//header[@class='article-header ng-scope']//a[@href='http://www.forbes.com/']/h1";
		this.clickOn(strXpath);
	}

	/**
	 * Gets the element count.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @return the element count
	 */
	public int getElementCount(String objLocator) {
		int elementCount = 0;
		try {
			this.waitForElement(objLocator);
			elementCount = this.driver.findElements(
					By.xpath((String) this.locator)).size();
			ApplicationKeywords.writeToLogFile((String) "INFO",
					(String) ("Total Elements found for "
							+ this.locatorDescription + ": " + elementCount));
		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}
		return elementCount;
	}

	/**
	 * Verify ads in mobile article.
	 */
	public void verifyAdsInMobileArticle() {
		try {
			String adPlaceHolder = "Ad Placeholder#xpath=//div[@class='article-mobile-ad ng-scope ng-isolate-scope']";
			int adCount = getElementCount(adPlaceHolder);
			testStepPassed("Verifing (" + adCount + ") Ads in the Aritcle Page");
			int adsNum = 1;
			for (adsNum = 1; adsNum <= adCount; adsNum++) {

				adCount = getElementCount(adPlaceHolder);
				verifyAd(adsNum);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify ads in desktop article.
	 */
	public void verifyAdsInDesktopArticle() {
		int topAdArticleNo = 0;
		int adRailArticleNo = 0;
		for (int i = 0; i <= 15; i++) {

			if (driver.getPageSource().contains(
					"top-ad-article-" + topAdArticleNo)
					|| driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
				if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)
						&& driver.getPageSource().contains(
								"ad-rail-article-" + adRailArticleNo)) {
					testStepPassed("Top Ad");
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1) + ","
									+ "SideAds" + (adRailArticleNo + 1));
					if (driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
						int railAdCount = driver
								.findElements(
										By.xpath("//*[@id='ad-rail-article-"
												+ adRailArticleNo
												+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
								.size();
						testStepPassed("Rail Ad Count: " + railAdCount);
						for (int j = 0; j < railAdCount; j++) {
							takeAdScreenshot(
									driver.findElements(
											By.xpath("//*[@id='ad-rail-article-"
													+ adRailArticleNo
													+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
											.get(j), "SideAds"
											+ (adRailArticleNo + 1));
						}
					}
					topAdArticleNo++;
					adRailArticleNo++;
				} else if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)) {
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1));
					topAdArticleNo++;

				}

			} else {
				((JavascriptExecutor) driver)
						.executeScript("window.scrollBy(0,100)");
			}
		}

	}

	/**
	 * Verify top stories links.
	 */
	public void verifyTopStoriesLinks() {
		testStepInfo("*********************************Top Stories***********************************************");
		int topStoriesCount = getElementCount(OR.lnkTopStories);
		testStepPassed("Total Top Stories: " + topStoriesCount);
		String articleLinkText = clickOnTopStories(1);
		String articleHeading = getArticleHeading(1);
		if (articleHeading.contains(articleLinkText)) {

			testStepPassed("Article Page (" + articleLinkText
					+ ") is displayed");
		} else {
			testStepPassed("Article page (" + articleLinkText
					+ ") is not displayed, instead " + articleHeading
					+ " is displayed");
		}
		clickOnBackButton();
		int articleNo = 0;
		int topStory = 1;
		for (topStory = 1; topStory <= topStoriesCount; topStory++) {

			if (currentExecutionMachineName.startsWith("Desktop")) {
				articleNo = topStory + 1;

			} else {
				articleNo = topStory + 2;
			}

			String strXpath = "Top Stories (" + topStory
					+ ") #xpath=//li[@class='promostory promostory-"
					+ articleNo + " ']/h4/a";
			if (elementPresent(strXpath)) {
				articleLinkText = getText(strXpath);
				testStepPassed("Top Story :" + topStory + " - "
						+ articleLinkText);
			}
		}

	}

	/**
	 * Gets the most popular links.
	 *
	 * @return the most popular links
	 */
	public void getMostPopularLinks() {
		testStepInfo("****************************Most Popular********************************************");
		List<WebElement> allMostLinks = driver
				.findElements(By
						.xpath("//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3"));
		int linksCount = 0;
		for (linksCount = 0; linksCount < allMostLinks.size(); linksCount++) {

			String textMost = allMostLinks.get(linksCount).getText();
			testStepPassed("Most Popular (Top Stories - " + linksCount + 1
					+ ")" + textMost);
			/*
			 * allMostLinks.get(k).click(); clickOnBackButton();
			 */

		}
		// scrollBy(0, 300);

	}

	/**
	 * Verify most popular links.
	 */
	public void verifyMostPopularLinks() {
		testStepInfo("*********************************Most Popular***********************************************");
		scrollToElement(OR.txt_Home_Most_Popular_Links);
		scrollBy(0, 300);
		int mostPopular = 1;
		for (mostPopular = 1; mostPopular <= 1; mostPopular++) {
			String strXpath = "Most Popular#xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3]";
			clickOn(strXpath);
			String mostPopualrTitle1 = driver.getTitle();
			testStepPassed("Navigated to this page---" + mostPopualrTitle1);
			clickOnBackButton();
		}

	}

	/**
	 * Verify video on home page.
	 */
	public void verifyVideoOnHomePage() {

		testStepInfo("****************************Top Video***************************************");
		try {

			testStepPassed("Before Video plays");
			takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
			waitTime(3);
			boolean playButton = elementPresent(OR.btn_Home_Page_Video_Play_button);
			if (playButton == true) {
				clickOn(OR.btn_Home_Page_Video_Play_button);
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

	/**
	 * Verify ad displayed in home page.
	 */
	public void verifyAdDisplayedInHomePage() {

		boolean topAds = elementPresent(OR.adsHomePageTopAds);
		if (topAds == true) {
			testStepInfo("*********************************Top Ad***********************************************");
			waitForElement(OR.adsHomePageTopAds);
			takeAdScreenshot(webElement, "Top Ads");
		}
		boolean recAds = elementPresent(OR.adsHomePageRecAds);
		if (recAds == true) {
			testStepInfo("*********************************Rec Ad***********************************************");
			waitForElement(OR.adsHomePageRecAds);
			takeAdScreenshot(webElement, "Rec Ads");
		}
		boolean topxAds = elementPresent(OR.adsHomePageTopxAds);
		if (topxAds == true) {
			testStepInfo("*********************************Topx Ad***********************************************");
			waitForElement(OR.adsHomePageTopxAds);
			takeAdScreenshot(webElement, "Topx Ads");
		}

	}

	/**
	 * Validate most read.
	 */
	public void validateMostRead() {
		testStepInfo("********************************* Most Read **************************************");

		try {
			waitForElement(OR.txt_Most_Popular_Page_Most_Read);
			// scrollToElement(OR.txt_Most_Popular_Page_Most_Read);
			scrollBy(0, 300);

			// clickOn(OR.txt_Most_Popular_Page_Most_Read);
			boolean mostRead = elementPresent(OR.txt_Most_Popular_Page_Most_Read);
			if (mostRead == true) {
				String mostReadLink = getText(OR.txt_Most_Popular_Page_Most_Read);
				testStepPassed(mostReadLink);
				testStepPassed("Most Read is displayed");
			} else {
				testStepPassed("Most Read is not displayed");
			}
			// clickOnBackButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		// testStepPassed("Most Read are displayed");

	}

	/**
	 * Gets the current window handle.
	 *
	 * @return the current window handle
	 */
	public String getCurrentWindowHandle() {
		String windowHandle = null;
		try {
			windowHandle = driver.getWindowHandle();
			writeToLogFile("INFO", "Get Current Window Handle: " + windowHandle);

		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return windowHandle;
	}

	/**
	 * Switch to window using title.
	 *
	 * @param windowTitle
	 *            the window title
	 * @return the boolean
	 */
	public Boolean switchToWindowUsingTitle(String windowTitle) {
		Boolean flag = false;
		String title = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				title = driver.getTitle();
				if (title.equals("Microsoft Dynamics CRM")) {
					new WebDriverWait(driver, elementLoadWaitTime)
							.until(ExpectedConditions
									.titleContains(" - Microsoft Dynamics CRM"));
				}
				title = driver.getTitle();
				writeToLogFile("INFO", "Window Title: " + title);
				if (title.equalsIgnoreCase(windowTitle)
						|| title.startsWith(windowTitle)) {
					writeToLogFile("INFO", "Switched to window: " + windowTitle);
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowTitle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	/**
	 * Switch to window using handle.
	 *
	 * @param windowHandle
	 *            the window handle
	 * @return the boolean
	 */
	public Boolean switchToWindowUsingHandle(String windowHandle) {
		Boolean flag = false;
		String handle = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				handle = driver.getWindowHandle();
				writeToLogFile("INFO", "Window Title: " + handle);
				if (handle.equals(windowHandle)) {
					writeToLogFile("INFO", "Switched to window: "
							+ windowHandle);
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowHandle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	/**
	 * Close window.
	 *
	 * @param windowHandle
	 *            the window handle
	 * @return the boolean
	 */
	public Boolean closeWindow(String windowHandle) {
		Boolean flag = false;
		String handle = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				handle = driver.getWindowHandle();
				writeToLogFile("INFO", "Window Title: " + handle);
				if (handle.equals(windowHandle)) {
					writeToLogFile("INFO", "Switched to window: "
							+ windowHandle);
					driver.close();
					writeToLogFile("INFO", windowHandle + "Window is closed");
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowHandle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	public void validateTopAds() {
		testStepPassed("Top Ads is present");
		try {
			boolean topAds = elementPresent(OR.adsHomePageTopAds);
			if (topAds == true) {
				manualScreenshot(OR.adsHomePageTopAds);
			} else {
				testStepPassed("Top Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateRecAds() {
		testStepPassed("Rec Ads is present");
		try {
			boolean topAds = elementPresent(OR.adsHomePageRecAds);
			if (topAds == true) {
				takeAdScreenshot(OR.adsHomePageRecAds, "Rec Ads");
			} else {
				testStepPassed("Rec Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateRailRecAds() {
		testStepPassed(" Rail Rec Ads is present");
		try {
			boolean topAds = elementPresent(OR.ads_New_Posts_RailRec_Ads);
			if (topAds == true) {
				takeAdScreenshot(OR.ads_New_Posts_RailRec_Ads, "Rec Ads");
			} else {
				testStepPassed("Rail Rec Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateTextAds() {
		testStepPassed(" Text Ads is present");
		try {
			boolean topAds = elementPresent(OR.ads_New_Posts_Text_Ads);
			if (topAds == true) {
				takeAdScreenshot(OR.ads_New_Posts_Text_Ads, "Rec Ads");
			} else {
				testStepPassed("Text Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateLogeAds() {
		testStepPassed(" Loge Ads is present");
		try {
			boolean topAds = elementPresent(OR.ads_New_Posts_Loge_Ads);
			if (topAds == true) {
				takeAdScreenshot(OR.ads_New_Posts_Loge_Ads, "Rec Ads");
			} else {
				testStepPassed("Loge Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void validateHeading() {
		try {
			boolean forbesLists = elementPresent(OR.txt_Most_Popular_Page_Heading);
			if (forbesLists == true) {
				String forbesListsHeading = getText(OR.txt_Most_Popular_Page_Heading);
				testStepPassed("" + forbesListsHeading);
				clickOnBackButton();
			} else {
				testStepPassed(" Page is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyBottomAdsInMobile() {
		testStepInfo("******************************** Bottom Ads *****************************************");

		boolean mobileAds = elementPresent(OR.ads_Mob_Home_Page_Mobile_Ads);
		if (mobileAds == true) {
			takeAdScreenshot(OR.ads_Mob_Home_Page_Mobile_Ads, "Mobile Ads");
			testStepPassed("Mobile Ads is present");
		} else {
			testStepPassed("Mobile Ads is not present");
		}
	}

	public void verifyMostReadOnForbesInMobile() {
		testStepInfo("*************************** Most Read on Forbes ******************************************");
		scrollBy(0, 50);
		scrollToElement(OR.txt_Mob_Most_Popular_Most_Read);
		takeAdScreenshot(OR.txt_Mob_Most_Popular_Most_Read, "Most Read");
		waitTime(3);
		try {
			boolean mostReadNews = elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews == true) {
				testStepPassed("Most Read on Forbes News  is displayed");
			} else {
				testStepPassed("Most Read on Forbes News is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOn(OR.tab_Mob_Home_Page_Most_Read_People);
		try {
			boolean mostReadNews = elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews == true) {
				testStepPassed("Most Read on Forbes  People is displayed");
			} else {
				testStepPassed("Most Read on Forbes People is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOn(OR.tab_Mob_Home_Page_Most_Read_Places);
		try {
			boolean mostReadNews = elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews == true) {
				testStepPassed("Most Read on Forbes  Place is displayed");
			} else {
				testStepPassed("Most Read on Forbes Place is  not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOn(OR.tab_Mob_Home_Page_Most_Read_Companies);
		try {
			boolean mostReadNews = elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews == true) {
				testStepPassed("Most Read on Forbes Companies is displayed");
			} else {
				testStepPassed("Most Read on Forbes Companies is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify related topics in mob.
	 */
	public void verifyRelatedTopicsInMob() {
		testStepInfo("*************************** Related Topics ******************************************");
		try {
			scrollBy(0, 150);
			waitTime(3);
			boolean relatedTopics = elementPresent(OR.txt_Mob_Most_Popular_Related_Topics);
			if (relatedTopics == true) {
				testStepPassed("Related Topics are displayed");
			} else {
				testStepPassed("Related Topics are not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify real time ads.
	 */
	public void verifyRealTimeAds() {
		testStepInfo("************************************* Ads**********************************************");

		validateTopAds();
		validateRecAds();
		validateRailRecAds();
		validateTextAds();
		validateLogeAds();

	}

	// ************************************************* Sindhu Methods
	// **********************************************

	public void checkPostsOnBV() {
		int postCount = getElementCount(OR.txt_BVPage_Validation_BVPosts);
		if (!elementPresent(OR.txt_BVPage_Validation_BV6thPost)
				&& postCount == 5) {
			testStepInfo("*********************************Checking for show more button after 5th post***********************************************");
			System.out.println("Show more button is displayed after 5th post");
			testStepPassed("BV Page validation (BV PostStream Showmore Button displayed after - "
					+ postCount + " posts");
			clickOn(OR.txt_BVPage_Validation_showMoreButtonAfter5BVPosts);
			waitTime(3);
		}
	}

	public void checkadsOnBVArticlePage() {
		// testStepInfo("****************************Ads on Brand Voice Article Page********************************************");
		this.scrollBy(0, -60);
		clickOn(OR.txt_BVPage_Validation_BV61stPost);
		waitTime(3);
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe') and @loaded='1']"));
		int adCount = allAdLinks.size();
		System.out.println("adcount is  " + adCount);
		testStepInfo("*********************************AdCount Upon landing on BV article Page::"
				+ adCount + "***********************************************");
		this.scrollBy(0, 4000);
		waitTime(2);
		if (elementPresent(OR.txt_BVPage_Validation_recommendedbyBVlabel)) {
			testStepPassed("BV Page validation (BV Recommended by BV label is  displayed");
			takeAdScreenshot(OR.txt_BVPage_Validation_recommendedbyBVlabel,
					"BV Article Page");
		}
		List<WebElement> allAdLinksonScroll = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe') and @loaded='1']"));
		int adCountOnScroll = allAdLinksonScroll.size();
		System.out.println("adCountOnScroll is  " + adCountOnScroll);
		testStepInfo("*********************************AdCount Upon landing on BV article Page::"
				+ adCountOnScroll
				+ "***********************************************");
		if (adCount > adCountOnScroll) {
			testStepPassed("BV Page validation (BV Article page ad Count - "
					+ adCountOnScroll + " ads loaded on the page");
		}
	}

	public int getResponseCode(String urlString) throws MalformedURLException,
			IOException {
		URL url = new URL(urlString);
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		huc.setRequestMethod("GET");
		huc.connect();
		return huc.getResponseCode();
	}

	public void chekstatuscode() throws MalformedURLException, IOException {
		int statusCode;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			if (!(links.get(i).getAttribute("href") == null)
					&& !(links.get(i).getAttribute("href").equals(""))) {
				if (links.get(i).getAttribute("href").contains("http")) {
					statusCode = getResponseCode(links.get(i)
							.getAttribute("href").trim());
					if (statusCode == 403) {
						System.out.println("HTTP 403 Forbidden # " + i + " "
								+ links.get(i).getAttribute("href"));
					}
				}
			}
		}

	}

	public void isListDisplayed() {
		this.scrollBy(0, 30);
		List<WebElement> elements = driver.findElements(By
				.xpath("//div[@class='overlay-item-info']"));
		int count = elements.size();
		for (int i = 0; i < count; i++) {
			if (elements.get(i).isDisplayed()) {
				testStepPassed("Elements Check (Displayed - " + elements
						+ ":: " + i);
			}
		}

		elements.get(0).click();

		if (elementPresent((OR.txt_CSFPageCheck_overlayAd))
				&& elementPresent(OR.txt_CSFPageCheck_prevButtonOnOverlay)
				&& elementPresent(OR.txt_CSFPageCheck_nextButtonOnOverlay))

		{
			testStepPassed("CSF Page Check (CSF Overlay ad check- "
					+ elementPresent((OR.txt_CSFPageCheck_overlayAd))
					+ " slides are present in the gallery");
		}

		String closeButton = "close button on overlay#xpath=//i[@class='icon icon-close']";
		clickOn(closeButton);

	}

	public void checkImagesOnCSF() {
		List<WebElement> images = driver.findElements(By
				.xpath("//div[@class='block-image ratio16x9']"));
		for (int i = 0; i < images.size(); i++) {
			if (images.get(i).isDisplayed()) {
				testStepPassed("CSF Page Check (CSF images check- " + i
						+ " image is displayed");
			}
		}
	}

	public void checkvideosOnCSF() {
		List<WebElement> videos = driver.findElements(By
				.xpath("//div[contains(@class,'video-thumb ratio16x9')]"));
		for (int i = 0; i < videos.size(); i++) {
			if (videos.get(i).isDisplayed()) {
				testStepPassed("CSF Page Check (CSF videos check- " + i
						+ " video is displayed");
			}
		}
	}

	public void checkadsOnCSRPage() {
		waitTime(7);
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe') and @loaded='1']"));
		int adCount = allAdLinks.size();
		testStepInfo("*********************************AdCount on CSR Page::"
				+ adCount + "***********************************************");
		if (adCount > 0) {
			testStepPassed("CSR Page Check (CSR ads check- " + adCount
					+ " ads are displayed");
		}
	}

	// Sindhu Methods
	/**
	 * Verify ad displayed on BV home page.
	 */

	public void verifyBVPageAdsInDesktop() {
		testStepInfo("****************************Ads on Brand Voice Page********************************************");
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe') and @loaded='1']"));
		for (int k = 0; k < allAdLinks.size(); k++) {

			boolean isAdDisplayed = allAdLinks.get(k).isDisplayed();
			if (isAdDisplayed == true) {
				System.out.println("---->" + "" + (k + 1));
				testStepPassed("BV Page validation (BV Ads - " + (k + 1) + ")"
						+ isAdDisplayed);
			}
		}
	}

	/**
	 * Verify show more buttons on BV Page
	 */
	public void checkShowMoreCircleButtons() {
		testStepInfo("****************************Show more Buttons in Brand Voice Page********************************************");
		List<WebElement> allShowMoreButtons = driver.findElements(By
				.xpath("//div[@class='load-more']/div[@class='circle']"));
		for (int k = 0; k < allShowMoreButtons.size(); k++) {
			boolean areShowMoreButtonsDisplayed = allShowMoreButtons.get(k)
					.isDisplayed();
			if (areShowMoreButtonsDisplayed == true) {
				System.out.println("---->" + "" + (k + 1));
				testStepPassed("BV Page validation (BV ShowMore Buttons - "
						+ "" + (k + 1) + ")" + areShowMoreButtonsDisplayed);
			}
		}
	}

	public void CheckMobileAd(String strXpath) {
		testStepInfo("*********************************Mobile Gallery ad Check**********************************");
		if (elementPresent(strXpath)) {
			testStepPassed("Mobile Gallery Check (Mobile Gallery sticky ad is displayed on the page");
		} else {
			testStepPassed("Mobile Gallery Check (Mobile Gallery sticky ad is not displayed on the page");
		}
	}

	/**
	 * Verify ads displayed on template gallery page
	 */
	public void checkAdsonTemplateGallery() {
		testStepInfo("****************************Ads on Template gallery Page********************************************");
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe') and @title='3rd party ad content']"));
		if (allAdLinks.size() > 0) {
			testStepInfo("*********************************Ads on the gallery page***********************************************");
			testStepPassed("Gallery Check (Gallery Ads check - "
					+ allAdLinks.size() + " ads are displayed on the page");
		} else {
			testStepPassed("Gallery Check (Gallery Ads check - "
					+ allAdLinks.size() + " ads are displayed on the page");
		}
	}

	/**
	 * Verify ads displayed on angular gallery page
	 */
	public void checkAdsonAngularGallery() {
		testStepInfo("*********************************Ads on Angular Gallery Check**********************************");
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe') and @title='3rd party ad content']"));
		if (allAdLinks.size() > 0) {
			testStepInfo("*********************************Ads on the Angular gallery page***********************************************");
			testStepPassed("Angular Gallery Check (Angular Gallery Ads check - "
					+ allAdLinks.size() + " ads are displayed on the page");
		} else {
			testStepPassed("Angular Gallery Check (Angular Gallery Ads check - "
					+ allAdLinks.size() + " ads are displayed on the page");
		}
	}

	/**
	 * Check the images from gallery
	 */
	public void checkImagesInGallery(String slidecount, String nexticon) {
		testStepInfo("*********************************Check the pictures from the gallery**********************************");
		String SlideCount = getText(slidecount);
		String[] parts = SlideCount.split(" of ");
		int toalSlideCount = Integer.valueOf(parts[1]);
		if (toalSlideCount != 0) {
			testStepPassed("Gallery Check (Gallery images slide check- "
					+ toalSlideCount + " slides are present in the gallery");
		} else {
			testStepInfo("*********************************Number of pictures in gallery is "
					+ toalSlideCount + "**********************************");
		}
		for (int i = 1; i < 4; i++) {
			int currentSlideNum = Integer.valueOf(parts[0]);
			waitTime(5);
			clickOn(nexticon);
			testStepPassed("Gallery Check (Clicked on - " + currentSlideNum
					+ "  slide");
		}
	}

	public void isListDisplayed(String strXpath) {
		this.scrollBy(0, 30);
		List<WebElement> elements = driver.findElements(By.xpath(strXpath));
		int count = elements.size();
		System.out.println("count of list items are " + count);
		for (int i = 0; i < count; i++) {
			if (elements.get(i).isDisplayed()) {
				testStepPassed("Elements Check (Displayed - " + elements
						+ ":: " + i);
			}
		}

		elements.get(0).click();

		if (elementPresent((OR.txt_CSFPageCheck_overlayAd))
				&& elementPresent(OR.txt_CSFPageCheck_prevButtonOnOverlay)
				&& elementPresent(OR.txt_CSFPageCheck_nextButtonOnOverlay))

		{
			testStepPassed("CSF Page Check (CSF Overlay ad check- "
					+ elementPresent((OR.txt_CSFPageCheck_overlayAd))
					+ " slides are present in the gallery");
		}

		String closeButton = "close button on overlay#xpath=//i[@class='icon icon-close']";
		clickOn(closeButton);
	}

	public void isListDisplayedOnMobile(String strXpath) {
		this.scrollBy(0, 30);
		List<WebElement> elements = driver.findElements(By.xpath(strXpath));
		int count = elements.size();
		System.out.println("count of list items are " + count);
		for (int i = 0; i < count; i++) {
			if (elements.get(i).isDisplayed()) {
				testStepPassed("Elements Check (Displayed - " + elements
						+ ":: " + i);
			}
			
		}
	}

}