package bvPageCheck;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class BVPageFunctions extends ApplicationKeywords{
	
	/** The obj. */
	BaseClass obj;

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
	 * Instantiates  BVPage Functions
	 *
	 * @param obj
	 *            the obj
	 */
	public BVPageFunctions(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public BVPageFunctions() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyBVpageContents(){
		testStepInfo("*********************************BV Page validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.startsWith("Desktop")) {

			verifyBVPageContentsInDesktop();

		} else {
			verifyBVPageContentsInMobile();
		}
	}
	
	/**
	 * check the posts on BV page
	 */
	public void checkPostsOnBV(){
		testStepInfo("*********************************Verifying posts on BV page**********************************");
		int postCount = getElementCount(OR.txt_BVPage_Validation_BVPosts);
		if(!elementPresent(OR.txt_BVPage_Validation_BV6thPost) &&
				postCount==5){
		testStepInfo("*********************************Checking for show more button after 5th post***********************************************");
		System.out.println("Show more button is displayed after 5th post");
		testStepPassed("BV Page validation (BV PostStream Showmore Button displayed after - " + postCount+" posts");
		clickOn(OR.txt_BVPage_Validation_showMoreButtonAfter5BVPosts);
		waitTime(3);
		}
	}
	
	/**
	 * Verify ads on BV article page
	 */
	public void checkadsOnBVArticlePage(){
		testStepInfo("****************************Ads on Brand Voice Article Page********************************************");
		this.scrollBy(0, -60);
		clickOn(OR.txt_BVPage_Validation_BV61stPost);
		waitTime(3);
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe') and @loaded='1']"));
		int adCount = allAdLinks.size();
		System.out.println("adcount is  "+adCount);
		testStepInfo("*********************************AdCount Upon landing on BV article Page::"+adCount+"***********************************************");
		this.scrollBy(0, 4000);
		waitTime(2);
		if(elementPresent(OR.txt_BVPage_Validation_recommendedbyBVlabel))
		{
			testStepPassed("BV Page validation (BV Recommended by BV label is  displayed");
			takeAdScreenshot(OR.txt_BVPage_Validation_recommendedbyBVlabel, "BV Article Page");
		}
		List<WebElement> allAdLinksonScroll = driver
		.findElements(By
				.xpath("//iframe[contains(@id,'google_ads_iframe') and @loaded='1']"));
		int adCountOnScroll = allAdLinksonScroll.size();
		System.out.println("adCountOnScroll is  "+adCountOnScroll);
		testStepInfo("*********************************AdCount Upon landing on BV article Page::"+adCountOnScroll+"***********************************************");
		if(adCount > adCountOnScroll){
			testStepPassed("BV Page validation (BV Article page ad Count - " + adCountOnScroll+" ads loaded on the page");
		}	
	}
	/*
	 * Verify BrandVoice page contents on Desktop
	 */
	public void verifyBVPageContentsInDesktop(){
		waitForElement(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
		Boolean varBVLabel = elementPresent(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
		Boolean varBVImageIcon = elementPresent(OR.txt_BVPage_Validation_Imageicon);
		Boolean varBVAboutLabel =  elementPresent(OR.txt_BVPage_Validation_Aboutheader);
		Boolean varBVourContributorsLabel =  elementPresent(OR.txt_BVPage_Validation_OurContributors);
		if(varBVLabel==true &&
			varBVImageIcon==true && 
			varBVAboutLabel==true &&
			varBVourContributorsLabel==true){
			testStepPassed("BV Page validation: Forbes BrandVoioce label/Image/About Header is displayed on the page"+varBVLabel);
		}
		else{
			testStepPassed("BV Page validation: Forbes BrandVoioce label/Image/About Header is not displayed on the page"+varBVLabel);
		}
		verifyBVPageAdsInDesktop();
		checkShowMoreCircleButtons();
		checkPostsOnBV();
		checkadsOnBVArticlePage();
	}
	
	public void verifyBVPageContentsInMobile(){
		testStepInfo("*********************************Mobile BV Page validation**********************************");
		waitForElement(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
		Boolean varBVLabel = elementPresent(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
		Boolean varBVImageIcon = elementPresent(OR.txt_BVPage_Validation_Imageicon);
		Boolean varBVAboutLabel =  elementPresent(OR.txt_BVPage_Validation_Aboutheader);
		Boolean varBVourContributorsLabel =  elementPresent(OR.txt_BVPage_Validation_OurContributors);
		if(varBVLabel==true &&
			varBVImageIcon==true && 
			varBVAboutLabel==true &&
			varBVourContributorsLabel==true){
			testStepPassed("BV Page validation: Forbes BrandVoioce label/Image/About Header is displayed on the page"+varBVLabel);
		}
		else{
			testStepPassed("BV Page validation: Forbes BrandVoioce label/Image/About Header is not displayed on the page"+varBVLabel);
		}
		verifyBVPageAdsInDesktop();
		checkShowMoreCircleButtons();
		if(elementPresent(OR.txt_Mob_BVPage_Validation_postsLabel) && elementPresent(OR.button_Mob_BVPage_Validation_Latest) && elementPresent(OR.button_Mob_BVPage_Validation_Archive)){
			testStepPassed("BV Mobile Page validation: Latest and Archive are displayed on the page");
			this.scrollBy(0,1700);
			clickOn(OR.button_Mob_BVPage_Validation_Archive);
			if(elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel) && elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabelPostCount)){
				testStepPassed("BV Mobile Page validation: Archive List is displayed");
			}
			else{
				testStepPassed("BV Mobile Page validation: Archive List is not displayed");
			}
		}
		else{
			testStepPassed("BV Mobile Page validation: Latest and Archive are displayed on the page");
		}
		clickOn(OR.button_Mob_BVPage_Validation_inactiveLatest);
		waitTime(2);
		this.scrollBy(0,1700);
		waitTime(3);
		testStepInfo("*********************************Clicking on show more button on BV page**********************************");
		clickOn(OR.txt_BVPage_Validation_showMoreButtonAfter5BVPosts);
		waitTime(3);
		checkadsOnBVArticlePage();
		
	}

}
