package com.cfets.runnable.base.wait;

public class Foo {
    private Integer total=0;// 总数

    private Integer produceNum=0;// 总生产数

    private Integer consumeNum=0;// 总消费数数

    public   Integer  getTotal() {
        return total;
    }

    public Integer getProduceNum() {
        return produceNum;
    }

    public Integer getConsumeNum() {
        return consumeNum;
    }

    public synchronized void inseter(Integer num) {
        this.total=this.total+num;

    }

    public synchronized void del(Integer num) {
        this.total=this.total-num;

    }

    public synchronized void inseterProduce(Integer num) {
        this.produceNum=this.produceNum+num;
    }

    public synchronized void inseterConsume(Integer num) {
        this.consumeNum=this.consumeNum+num;
    }
}
