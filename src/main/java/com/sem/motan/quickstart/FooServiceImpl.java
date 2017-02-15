/**
 * 
 */
package com.sem.motan.quickstart;

/**   
 * @Title: FooServiceImpl.java 
 * @Package com.sem.motan.quickstart 
 * @Description: 
 * @author brook.xu
 * @date 2017年1月9日 下午3:58:14 
 * @version V1.0   
 */
public class FooServiceImpl implements FooService{
	public String hello(String name) {
        System.out.println(name + " invoked rpc service");
        return "hello " + name;
    }
}
