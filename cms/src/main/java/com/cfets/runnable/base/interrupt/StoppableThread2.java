package com.cfets.runnable.base.interrupt;

/**
 * 相对安全可靠地中断线程
 */
public abstract class StoppableThread2 extends Thread {
    private volatile boolean isShutdownRequested = false;

    public final void shutdown(){
        isShutdownRequested = true;
        interrupt();
    }

    public final boolean isShutdownRequested() {
        return isShutdownRequested;
    }

    @Override
    public void run() {
        try {
            while(!isShutdownRequested()){
                doWork();
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException is Thrown");
        } finally {
            doShutdown();
        }
    }

    protected abstract void doWork() throws InterruptedException;

    protected abstract void doShutdown();


    public static void main(String[] args) {
        StoppableThread2 thread = new StoppableThread2() {

            @Override
            protected void doWork() throws InterruptedException {
                System.out.println("running...");
                sleep(500);
            }

            @Override
            protected void doShutdown() {
                System.out.println("shutdown!");
            }
        };
        thread.start();

        try {
            Thread.sleep(2200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("即将调用shutdown()方法");
        thread.shutdown();
    }

}