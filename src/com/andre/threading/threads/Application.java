package com.andre.threading.threads;

public class Application {
    public static void main(String[] args) {
        Task taskRunner = new Task("Thread-1");
        Task taskRunner2 = new Task("Thread-2");
        System.out.println("Starting task 1");
        taskRunner.start();
        System.out.println("Starting task 2");
    }
}

class Task extends Thread {
    String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);

        for (int i = 0; i < 1000; i++) {
            System.out.println("number: "+ i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
