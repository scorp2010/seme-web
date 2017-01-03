package org.sem.java8;
/**
 * 
 */

import java.util.Arrays;

/**   
 * @Title: xx.java 
 * @Package  
 * @Description: 
 * @author xuy
 * @date 2016年12月18日 下午5:33:44 
 * @version V1.0   
 */
public class java8 {
	public static void main(String[] args) {
		String separator=",";
		Arrays.asList("a", "b", "d").forEach( (String e) -> 
		{	
			System.out.println(e+separator);
			System.out.println(e);
		});
		
		Arrays.asList("a", "b", "d").sort(( e1,e2 ) -> e1.compareTo(e2));
		
	}
}
