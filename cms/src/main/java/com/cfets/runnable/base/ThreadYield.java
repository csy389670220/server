package com.cfets.runnable.base;

/**
 * 对比yield()和sleep()
 */
public class ThreadYield extends Thread {
    private String name;

    public ThreadYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 3) {
                this.yield();
            }
        }
    }

    /**
     * 现象A：
     * 李四-----1
     * 李四-----2
     * 李四-----3
     * 张三-----1
     * 张三-----2
     * 张三-----3
     * 张三-----4
     * 张三-----5
     * 李四-----4
     * 李四-----5
     *
     * 现象B：
     * 张三-----1
     * 张三-----2
     * 张三-----3
     * 张三-----4
     * 张三-----5
     * 李四-----1
     * 李四-----2
     * 李四-----3
     * 李四-----4
     * 李四-----5
     *
     * 总结：从A B2组现象可以看出，线程在执行yield()之后，会释放CPU资源，不过之后也会参与CPU资源的竞争
     *
     * sleep()和yield()的区别):
     * sleep()使当前线程进入停滞状态，所以执行sleep()的线程在指定的时间内肯定不会被执行；yield()只是使
     * 当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。sleep 方
     * 法使当前运行中的线程睡眼一段时间，进入不可运行状态，这段时间的长短是由程序设定的，yield 方法使当前线
     * 程让出 CPU 占有权，但让出的时间是不可设定的。实际上，yield()方法对应了如下操作：先检测当前是否有相
     * 同优先级的线程处于同可运行状态，如有，则把 CPU  的占有权交给此线程，否则，继续运行原来的线程。所以
     * yield()方法称为“退让”，它把运行机会让给了同等优先级的其他线程另外，sleep 方法允许较低优先级的线程
     * 获得运行机会，但 yield()  方法执行时，当前线程仍处在可运行状态，所以，不可能让出较低优先级的线程些时
     * 获得 CPU 占有权。在一个运行系统中，如果较高优先级的线程没有调用 sleep 方法，又没有受到 I\O 阻塞
     * ，那么，较低优先级线程只能等待所有较高优先级的线程运行结束，才有机会运行。
     * @param args
     */
    public static void main(String[] args) {
        ThreadYield yt1 = new ThreadYield("张三");
        ThreadYield yt2 = new ThreadYield("李四");
        yt1.start();
        yt2.start();
    }
}
