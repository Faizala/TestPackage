package csrPageCheck;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class CSRPageFunctionality extends ApplicationKeywords{
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
	public CSRPageFunctionality(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public CSRPageFunctionality() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyCSRpageContents(){
		testStepInfo("*********************************CSR Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.startsWith("Desktop")) {

			verifyCSRPageContentsInDesktop();

		} else {
			verifyCSRPageContentsInMobile();
		}
	}
	
	public void checkadsOnCSRPage(){
		testStepInfo("*********************************Ads check on CSR Page***********************************************");
		waitTime(7);
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe') and @loaded='1']"));
		int adCount = allAdLinks.size();
		testStepInfo("*********************************AdCount on CSR Page::"+adCount+"***********************************************");
		if(adCount>0){
			testStepPassed("CSR Page Check (CSR ads check- "+adCount+" ads are displayed");
		}
	}
	
	public void verifyCSRPageContentsInDesktop(){
		checkadsOnCSRPage();
		checkCSRpageContents();
	}
	
	public void verifyCSRPageContentsInMobile(){
		checkIconsOnMobileView();
		CheckMobileAd(OR.ad_MobileCSFPageCheck_Stickymobilead);
		checkadsOnCSRPage();
		checkCSRpageContents();
	}
	
	public void checkIconsOnMobileView(){
		testStepInfo("*********************************Mobile Search/Share icons check**********************************");
		if(elementPresent(OR.txt_CSRPageCheck_hamburgerIcon) &&
			elementPresent(OR.icon_MobileCheck_shareSymbol) &&
			elementPresent(OR.icon_MobileCheck_searchSymbol)){
			testStepPassed("Mobile Page Check (mobile icons Check- Search and share icons are displayed");
		}
		else{
			testStepPassed("Mobile Page Check (mobile icons Check- Search and share icons are not displayed");
		}
	}
	
	public void checkCSRpageContents(){
		testStepInfo("*********************************CSCR page Contents Check**********************************");
		this.scrollBy(0, 1000);
		List<WebElement> articleStream = driver.findElements(By.xpath("//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']"));
		int streamcount = articleStream.size();
		if(elementPresent(OR.txt_CSRPageCheck_hamburgerIcon) && 
			streamcount==10 && 
			elementPresent(OR.txt_CSRPageCheck_seemorebutton) &&
			elementPresent(OR.txt_CSRPageCheck_trendingNow)){
			testStepPassed("CSR Page Check (CSR seemore button check- "+elementPresent(OR.txt_CSRPageCheck_seemorebutton)+":: See More Button is displayed");
		}
		if(elementPresent(OR.txt_CSRPageCheck_trendingNowNextScroll)){
			testStepInfo("*********************************CSR Trending now scroll**********************************");
			clickOn(OR.txt_CSRPageCheck_trendingNowNextScroll);
		}
	}

}
