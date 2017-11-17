package galleryCheck;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.httpclient.util.HttpURLConnection;
import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class GalleryPageFunctionalityCheck extends ApplicationKeywords{
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
	public GalleryPageFunctionalityCheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public GalleryPageFunctionalityCheck() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyTemplateGallery() {
		testStepInfo("*********************************Gallery Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.startsWith("Desktop")) {

			verifyTemplateGalleryOnDesktop();

		} else {
			verifyTemplateGalleryOnMobile();
		}
	}
	
	public void verifyAngularGallery(){
		testStepInfo("*********************************Angular Gallery Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.startsWith("Desktop")) {

			verifyAngularGalleryOnDesktop();

		} else {
			verifyAngularGalleryOnMobile();
		}
	}
	
	public void swipe()
    {  
		for(int i=1;i<6;i++){
		scrollBy(1000,0);
		}
     }
	
	public void CheckMobileAd(){
		testStepInfo("*********************************Mobile Gallery ad Check**********************************");
		if(elementPresent(OR.txt_GalleryCheck_mobileStickyAd)){
			testStepPassed("Mobile Gallery Check (Mobile Gallery sticky ad is displayed on the page");
		}
		else{
			testStepPassed("Mobile Gallery Check (Mobile Gallery sticky ad is not displayed on the page");
		}
	}
	
	public void swipeSlides(){
		testStepInfo("*********************************Mobile Gallery swipe Slides**********************************");
		swipe();
	}
	public void verifyTemplateGalleryOnDesktop(){
		checkTopAdOnTemplateGallery();
		checkAdsonTemplateGallery();
		viewTemplateGallerySlides();
	}
	
	public void checkTopAdOnTemplateGallery(){
		boolean isTopAdDisplayed = elementPresent(OR.txt_GalleryCheck_LeaderBoard);
		if(isTopAdDisplayed){
			testStepInfo("*********************************Top Leaderboard Ad***********************************************");
			testStepPassed("Gallery Check (Gallery Top Leaderboard Ad is displayed- "+ isTopAdDisplayed);
		}
		else{
			testStepPassed("Gallery Check (Gallery Top Leaderboard Ad is not displayed- "+ isTopAdDisplayed);
		}
	}
	
	public void viewTemplateGallerySlides(){
		boolean isImageBoxDisplayed = elementPresent(OR.txt_GalleryCheck_ImagesBox);
		boolean isNextIconDisplayed = elementPresent(OR.txt_GalleryCheck_nextIcon);
		if(isImageBoxDisplayed &&
				isNextIconDisplayed){
			testStepPassed("Gallery Check (Gallery imageBox is displayed on the page");
		}
		else{
			testStepPassed("Gallery Check (Gallery imageBox is not displayed on the page");
		}
		checkImagesInGallery(OR.txt_GalleryCheck_SlideCount,OR.txt_GalleryCheck_nextIcon);
	}
	
	public void verifyTemplateGalleryOnMobile(){	
		CheckMobileAd(OR.txt_GalleryCheck_mobileStickyAd);
		swipeSlides();
	}
	
	public void verifyAngularGalleryOnDesktop(){
		testStepInfo("*********************************Angular Gallery Check**********************************");
		checkTopAdOnAngularGallery();
		checkAdsonAngularGallery();
		viewAngularGallerySlides();
	}
	
	public void checkTopAdOnAngularGallery(){
		testStepInfo("*********************************Top Ad Angular Gallery Check**********************************");
		boolean isTopAdDisplayed = elementPresent(OR.txt_AngularGalleryCheck_LeaderBoard);
		if(isTopAdDisplayed){
			testStepInfo("*********************************Top Leaderboard Ad***********************************************");
			testStepPassed("Angular Gallery Check (Angular Gallery Top Leaderboard Ad is displayed- "+ isTopAdDisplayed);
		}
		else{
			testStepPassed("Angular Gallery Check (Angular Gallery Top Leaderboard Ad is not displayed- "+ isTopAdDisplayed);
		}
	}
	
	public void viewAngularGallerySlides(){
		testStepInfo("*********************************Slides on Angular Gallery**********************************");
		if(elementPresent(OR.txt_AngularGalleryCheck_ImagesBox) && 
				elementPresent(OR.txt_AngularGalleryCheck_nextIcon)){
			testStepPassed("Angular Gallery Check (Gallery imageBox is displayed on the page");
		}
		else{
			testStepPassed("Angular Gallery Check (Not an angular Gallery");
		}
		checkImagesInGallery(OR.txt_AngularGalleryCheck_SlideCount,OR.txt_AngularGalleryCheck_nextIcon);
	}
	
	public void verifyAngularGalleryOnMobile(){
		
	}
	public int getResponseCode(String urlString) throws MalformedURLException, IOException{
	    URL url = new URL(urlString);
	    HttpURLConnection huc = (HttpURLConnection)url.openConnection();
	    huc.setRequestMethod("GET");
	    huc.connect();
	    return huc.getResponseCode();
	}
}
