/**
 * 
 */
package com.sem.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
