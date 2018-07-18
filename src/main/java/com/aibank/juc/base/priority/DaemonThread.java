package com.aibank.juc.base.priority;

class DaemonThreadTest {

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(3);
                    System.out.println(this.getName() + "(isDaemon=" + this.isDaemon() + ")" + ", loop " + i);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    static class DaemonThread extends Thread {
        public DaemonThread(String name) {
            super(name);
        }

        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
                    Thread.sleep(1);
                    System.out.println(this.getName() + "(isDaemon=" + this.isDaemon() + ")" + ", loop " + i);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()
                + "(isDaemon=" + Thread.currentThread().isDaemon() + ")");

        Thread t1 = new MyThread("t1");      // 新建t1
        Thread t2 = new DaemonThread("t2"); // 新建t2
        t2.setDaemon(true);                // 设置t2为守护线程
        t1.start();                        // 启动t1
        t2.start();                        // 启动t2
    }
}

