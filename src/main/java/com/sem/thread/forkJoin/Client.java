package com.sem.thread.forkJoin;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by brook on 2017/2/22.
 */
public class Client implements Runnable {

    private LinkedBlockingQueue requestList;

    public Client(LinkedBlockingQueue requestList) {
        this.requestList = requestList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuilder request = new StringBuilder();
                request.append(i);
                request.append(":");
                request.append(j);
                try {
                    requestList.put(request.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Client: %s at %s.\n",request,new Date());
            }
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Client: End.\n");
    }
}
