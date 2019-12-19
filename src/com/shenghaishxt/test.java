package com.shenghaishxt;

import java.util.*;

public class test {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder();
        a.append("aaa");
        StringBuilder b = new StringBuilder();
        b.append("bbb");
        a.append(b);
        System.out.println(a.toString());
    }
}
