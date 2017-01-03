/**
 * 
 */
package org.sem.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Optional;

/**   
 * @Title: RepeatingAnnotations.java 
 * @Package org.sem.java8 
 * @Description: 
 * @author brook.xu
 * @date 2017年1月3日 下午3:09:42 
 * @version V1.0   
 */
public class RepeatingAnnotations {
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Filters {
		Filter[] value();
	}
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(Filters.class)
	public @interface Filter {
		String value();
	}
	
	@Filter("sx")
//	@Filters(value = { @Filter("xs") })
	@Filter("ff")
	public interface Filterable {
		
	}

	public static void main(String[] args) {
		for( Filter filter:Filterable.class.getAnnotationsByType(Filter.class)){
			System.out.println(filter.value());
		}
		for(Filters filters:Filterable.class.getDeclaredAnnotationsByType(Filters.class)){
			System.out.println(filters.value()[0]);
		}
		
		Optional< String > fullName = Optional.ofNullable( null );
		System.out.println( "Full Name is set? " + fullName.isPresent() );        
		System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) ); 
		System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
	}
}
