package com.cfets.runnable.base.interrupt;

/**
 *  interrupted()函数
 *  参考：https://www.cnblogs.com/WJQ2017/p/7570849.html
 */
public abstract class StoppableThread extends Thread {

    @Override
    public void run() {
        while(!isInterrupted()){
            System.out.println("isInterrupted: " + isInterrupted());
            doWork();
        }
        System.out.println("END");
    }

    protected abstract void doWork();

    /**
     * 1 即便调用了interrupt方法，之后用isInterrupted()方法检查它的中断状态时也不一定能得到true。
     *
     * 2 如果线程当前运行处的代码块不对InterruptedException异常进行合适的处理，
     * 那么interrupt方法就没有任何效果。
     * @param args
     */
    public static void main(String[] args) {
        StoppableThread thread = new StoppableThread() {

            @Override
            protected void doWork() {
                System.out.println("running...");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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