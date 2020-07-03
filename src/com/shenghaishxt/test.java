package com.shenghaishxt;

public class test {
    // 这里创建的threadLocal会自动在每一个线程上创建一个副本，副本之间彼此独立，互不影响
    // 这里创建的threadLocal就是ThreadLocalMap中的key
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void threadLocalTest() throws InterruptedException {
        threadLocal.set("这是主线程设置的123");
        String v = threadLocal.get();
        System.out.println("线程1执行之前，主线程取到的值: " + v);

        new Thread(() -> {
            String v1 = threadLocal.get();
            System.out.println("线程1取到的值：" + v1);
            threadLocal.set("这是线程1设置的456");
            v1 = threadLocal.get();
            System.out.println("重新设置之后线程1取到的值: " + v1);
            System.out.println("线程1执行结束");
        }).start();

        // 等待所有线程执行结束
        Thread.sleep(5000);
        System.out.println("--------------------------");
        v = threadLocal.get();
        System.out.println("线程1执行之后主线程取到的值: " + v);
    }

    public static void main(String[] args) throws InterruptedException {
        new test().threadLocalTest();
    }
}
