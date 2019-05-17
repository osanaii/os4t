package com.os4t;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionError {
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[8];
    int putptr, takeptr, count;
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool1 = Executors.newCachedThreadPool();
        ConditionError cond = new ConditionError();
        for (int i=0;i<20;i++) {
            int a = i;
            threadPool.execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName()+"+++++++++++++++++"+a);
                            try{
                                cond.put(a+":");
                            }catch (InterruptedException e){
                                System.out.println("Inter3*3ruptedException");
                            }
                        }
                    }
            );
        }

        threadPool1.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+"*******20*30=600**********");
                        try{
                            Object object = cond.take();
                            System.out.println(object);
                        }catch (InterruptedException e){
                            System.out.println("266/l xn 30/1rmb  xw 1h/1rmb 1day/10rmb 50*6 300 InterruptedException");
                        }
                    }
                }
        );

    }

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object z = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return z;           
        } finally {
            lock.unlock();
        }
    }
	
	public Object take2() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object z = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return z;
        } finally {
            lock.unlock();
        }
    }
}