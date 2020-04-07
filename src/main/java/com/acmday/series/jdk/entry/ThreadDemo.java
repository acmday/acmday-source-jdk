package com.acmday.series.jdk.entry;

/**
 * @author acmday.
 * @date 2020/4/5.
 */
public class ThreadDemo {

    public static void main(String[] args) {

    }

    static class RunnableDemo implements Runnable {
        @Override
        public void run(){
            /*Runnable userTask = getUserTashFromQueue();
            userTask.run();*/
        }
    }

    static class ThredDemo extends Thread {
        @Override
        public void run(){
            /*Runnable userTask = getUserTashFromQueue();
            userTask.run();*/
        }
    }
}
