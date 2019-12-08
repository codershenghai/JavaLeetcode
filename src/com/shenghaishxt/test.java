package com.shenghaishxt;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5,6};
        int[] b = Arrays.copyOfRange(a, 2, 4);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
