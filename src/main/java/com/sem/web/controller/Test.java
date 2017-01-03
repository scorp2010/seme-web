/**
 * 
 */
package com.sem.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

/**   
 * @Title: Test.java 
 * @Package com.sem.web.controller 
 * @Description: 
 * @author brook.xu
 * @date 2016年12月22日 下午5:12:05 
 * @version V1.0   
 */
@RestController
public class Test {
	private static final Logger logger=LoggerFactory.getLogger(Test.class);

	@RequestMapping(value="/test")
	@ResponseBody
	public String test(HttpServletRequest request){
		logger.info("spring boot success");
		return "test";
	}
	
	@RequestMapping(value="/index")
	@ResponseBody
	public String getVideoIndex(HttpServletRequest request){
		logger.info("index-------------------");
		Map<String, String> retMap=new HashMap<>();
		retMap.put("url", "video/tweetsip.mp4");
		
		return JSON.toJSONString(retMap);
		
	}
}
