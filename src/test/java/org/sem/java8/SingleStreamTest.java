/**
 * 
 */
package org.sem.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**   
 * @Title: SingleStreamTest.java 
 * @Package org.sem.java8 
 * @Description: 
 * @author brook.xu
 * @date 2017年1月3日 下午4:36:02 
 * @version V1.0   
 */
public class SingleStreamTest {
	 public static void main(String args[]) throws Exception {
	        SingleStreamTest test = new SingleStreamTest();
	        test.executeTasks();
	    }

	    void executeTasks() throws Exception {
	        final List<Integer> firstRange = buildIntRange();

	        firstRange.parallelStream().forEach((number) -> {
	            try {
	                // do something slow
	                Thread.sleep(5);
	            } catch (InterruptedException e) { }
	        });
	    }

	    private List<Integer> buildIntRange() {
	        List<Integer> numbers = new ArrayList<>(5);
	        for (int i=0; i<6000; i++)
	            numbers.add(i);
	        return Collections.unmodifiableList(numbers);
	    }
}
