package br.com.joaogabriel.collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * FIFO
 * First in, first out
 * */
public class QueueInfo {
    public static void main(String[] args) {
        /**
         * The object must be implements comparable or comparator*/
        Queue<String> queue = new PriorityQueue<>();
        queue.add("D");
        queue.add("B");
        queue.add("A");
        queue.add("Z");
        queue.add("Q");

        //Not ordering
        for(String value : queue) {
            System.out.println(value);
        }
    }
}
