package ch14.ex10;

import java.util.LinkedList;

/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 */

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.
 *
 * [Instruction]
 *  Implement one constructor and three methods.
 *  Don't forget to write a Test program to test this class.
 *  Pay attention to @throws tags in the javadoc.
 *  If needed, you can put "synchronized" keyword to methods.
 *  All classes for implementation must be private inside this class.
 *  Don't use java.util.concurrent package.
 */
public class ThreadPool {

	private WorkQueue queue;
	private WorkerThread[] threads;
	private boolean isStarted = false;


    /**
     * Constructs ThreadPool.
     *
     * @param queueSize the max size of queue
     * @param numberOfThreads the number of threads in this pool.
     *
     * @throws IllegalArgumentException if either queueSize or numberOfThreads
     *         is less than 1
     */
    public ThreadPool(int queueSize, int numberOfThreads) {
    	if (queueSize < 1) {
    		throw new IllegalArgumentException("queueSize(= "+ queueSize +") is less than 1.");
    	}
    	if (numberOfThreads < 1) {
    		throw new IllegalArgumentException("numberOfThreads(= "+ numberOfThreads +") is less than 1.");
    	}
    	queue = new WorkQueue(queueSize);
    	threads = new WorkerThread[numberOfThreads];
    	for (int i = 0; i < numberOfThreads; i++) {
    		threads[i] = new WorkerThread();
    	}
    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public synchronized void start() {
    	if (isStarted)
    		throw new IllegalStateException("threads has been already started.");
    	for (WorkerThread wt: threads) {
    		wt.start();
    	}
    	isStarted = true;
    }

    /**
     * Stop all threads and wait for their terminations.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public synchronized void stop() {
    	if (!isStarted)
    		throw new IllegalStateException("threads has not been started.");
    	for (WorkerThread wt: threads) {
			wt.stopThread();
			try {
				wt.join();
			} catch (InterruptedException e) {
			}
    	}
    	isStarted = false;
    }

    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread. If the queue is full, then
     * this method invocation will be blocked until the queue is not full.
     *
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    public synchronized void dispatch(Runnable runnable) {
       	if (runnable == null)
       		throw new NullPointerException("Runnable Object must not be null.");
       	if (!isStarted)
       		throw new IllegalStateException("this pool must have been already started.");
    	queue.add(runnable);
    }

    /**
     *
     * @author mary-mogreen
     *
     */
    private class WorkerThread extends Thread {
    	private boolean isStop;

    	WorkerThread() {
    		isStop = false;
    	}

    	public void stopThread() {
    		isStop = true;
    		queue.stop();
		}

		public void run() {
    		while (!isStop) {
    			Runnable r = queue.poll();
    			if ( r != null)
    				r.run();
    		}
    	}


    }

    /**
     *
     * @author mary-mogreen
     *
     */
    private class WorkQueue {
    	private final int queueSize;
    	private LinkedList<Runnable> queue = new LinkedList<Runnable>();

    	WorkQueue(int queueSize) {
    		this.queueSize = queueSize;
    	}

    	/**
    	 * If the queue is full, then
    	 * this method invocation will be blocked until the queue is not full.
    	 *
    	 * @param r Runnable Object
    	 * @return true or false.
    	 */
        synchronized boolean add(Runnable r) {
    		while (queue.size() >= queueSize) {
    			try {
					wait();
				} catch (InterruptedException e) {
					return false;
				}
    		}
    		boolean result = queue.add(r);
    		notifyAll();
    		return result;
    	}

        /**
         *
         * @return Runnable Object.
         */
    	synchronized Runnable poll() {
    		while (queue.isEmpty()) {
    			try {
					wait();
				} catch (InterruptedException e) {
					return null;
				}
    		}
    		Runnable r = queue.poll();
    		notifyAll();
    		return r;
    	}

    	void stop() {
    		notifyAll();
    	}
    }
}
