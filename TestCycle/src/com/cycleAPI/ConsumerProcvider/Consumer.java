package com.cycleAPI.ConsumerProcvider;


import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private final BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		try {
			while (true) {
				Integer take = queue.take();
				process(take);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

	private void process(Integer take) throws InterruptedException {
		// System.out.println("[Consumer] Take : " + take);
		Thread.sleep(500);
	}

}

