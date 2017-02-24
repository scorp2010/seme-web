package com.sem.thread.forkJoin;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by brook on 2017/2/22.
 */
public class MainLinkBlockingQueue {

  public static void main(String[] args) {
    LinkedBlockingQueue list = new LinkedBlockingQueue(3);
    Client client = new Client(list);
    Thread thread = new Thread(client);
    thread.start();
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 5; j++) {
        String request = null;
        try {
          request = (String) list.take();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.printf("Main: Request: %s at %s. Size:%d\n", request, new Date(), list.size());

      }
    }
  }

