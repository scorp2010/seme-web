package com.sem.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xuyao on 2017/8/7.
 */
public class TimeServer {

  public static void main(String[] args) throws IOException {
    int port = 8090;
    if (args != null && args.length >= 1) {

      try {
        port = Integer.valueOf(args[0]);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
    ServerSocket server = null;
    try {
      server = new ServerSocket(port);
      System.out.println("start prot:" + port);
      Socket socket = null;
      while (true) {
        socket = server.accept();
        new Thread(new TimerServerHandler(socket)).start();
      }
    } finally {
      if (server != null) {
        System.out.println("server close");
        server.close();
        server = null;
      }
    }
  }
}
