package com.medimpact.paga.end.automation.cases;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.domain.MemoryData;
import com.medimpact.paga.end.automation.utils.HttpUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
public class ApproveSubTaskReviewTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(ApproveSubTaskReviewTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="NewSubTaskReJComUUid", groups="approveSubTask",description = "approve subTask")
	public void approveSubTask() throws Exception { 
		logger.info("approve subTask url："+configBeanPropUrl.getUri()+configBeanPropUrl.getApproveSubTask());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException{
		ObjectMapper mapper= new ObjectMapper();
		ObjectNode jsonObj = mapper.createObjectNode();	
		ArrayNode commentsArr = mapper.createArrayNode();
		ObjectNode commentsJson = mapper.createObjectNode();
		commentsJson.put("id", "");
		commentsJson.put("tkUuid",MemoryData.getCaseRelevanceData().getSubtaskid());
		commentsJson.put("message", "1111");
		commentsArr.add(commentsJson);
		
		ObjectNode selfPropsJson = mapper.createObjectNode();
		selfPropsJson.put("pkType", "guidlineSubTask");
		selfPropsJson.put("pkValue", MemoryData.getCaseRelevanceData().getPkValue());
		jsonObj.put("assignee", "wang");
		jsonObj.set("comments", commentsArr);
		jsonObj.put("defineKey", "SubtaskReview");
		jsonObj.set("selfProps", selfPropsJson);
		jsonObj.put("uuid",MemoryData.getCaseRelevanceData().getSubtaskRejcomuuid());
		
		String returnStr = HttpUtils.getPosttMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getApproveSubTask(), jsonObj);	
		return returnStr;
		  
	}

}
