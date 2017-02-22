package com.sem.thread.forkJoin;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by brook on 2017/2/22.
 */
public class PollTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i <5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }
}
