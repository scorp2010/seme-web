package com.sem.io.nio;

import com.sem.io.bio.TimerServerHandler;
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
//    MultiplexerTimeServer
  }
}
