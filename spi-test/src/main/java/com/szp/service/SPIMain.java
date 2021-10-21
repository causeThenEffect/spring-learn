package com.szp.service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author songzhipeng
 * @DATE 2021/10/21
 */
public class SPIMain {

  public static void main(String[] args) {
    ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);

    Iterator<IShout> iShoutIterator = shouts.iterator();

    iShoutIterator.forEachRemaining(iShout -> iShout.shout());

    for (IShout s : shouts) {
      s.shout();
    }


  }

}
