/**
 * wait用法
 * 建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，要求线程同时运行
 * ，交替打印10次ABC。这个问题用Object的wait()，notify()就可以很方便的解决。
 * 代码如下：
 *
 */
package com.cfets.runnable.base.wait;

public class ThreadWait implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    /**
     *
     * @param name  线程名
     * @param prev  执行wait(),释放CPU，将当前线程置为等待状态
     * @param self  执行notify(),解除wait();
     */
    private ThreadWait(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (true) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.println(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
//        Object a = new Object();
//        Object b = new Object();
//        Object c = new Object();
        byte[] a = new byte[0];
        byte[] b = new byte[0];
        ThreadWait pa = new ThreadWait("A", b, a);
        ThreadWait pb = new ThreadWait("B", a, b);


        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
    }
}  
