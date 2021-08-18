package com.dmos.pages;



public class DashBoardPage  extends BasePage{
	private static final String GREETING_MSG = "/html/body/app-root/div/div[2]/app-dashboard/div/a[1]/div/h3";
	
	private static final String LOGOUT = "/html/body/app-root/div/div[1]/div[3]/a[2]";

	public String getGreetingMessage() {

		return waitFor(GREETING_MSG).$(GREETING_MSG).getText();
	}
	
	public BasePage logout() {
		
		
		waitFor(LOGOUT).$(LOGOUT).click();
		
		return this.switchToPage(BasePage.class);
		
	}
	
}
