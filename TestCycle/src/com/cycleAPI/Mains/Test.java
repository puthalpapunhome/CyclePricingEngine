package com.cycleAPI.Mains;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.cycleAPI.ConsumerProcvider.Consumer;
import com.cycleAPI.ConsumerProcvider.Producer;

public class Test {

    public static void main(String[] args) {
    	//maximium  capacity 10
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
        
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();

    }

}
