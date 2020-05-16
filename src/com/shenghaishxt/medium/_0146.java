package com.shenghaishxt.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 直接使用双向链表无法在O(1)时间进行get操作，直接使用哈希表又无法实现顺序机制（实现LRU），
 * 因此 ————> 哈希双向链表诞生了！它是哈希表和双向链表的结合体
 *
 * 双向链表的链表操作比较复杂，建议在写代码之前先在纸上画清楚逻辑，不然很容易乱
 */
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
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        // 若哈希双向链表中存在key，则将该node更新到最前面，并返回val值
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
        // 如果哈希链表中存在key，则将该node更新到最前面，并更新value值
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
            // 如果缓存满了，就删除链表最后一个缓存，同时将哈希表中对应node也删除
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

public class _0146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); //1
        cache.put(3, 3);
        System.out.println(cache.get(2)); //-1
        cache.put(4, 4);
        System.out.println(cache.get(1)); //-1
        System.out.println(cache.get(3)); //3
        System.out.println(cache.get(4)); //4
    }
}
