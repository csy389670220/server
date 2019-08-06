package com.cfets.runnable.base.interrupt;

public abstract class StoppableThread1 extends Thread {

    @Override
    public void run() {
        while(!isInterrupted()){
            System.out.println("isInterrupted: " + isInterrupted());
            try {
                doWork();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException is Thrown");
            }
        }
        System.out.println("END");
    }

    protected abstract void doWork() throws InterruptedException;

    /**
     * 改进了StoppableThread代码：修改上面的那个类的doWork()方法，让它声明抛出
     * InterruptedException，并把实现中的sleep(500)去掉。
     *
     *
     * 总结：
     * 1.InterruptedException是在线程的wait()、sleep()、join()
     * 等方法中抛出的，并且抛出后会清除掉Thread对象的中断状态。
     * 2.Thread类的静态方法interrupted()用来检查当前线程的中断状态
     * 。这个方法除了返回当前线程的中断状态（true/false），还会把中断状态给清除掉
     */
    public static void main(String[] args) {
        StoppableThread1 thread = new StoppableThread1() {

            @Override
            protected void doWork() throws InterruptedException{
                System.out.println("running...");
            }
        };
        thread.start();

        try {
            Thread.sleep(2200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("即将调用interrupt()方法");
        thread.interrupt();
    }
}