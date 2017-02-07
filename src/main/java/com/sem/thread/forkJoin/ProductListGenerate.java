/**
 * 
 */
package com.sem.thread.forkJoin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**   
 * @Title: ProductListGenerate.java 
 * @Package com.sem.thread.forkJoin 
 * @Description: 
 * @author xuy
 * @date 2016年12月18日 下午1:14:07 
 * @version V1.0   
 */
public class ProductListGenerate {
	private static final Logger logger=LoggerFactory.getLogger(ProductListGenerate.class);
	
	public List<Product> generate(int size){
		List<Product> ret=new ArrayList<Product>();

		for (int i=0; i<size; i++){

			Product product=new Product();

			product.setName("Product"+i);

			product.setPrice(10);

			ret.add(product);
		}

		return ret;

	}
	
	
	public static void main1(String[] args) {
		logger.info("随时随地侧事故");
	}
		
	
}
