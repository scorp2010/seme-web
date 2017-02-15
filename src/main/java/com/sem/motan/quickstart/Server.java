/**
 * 
 */
package com.sem.motan.quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;

/**   
 * @Title: Server.java 
 * @Package com.sem.motan.quickstart 
 * @Description: 
 * @author brook.xu
 * @date 2017年1月9日 下午4:05:42 
 * @version V1.0   
 */
public class Server {
	public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/motan_server.xml");
        System.out.println("server start...");
        
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER,true);
        System.out.println("open switch..");
    }
}
