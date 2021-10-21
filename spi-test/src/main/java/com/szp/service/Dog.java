package com.szp.service;

/**
 * @Author songzhipeng
 * @DATE 2021/10/21
 */
public class Dog implements IShout {

  @Override
  public void shout() {
    System.out.println("wang wang");
  }
}
