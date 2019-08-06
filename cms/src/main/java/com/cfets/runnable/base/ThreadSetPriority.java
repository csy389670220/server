package com.cfets.runnable.base;

/**
 * setPriority(): 更改线程的优先级。
 * 　　　　  MIN_PRIORITY = 1
 *   　　   NORM_PRIORITY = 5
 *         MAX_PRIORITY = 10
 */
public class ThreadSetPriority extends Thread {
    private String name;

    public ThreadSetPriority(String name) {
        super(name);
    }

    @Override
    public void run() {
            System.out.println("" + this.getName() + "----->" );
    }


    public static void main(String[] args) {
        ThreadSetPriority t1 = new ThreadSetPriority("A");
        ThreadSetPriority t2 = new ThreadSetPriority("B");
        ThreadSetPriority t3 = new ThreadSetPriority("C");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();

    }

}
