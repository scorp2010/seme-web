package com.sem.thread.forkJoin;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by brook on 2017/2/22.
 */
public class MainConcurrentLinkedDeque {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            AddTask addTask = new AddTask(list);
            threads[i] = new Thread(addTask);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n",list.size());

        for (int i = 0; i < threads.length; i++) {
            PollTask  pollTask = new PollTask(list);
            threads[i] = new Thread(pollTask);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n",list.size());
    }
}
