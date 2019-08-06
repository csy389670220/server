package com.cfets.runnable.base.synchronize;

public class Foo {

    public void methodA(String name) {
        while (true) {
            System.out.println("this is methodA >>>" + name);
        }

    }

    public synchronized void methodB(String name) {
        while (true) {
            System.out.println("this is methodB >>>" + name);
        }

    }

    public synchronized void methodC(String name) {
        while (true) {
            System.out.println("this is methodC >>>" + name);
        }

    }
    public synchronized static void methodD(String name) {
        while (true) {
            System.out.println("this is methodD >>>" + name);
        }

    }
    public synchronized static void methodD_1(String name) {
        while (true) {
            System.out.println("this is methodD_1 >>>" + name);
        }

    }

    public void methodE(String name) {
        synchronized (Foo.class){
            while (true) {
                System.out.println("this is methodE >>>" + name);
            }
        }


    }



}
