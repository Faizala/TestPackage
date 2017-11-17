package csfPageCheck;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class CSFPageFunctionality extends ApplicationKeywords{
	
	
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
	public CSFPageFunctionality(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public CSFPageFunctionality() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyCSFpageContents(){
		testStepInfo("*********************************CSF Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.startsWith("Desktop")) {

			verifyCSFPageContentsInDesktop();

		} else {
			verifyCSFPageContentsInMobile();
		}
	}
	
	public void checkAdOnCSF(){
		waitTime(3);	
		int adCount = getElementCount(OR.ads_CSFPageCheck_allAdsOnCSF);
		System.out.println("adcount is  "+adCount);
		testStepInfo("*********************************AdCount Upon landing on  CSF Page::"+adCount+"***********************************************");
		if(adCount!=0){
			testStepPassed("CSF Page Check (CSF Ads check - "+ adCount+" ads are displayed on the page");
		}
	}
	
	public void checkImagesOnCSF(){
		testStepInfo("*********************************Images check on CSF Page***********************************************");
		List<WebElement> images = driver.findElements(By.xpath("//div[@class='block-image ratio16x9']"));
		for(int i=0;i<images.size();i++){
			if(images.get(i).isDisplayed()){
				 testStepPassed("CSF Page Check (CSF images check- "+i+" image is displayed");
			}
		}	
	}
	public void checkvideosOnCSF(){
		testStepInfo("*********************************Videos check on CSF Page***********************************************");
		List<WebElement> videos = driver.findElements(By.xpath("//div[contains(@class,'video-thumb ratio16x9')]"));
		for(int i=0;i<videos.size();i++){
			if(videos.get(i).isDisplayed()){
				 testStepPassed("CSF Page Check (CSF videos check- "+i+" video is displayed");
			}
		}	
	}
	public void verifyCSFPageContentsInDesktop(){
		checkAdOnCSF();
		isListDisplayed(OR.txt_CSFPageCheck_overlay);
		checkImagesOnCSF();
		checkvideosOnCSF();
	}
	
	
	public void verifyCSFPageContentsInMobile(){
		checkAdOnCSF();
		CheckMobileAd(OR.ad_MobileCSFPageCheck_Stickymobilead);
		this.scrollBy(0, 1000);
		isListDisplayedOnMobile("//span[@class='more']");
		checkImagesOnCSF();
		checkvideosOnCSF();
		
	}
}
