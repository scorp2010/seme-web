package org.sem.java8;
/**
 * 
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
//		String separator=",";
//		Arrays.asList("a", "b", "d").forEach( (String e) -> 
//		{	
//			System.out.println(e+separator);
//			System.out.println(e);
//		});
//		
//		Arrays.asList("a", "b", "d","a").sort(( e1,e2 ) -> e1.compareTo(e2));
		
//	    Stream<String> uuidStream = Stream.generate(() -> UUID.randomUUID().toString());
//	    uuidStream.forEach(System.out::println);
	    
	    Map<String, List<Integer>> numbersPerThread = IntStream.rangeClosed(1, 11160)
                .parallel()
                .boxed()
                .collect(Collectors.groupingBy(i -> Thread.currentThread().getName()));

        numbersPerThread.forEach((k, v) -> System.out.println(String.format("%s >> %s", k, v)));
	}
}
