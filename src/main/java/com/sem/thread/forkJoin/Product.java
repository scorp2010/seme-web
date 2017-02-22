/**
 * 
 */
package com.sem.thread.forkJoin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**   
 * @Title: ForkJoin1.java 
 * @Package com.sem.thread 
 * @Description: fork/join 
 * @author xuy
 * @date 2016年12月17日 下午11:05:58 
 * @version V1.0   
 */
public @Data class Product {
	@Getter @Setter
	private String name;
	@Getter @Setter
	private double price;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		if (Double.compare(product.price, price) != 0) return false;
		return name.equals(product.name);

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = name.hashCode();
		temp = Double.doubleToLongBits(price);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
