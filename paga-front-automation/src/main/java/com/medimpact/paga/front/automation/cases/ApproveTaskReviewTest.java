package com.medimpact.paga.front.automation.cases;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.medimpact.paga.front.automation.page.MyWorkbenchPage;
import com.medimpact.paga.front.automation.page.TaskReviewPage;
@SpringBootTest
public class ApproveTaskReviewTest extends BaseTest{
	private MyWorkbenchPage myWorkbenchPage;
	
	@Autowired
    private CommonCase publicTest;
	
	@Test(description = "login")
	public void login(){
		publicTest.login(driver,"wang","1111","My Workbench");				
	}
	
	@Test(dependsOnMethods = "login",description = "task Submission Deployed")
	public void approveTaskReview() throws InterruptedException{
		//click Tasks on the Review list one
		myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		myWorkbenchPage.click_Tasks_on_the_Review_list_one();
		//click comments button
		TaskReviewPage taskReviewPage = PageFactory.initElements(driver,TaskReviewPage.class);
		taskReviewPage.click_comment();
		//input comments
		taskReviewPage.input_comment("task Review Comments");
		//click Complete
		taskReviewPage.click_comment_button();
		Thread.sleep(1000);
		//input Assign to
		taskReviewPage.input_Assign_to("wang");
		Thread.sleep(1000);
		//click Assign
		taskReviewPage.click_Assign_button();
		Thread.sleep(2000);
		//get My_Workbench text
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");	
		
	}

}
