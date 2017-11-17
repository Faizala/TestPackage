/**
 * Validate Author info & image
 * Article Ads
 * Social sharing

 */
package articlePage;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * class names are written in mixed case with the first letter of each internal
 * word capitalized.
 */
public class ArticlePageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Article Page Validation
	// Created by :Shakira
	// Created on :9 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new article page validation.
	 *
	 * @param obj the obj
	 */
	public ArticlePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify ads in article page. methods are written in mixed case with the
	 * first letter lower case, with the first letter of each internal word
	 * capitalized. variables are written in mixed case with the first letter
	 * lower case, with the first letter of each internal word capitalized.
	 */
	public void verifyAdsInArticlePage() {

		// String nextArticleInDesktop =
		// "Next Article#xpath=//article[@id='article-container-1']//header//h1";
		// String nextArticleInMobile =
		// "Next Article#xpath=//article[@id='article-container-1']//div[@class='article-text ng-scope']//h3";
		String articleText = null;
		// String articleHeader =
		// "Article Page#xpath=//article[@id='article-container-0']//header";
		try {

			if (currentExecutionMachineName.startsWith("Desktop_1_2")) {
				waitForText("Today's Top Stories");
				waitTime(2);
				clickOnMainArticle();
				validateAuthorDetailsForDesktop();
				validateShare();
				validateAds();
				/*
				 * verifyAdsInDesktopArticle();
				 * testStepPassed(" Scrolled down to Next Article");
				 * scrollToElement(nextArticleInDesktop);
				 * manualScreenshot("Next Article");
				 */

			} else {
				waitForText("Top Stories");
				clickOnMainArticle();
				validateSocialShare();
				validateAuthorDetailsForMobile();
				verifyeFullBioInArticlePage();
				verifyAdsInMobileArticle();
				scrollToElement(OR.txt_Article_Page_Next_Article);
				scrollBy(0, -60);
				articleText = getText(OR.txt_Article_Page_Next_Article);
				clickOn(OR.txt_Article_Page_Next_Article);
				testStepPassed("Article Text: "
						+ getText(OR.txt_Article_Page_Article_Header));
				verifyPageShouldContainText(articleText);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validate share.
	 */
	public void validateShare() {
		testStepInfo("******************************* Share ****************************************");
		try {
			clickOn(OR.txt_Article_Page_Share);
			boolean facebook=elementPresent(OR.img_Article_Page_Social_Share);
			if(facebook==true)
			{
			
				clickOn(OR.img_Article_Page_Social_Share);
				testStepPassed("Social Shares are displayed");
			}
			else
			{
				testStepPassed("Social Shares are not displayed");
			}
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

			clickOn(OR.txt_Article_Page_Share);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate author details.
	 */
	public void validateAuthorDetailsForDesktop() {
		testStepInfo("***************************Author Information*************************");
		String authorName = getText(OR.txt_Article_Page_Author_Name);
		testStepPassed("Author Name is ---" + authorName);
		boolean varContributor = elementPresent(OR.img_Article_Page_Contributor);
		if (varContributor == true) {
			testStepPassed("Image is displayed with Author Details");
		} else {
			testStepPassed("Image is not displayed");
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
	 * Validate ads.
	 */
	public void validateAds() {
		testStepInfo("***************************************Article Ads******************************");
		WebElement topAds = driver.findElement(By
				.xpath("//div[@id='top-fbs-ad-article-0']"));
		takeAdScreenshot(topAds, "Top Article");

		int adsCount = 1;
		for (adsCount = 1; adsCount <= 3; adsCount++) {
			waitTime(3);
			String article = "Article#xpath=//article[@id='article-container-0']//div[@ng-repeat-start='ad_unit in ad_units']["
					+ adsCount + "]";
			takeAdScreenshot(article, "article");
		}
		/*
		 * WebElement topAdsSec=driver.findElement(By.xpath(
		 * "//article[@id='article-container-1']//div[@id='top-fbs-ad-article-sticky-1']"
		 * )); takeAdScreenshot(topAdsSec, "Sec Top Ads");
		 */
	}

	// Start Date : 21 June 2016

	/**
	 * Verifye full bio in article page.
	 */
	public void verifyeFullBioInArticlePage() {
		testStepInfo("************************************************** Full Bio  ****************************************************");
		try {
			clickOn(OR.btn_Mob_Article_Page_Full_Bio);
			String fullBioDetails = getText(OR.txt_Mob_Article_Page_Full_Bio_Details);
			testStepPassed(fullBioDetails);
			scrollBy(0, 200);
			clickOn(OR.btn_Mob_Article_Page_Full_Bio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate author details for mobile.
	 */
	public void validateAuthorDetailsForMobile() {
		testStepInfo("************************************************** Author Details  ****************************************************");
		try {
			boolean authorName = elementPresent(OR.txt_Mob_Article_Page_Author_Name);
			if (authorName == true) {

				String varAuthorName = getText(OR.txt_Mob_Article_Page_Author_Name);
				testStepPassed("Author Name is -" + varAuthorName);

			} else {
				testStepPassed("Article page is not loaded properly");
			}
			boolean authorImage = elementPresent(OR.img_Article_Page_Contributor);
			if (authorImage == true) {
				takeAdScreenshot(OR.img_Article_Page_Contributor,
						"Author Image");
			} else {
				testStepPassed("Image is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Validate social share.
	 */
	public void validateSocialShare() {
		try {
			testStepInfo("************************************************** Social Share ****************************************************");
			waitTime(3);
			clickOn(OR.img_Mob_Article_Page_Share_Icon);

			boolean shareFacebook = elementPresent(OR.img_Mob_Article_Page_Facebook);
			if (shareFacebook == true) {
				testStepPassed("Social Share Facebook is available");
			} else {
				testStepPassed("Social Share are not loaded properly");
			}
			clickOn(OR.img_Mob_Article_Page_Share_Icon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Validate contributor page.
	 */
	public void validateContributorPage() {
		testStepInfo("************************************************** Contributor Page ****************************************************");
		clickOnMainArticle();
		clickOn(OR.img_Article_Page_Contributor);
		String contributor = getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);

		testStepPassed("Navigated to Contributor Page--" + contributor);
		clickOnBackButton();
		clickOn(OR.txt_Article_Page_Author_Name);
		String contributorName = getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
		testStepPassed("Navigated to Contributor Page--" + contributorName);
		// clickOnBackButton();
		clickOn(OR.btn_Contributor_Page_Full_Bio);
		String fullBio = getText(OR.txt_Contributor_Page_Full_Bio_Details);
		testStepPassed(fullBio);
		clickOn(OR.btn_Contributor_Page_Full_Bio);
		mouseOver(OR.btn_Contributor_Page_Follow);

		manualScreenshot(OR.btn_Contributor_Page_Follow);
	}

}
