package com.shenghaishxt.leetcode;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int key, val;
    public Node prev, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private Map<Integer, Node> map;
    private Node dummyHead, dummyTail;
    private int capacity, size;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.dummyHead = new Node(0, 0);
        this.dummyTail = new Node(0, 0);
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        // 如果哈希双向链表中不存在key，则直接返回-1
        if (!map.containsKey(key)) return -1;
        // 如果存在，则将该node更新到最前面，并返回val值
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        return node.val;
    }

    public void put(int key, int value) {
        // 如果哈希双向链表中存在key，则将node放到最前面，并更新val值，这里的操作和get()方法基本类似
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = dummyHead.next;
            node.prev = dummyHead;
            dummyHead.next.prev = node;
            dummyHead.next = node;
            node.val = value;
        } else {
            // 如果缓存满了，就删除链表的最后一个缓存，同时在哈希表中也删除
            if (capacity == size) {
                Node last = dummyTail.prev;
                dummyTail.prev = last.prev;
                dummyTail.prev.next = dummyTail;
                map.remove(last.key);
                size--;
            }
            // 在链表头部添加新node
            Node node = new Node(key, value);
            node.next = dummyHead.next;
            node.prev = dummyHead;
            dummyHead.next.prev = node;
            dummyHead.next = node;
            map.put(key, node);
            size++;
        }
    }
}

public class _0146_LRU缓存机制 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); //返回1
        cache.put(3, 3); //该操作会使得关键字 2 作废
        System.out.println(cache.get(2)); //返回-1（未找到）
        cache.put(4, 4); // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1)); // 返回 -1 (未找到)
        System.out.println(cache.get(3)); // 返回 3
        System.out.println(cache.get(4)); // 返回 4
    }
}