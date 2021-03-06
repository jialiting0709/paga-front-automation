package com.medimpact.paga.end.automation.cases;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

@SpringBootTest
public class ApproveTaskTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(ApproveTaskTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="newTaskReviewUUid", groups="approveTaskReview",description = " approve task review")
	public void approveSubTask() throws Exception { 
		logger.info("approve Task review url："+configBeanPropUrl.getUri()+configBeanPropUrl.getApproveTask());
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
		commentsJson.put("tkUuid",MemoryData.getCaseRelevanceData().getNewReviewtaskuuid());
		commentsJson.put("message", "321");
		commentsArr.add(commentsJson);
		
		ObjectNode selfPropsJson = mapper.createObjectNode();
		selfPropsJson.set("deadLine",selfPropsJson.nullNode());
		selfPropsJson.set("owner", selfPropsJson.nullNode());
		selfPropsJson.put("pkType", "guidlineTask");
		selfPropsJson.put("pkValue",MemoryData.getCaseRelevanceData().getPkValue());
		jsonObj.put("assignee", "wang");
		jsonObj.set("comments", commentsArr);
		jsonObj.put("defineKey", "TaskReview");
		jsonObj.set("dueDate",jsonObj.nullNode());
		jsonObj.set("selfProps", selfPropsJson);
		jsonObj.put("uuid",MemoryData.getCaseRelevanceData().getNewReviewtaskuuid());
		
		String returnStr = HttpUtils.getPosttMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getApproveTask(),jsonObj);	
		return returnStr;
		  
	}

}
