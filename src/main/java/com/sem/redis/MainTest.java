package com.sem.redis;

/**
 * Created by brook on 2017/2/23.
 */
public class MainTest {
  public static void main(String[] args) {
    JedisUtil.init();
    long snx=JedisUtil.getInstance().new Strings().setnx("testnx1", "---xx---");
    System.out.println(snx);
  }
}
