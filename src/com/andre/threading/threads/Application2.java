package com.andre.threading.threads;

public class Application2 {
    public static void main(String[] args) {
        Sequence sequence = new Sequence();

        Worker worker = new Worker(sequence);
        worker.start();

        Worker worker2 = new Worker(sequence);
        worker2.start();
    }
}

class Worker extends Thread {
    Sequence sequence;

    public Worker(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + "Value: " + this.sequence.getNext());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
