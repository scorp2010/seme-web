/**
 * 
 */
package org.sem.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**   
 * @Title: Streams.java 
 * @Package org.sem.java8 
 * @Description: 
 * @author brook.xu
 * @date 2017年1月3日 下午4:01:18 
 * @version V1.0   
 */
public class Streams {
	private enum Status {
		OPEN,CLOSE
	};
	
	private static final class Task {
		@Getter
		private final Status status;
		@Getter
		private final Integer points;
		
		Task(final Status status,final Integer points){
			this.status=status;
			this.points=points;
		}

		@Override
		public String toString() {
			return "Task [status=" + status + ", points=" + points + "]";
		}
	}
	public static void main(String[] args) {
		final Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5),new Task(Status.OPEN, 13),new Task(Status.CLOSE, 8));
		long ll=tasks.stream().filter(tasks1 -> Status.OPEN==tasks1.getStatus()).mapToLong(Task::getPoints).sum();
		System.out.println(ll);
		
		int ii=tasks.stream().parallel().map(Task::getPoints).reduce(0, Integer::sum);
		System.out.println("**"+ii);
		
		final Map<Status, List<Task>> map =tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
		System.out.println(map);
	}
}
