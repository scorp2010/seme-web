/**
 * 
 */
package com.sem.thread.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @Title: Main2.java
 * @Package com.sem.thread.forkJoin
 * @Description:
 * @author brook.xu
 * @date 2017年2月7日 下午6:08:04
 * @version V1.0
 */
public class Main2 {
	public static void main(String[] args) {
		Document mock = new Document();
		String[][] document = mock.generateDocument(100, 1000, "the");
		DocumentTask task = new DocumentTask(document, 0, 100, "the");
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		do {
			System.out.printf("******************************************\n");
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			System.out.printf("******************************************\n");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!task.isDone());
		pool.shutdown();
		try {
			System.out.printf("Main: The word appears %d in the document", task.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		try {
			System.out.printf("Main: The word appears %d in the document", task.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
