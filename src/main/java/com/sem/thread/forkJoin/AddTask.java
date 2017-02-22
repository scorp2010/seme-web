package com.sem.thread.forkJoin;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by scorp on 2017/2/20.
 */
public class AddTask implements Runnable{

    private ConcurrentLinkedDeque<String> list;

    public AddTask (ConcurrentLinkedDeque<String> list){
        this.list=list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": element;" + i);
        }

    }
}
