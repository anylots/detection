package com.frame.detection.common;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author anylots
 * @version $Id: LockTest.java, v 0.1 2020年12月05日 13:40 anylots Exp $
 */
public class LockTest {


    public static void main(String[] args) {

        final ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Object object = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("await a signal");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("take a signal");
                reentrantLock.unlock();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("take the lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                object.notify();
                System.out.println("send a signal");
                reentrantLock.unlock();
            }
        });
        thread2.start();

    }
}