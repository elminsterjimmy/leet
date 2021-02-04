package com.elminster;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Leet1114 {

  class Foo {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile int status = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
      try {
        lock.lock();
        printFirst.run();
        status = 1;
        condition.signalAll();
      } finally {
        lock.unlock();
      }
    }

    public void second(Runnable printSecond) throws InterruptedException {
      try {
        lock.lock();
        while (1 != status) {
          condition.await();
        }
        printSecond.run();
        status = 2;
        condition.signalAll();
      } finally {
        lock.unlock();
      }
    }

    public void third(Runnable printThird) throws InterruptedException {
      try {
        lock.lock();
        while (2 != status) {
          condition.await();
        }
        printThird.run();
        status = 3;
        condition.signalAll();
      } finally {
        lock.unlock();
      }
    }
  }
}
