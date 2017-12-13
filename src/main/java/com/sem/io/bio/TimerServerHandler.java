package com.sem.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import org.springframework.util.StringUtils;

/**
 * Created by xuyao on 2017/8/7.
 */
public class TimerServerHandler implements Runnable {

  private Socket socket;

  public TimerServerHandler(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    BufferedReader in = null;
    PrintWriter out = null;
    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      String currentTime = null;
      String body = null;
      while (true) {
        body = in.readLine();
        if (body == null) {
          break;
        }
        System.out.println("server receive order:"+body);
        currentTime = ("QUERY TIME ORDER".equalsIgnoreCase(body)) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        out.println(currentTime);
      }

    } catch (Exception e) {
      if (in != null) {
        try {
          in.close();
          in = null;
        } catch (IOException e1) {
          e1.printStackTrace();
        }
        if (out != null) {
          out.close();
          out = null;
        }
        if (socket != null) {
          try {
            socket.close();
          } catch (IOException e1) {
            e1.printStackTrace();
          }
          socket = null;
        }
      }
    }
  }
}
