package com.andre.threading.producer_consumer;

import java.util.List;

public class Consumer implements Runnable {
    private List<Integer> questionList = null;

    public Consumer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void answerQuestion() throws InterruptedException {
        synchronized (questionList) {
            while(questionList.isEmpty()) {
                System.out.println("No questions to answer... waiting for producer to get questions");
                questionList.wait();
            }

            Thread.sleep(5000);
            System.out.println("Answered Question: " + questionList.remove(0));
            questionList.notify();
        }

//        synchronized (questionList) {
//            Thread.sleep(5000);
//            System.out.println("Answered Question" + questionList.remove(0));
//            questionList.notify();
//        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                answerQuestion();
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception");
            }
        }
    }
}
