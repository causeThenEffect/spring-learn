package com.szp.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogJDKTest {

  public static Logger log = Logger.getLogger(LogJDKTest.class.toString());

  public static void main(String[] args) {
    // all→finest→finer→fine→config→info→warning→server→off
    // 级别依次升高，后面的日志级别会屏蔽之前的级别
    log.setLevel(Level.INFO);
    log.finest("finest");
    log.finer("finer");
    log.fine("fine");
    log.config("config");
    log.info("info");
    log.warning("warning");
    log.severe("server");
  }

}
