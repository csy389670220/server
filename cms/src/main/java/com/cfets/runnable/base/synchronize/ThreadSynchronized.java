package com.cfets.runnable.base.synchronize;

public abstract  class ThreadSynchronized implements  Runnable {
    private String name;

    private Foo foo;

    public ThreadSynchronized(String name) {
        this.name = name;
    }

    public ThreadSynchronized(String name, Foo foo) {
        this.name = name;
        this.foo = foo;
    }

    public String getName() {
        return name;
    }

    public Foo getFoo() {
        return foo;
    }

    @Override
    public void run() {
        doWork();

    }
    protected abstract void doWork();

    /**
     * 不加锁
     * @param args
     */
    public static void main1(String[] args) {
        final Foo foo=new Foo();
        Thread t1=new Thread(new ThreadSynchronized("A") {
            @Override
            protected void doWork() {
                foo.methodA("A");
            }
        });
        Thread t2=new Thread(new ThreadSynchronized("B") {
            @Override
            protected void doWork() {
                foo.methodA("B");
            }
        });
        t1.start();
        t2.start();
    }

    /**
     * synchronized当作函数修饰符时
     * 总结：
     * 1.单一个对象的synchronized函数在被执行时，其他线程无法执行这个synchronized函数
     * 2.单一个对象的synchronized函数在被执行时，其他线程无法执行这个对象的所有的synchronized函数
     * @param args
     */
    public static void main2(String[] args) {
        final Foo foo=new Foo();
        Thread t1=new Thread(new ThreadSynchronized("A") {
            @Override
            protected void doWork() {
                foo.methodB("A");
            }
        });
//        Thread t2=new Thread(new ThreadSynchronized("B") {
//            @Override
//            protected void doWork() {
//                foo.methodB("B");
//            }
//        });

        Thread t3=new Thread(new ThreadSynchronized("C") {
            @Override
            protected void doWork() {
                foo.methodC("C");
            }
        });
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
    }

    /**
     * 同步块,以对象作为锁
     * 一般建议 private byte[] lock = new byte[0];  // 特殊的instance变量
     * 生成零长度的byte[]对象只需3条操作码
     * 总结：
     * 1.以同一个对象为锁的代码块只能被一个线程执行
     * 2.当一个线程以一个对象为锁执行同步块，另外的线程也不能执行这个对象的同步方法,
     * 但是可以执行这个对象的非同步函数
     * @param args
     */
    public static void main3(String[] args) {
        final Foo foo=new Foo();
        Thread t1=new Thread(new ThreadSynchronized("A") {
            @Override
            protected void doWork() {
                synchronized (foo) {
                    while (true){
                        System.out.println(">>>>>>>>"+getName());
                    }
                }
            }
        });
//        Thread t2=new Thread(new ThreadSynchronized("B") {
//            @Override
//            protected void doWork() {
//                synchronized (foo) {
//                    while (true){
//                        System.out.println(">>>>>>>>"+getName());
//                    }
//                }
//            }
//        });
        Thread t2=new Thread(new ThreadSynchronized("B") {
            @Override
            protected void doWork() {
                foo.methodB("B");
            }
        });
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }


    /**
     * synchronized作用于static 函数
     * 总结：
     * 1.多个线程不能同时执行某个类的同一个同步静态函数
     * 2.一个类的静态同步函数被线程执行时，其他线程也不能执行这个类其他同步静态函数
     * 3. Foo.class和 P1.getClass()用于作同步锁是一样的，CSDN上说是不一样
     * @param args
     */
    public static void main(String[] args) {
        final Foo foo=new Foo();
        Thread t1=new Thread(new ThreadSynchronized("A") {
            @Override
            protected void doWork() {
                Foo.methodD("A");
            }
        });

        /*Thread t2=new Thread(new ThreadSynchronized("B") {
            @Override
            protected void doWork() {
                Foo.methodD("B");
                Foo.methodD_1("B_1");
            }
        });*/
        Thread t2=new Thread(new ThreadSynchronized("B") {
            @Override
            protected void doWork() {
                foo.methodE("B");
            }
        });
        t1.start();
        t2.start();
    }


}
