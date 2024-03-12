package com.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// PROGRAM 1 ->  IN THIS PROGRAM I HAVE CREATED 1 THREAD AND IT IS RESPONSIBLE TO DO ALL THE JOBS

//class Printjob implements Runnable {
//    String name;
//
//    Printjob(String name) {
//        this.name = name;
//    }
//
//    public void run() {
//        System.out.println(name + " job started by " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println("Exception caught");
//        }
//        System.out.println(name + " job completed by " + Thread.currentThread().getName());
//    }
//}
//
//class first {
//    public static void main(String[] args) {
//        Printjob[] jobs = {new Printjob("durga"), new Printjob("Ravi"), new Printjob("shiva"), new Printjob("pavan"), new Printjob("Suresh"), new Printjob("Anil"),};
//
//        ExecutorService service = Executors.newFixedThreadPool(1);
//        for (Printjob job : jobs) {
//            service.submit(job);
//        }
//        service.shutdown();
//
//    }
//}

// PROGRAM 2 -> HERE I HAVE CREATED 3 THREADS

//class Printjob implements Runnable {
//    String name;
//
//    Printjob(String name) {
//        this.name = name;
//    }
//
//    public void run() {
//        System.out.println(name + " job started by " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println("Exception caught");
//        }
//        System.out.println(name + " job completed by " + Thread.currentThread().getName());
//    }
//}
//
//class first {
//    public static void main(String[] args) {
//        Printjob[] jobs = {new Printjob("durga"), new Printjob("Ravi"), new Printjob("shiva"), new Printjob("pavan"), new Printjob("Suresh"), new Printjob("Anil"),};
//
//        ExecutorService service = Executors.newFixedThreadPool(3);
//        for (Printjob job : jobs) {
//            service.submit(job);
//        }
//        service.shutdown();
//
//    }
//}

// PROGRAM 3 -> CALLABLE Interface

import java.util.concurrent.*;

class MyCallable implements Callable {
    int num;

    MyCallable(int num) {
        this.num = num;
    }

    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is responsible to find sum");
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}

class first {
    public static void main(String[] args) throws Exception {
        MyCallable[] jobs = {new MyCallable(10), new MyCallable(20), new MyCallable(30), new MyCallable(40), new MyCallable(50), new MyCallable(60),};
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (MyCallable job : jobs) {
            Future f = service.submit(job);
            System.out.println(f.get());
        }
        service.shutdown();
    }
}