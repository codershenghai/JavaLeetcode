package com.shenghaishxt;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("a");
        queue.offer("b");
        for (String q: queue) {
            System.out.println(q);
        }

        System.out.println(queue.element());
    }
}
