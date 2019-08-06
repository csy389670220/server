package com.cfets.runnable.base.wait;

/**
 * 利用函数wait实现经典的消费者和生产者场景
 * 消费者:随机消耗产品，不能超过总产品数
 * 生产者：随机生成产品，累加在总产品数中
 */
public abstract class ThreadProduceAndConsume extends Thread {
    private String name;
    private Foo foo;

    public ThreadProduceAndConsume(String name) {
        super(name);
    }

    public ThreadProduceAndConsume(String name, Foo foo) {
        super(name);
        this.foo = foo;
    }

    @Override
    public void run() {
        doWork();
    }

    protected abstract void doWork();

    public static void main(String[] args) {
        final Foo foo=new Foo();
        final byte[] producerLock = new byte[0];
        final byte[] consumeLock = new byte[0];
        //生产者
        ThreadProduceAndConsume producer = new ThreadProduceAndConsume("producer") {
            @Override
            protected void doWork() {
                int count = 0;
                while (true) {
                    synchronized (consumeLock) {
                        synchronized (producerLock) {
                            count++;
                            //Integer ran = (int) (Math.random() * 10);
                            Integer ran = 40;
                            foo.inseter(ran);
                            foo.inseterProduce(ran);
                            System.out.println("第：" + count + "批，生产了：" + ran + "个产品，总数："+foo.getTotal());
                            if(foo.getTotal()>100){
                                producerLock.notify();
                            }

                        }
                            if(foo.getTotal()>100){
                                System.out.println("生产超标...");
                                try {
                                    consumeLock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }else {
                                System.out.println("继续生产...");
                            }

                        }
                }
            }
        };

        //消费者
        ThreadProduceAndConsume consume = new ThreadProduceAndConsume("consume") {
            @Override
            protected void doWork() {
                int count = 0;
                while (true) {
                    //Integer ran = (int) (Math.random() * 10);
                    Integer ran = 10;
                    synchronized (producerLock) {
                        synchronized (consumeLock) {
                            count++;
                            if(foo.getTotal()<ran){
                                System.out.println("ran:"+ran);
                                int others=foo.getTotal();
                                foo.del(others);
                                foo.inseterConsume(others);
                                System.out.println("第：" + count + "批，消费了：" + others + "个产品，总数："+foo.getTotal());
                            }else {
                                foo.del(ran);
                                foo.inseterConsume(ran);
                                System.out.println("第：" + count + "批，消费了：" + ran + "个产品，总数："+foo.getTotal());
                            }

                            if(foo.getTotal()<=0){
                                consumeLock.notify();
                            }

                        }
                        if(foo.getTotal()<=0){
                            System.out.println("需要生产了....");
                            try {
                                producerLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("继续消费...");
                        }
                    }
                }

            }
        };

        //监控线程
        ThreadProduceAndConsume monitor=new ThreadProduceAndConsume("monitor") {
            @Override
            protected void doWork() {
                while (true){
                    System.out.println("monitor ing...>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 总生产数："+foo.getProduceNum()+",总消费数:"+foo.getConsumeNum());
                }

            }
        };
        monitor.setPriority(Thread.MIN_PRIORITY);
        monitor.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consume.start();

    }
}
