package com.cfets.runnable.base;

import static java.lang.Thread.sleep;

/**
 * join函数测试类
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，
 * 主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，需要用到子线
 * 程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到
 * join()方法了。
 */
public class ThreadJion implements Runnable {
    private String name;

    public ThreadJion(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + name + "运行 : " + i);
            try {
                int time=1000*1;
                System.out.println("子线程" + name + " 休眠 : " + time);
                sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");

    }

    /**
     * 不加入jion()
     * 总结：发现主线程比子线程早结束
     * @param args
     */
    public static void main1(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread  mTh1=new Thread(new ThreadJion("A"));
        Thread  mTh2=new Thread(new ThreadJion("B"));
        mTh1.start();
        mTh2.start();
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
    }

    /**
     * 加入jion()
     * 总结： 1.主线程一定会等子线程都结束了才结束
     *       2.可以看出线程在调用sleep()函数时，会让出CPU资源
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread  mTh1=new Thread(new ThreadJion("A"));
        Thread  mTh2=new Thread(new ThreadJion("B"));
        mTh1.start();
        mTh2.start();

        try {
            mTh1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            mTh2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
    }

}
