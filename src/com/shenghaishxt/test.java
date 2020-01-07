package com.shenghaishxt;

import java.util.*;

public class test {
    public static void main(String[] args) {
        StringBuilder x = new StringBuilder("沉默王二");
        change(x);
        System.out.println(x);
    }

    public static void change(StringBuilder ddd) {
        ddd.delete(3, 4).append("三");
    }
}
