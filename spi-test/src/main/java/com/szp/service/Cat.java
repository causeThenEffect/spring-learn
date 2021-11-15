package com.szp.service;

/**
 * @Author cause
 * @DATE 2021/10/21
 */
public class Cat implements IShout {

  @Override
  public void shout() {
    System.out.println("miao miao");
  }
}
