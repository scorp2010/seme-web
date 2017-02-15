/**
 * 
 */
package com.sem.motan.quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**   
 * @Title: Client.java 
 * @Package com.sem.motan.quickstart 
 * @Description: 
 * @author brook.xu
 * @date 2017年1月9日 下午5:20:34 
 * @version V1.0   
 */
public class Client {
	public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/motan_client.xml");
        FooService service = (FooService) ctx.getBean("remoteService");
        System.out.println(service.hello("motan"));
    }
}
