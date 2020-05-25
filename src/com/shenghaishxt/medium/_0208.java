package com.shenghaishxt.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树
 */
class TrieNode {

    // 子节点(key是下级字符，value是下级节点)
    private Map<Character, TrieNode> subNodes = new HashMap<>();

    // 添加子节点
    public void addSubNode(Character c, TrieNode subNode) {
        subNodes.put(c, subNode);
    }

    // 获取子节点
    public TrieNode getSubNode(Character c) {
        return subNodes.get(c);
    }
}

class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode subNode = curNode.getSubNode(c);

            // 如果没有这个节点则新建
            if (subNode == null) {
                subNode = new TrieNode();
                curNode.addSubNode(c, subNode);
            }
            // 指向子节点，进入下一循环
            curNode = subNode;
        }
        // 设置结束标识
        curNode.addSubNode('#', new TrieNode());
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            curNode = curNode.getSubNode(word.charAt(i));
            if (curNode == null) return false;
        }
        return curNode.getSubNode('#') != null;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            curNode = curNode.getSubNode(prefix.charAt(i));
            if (curNode == null) return false;
        }
        return true;
    }
}

public class _0208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); //true
        System.out.println(trie.search("app")); //false
        System.out.println(trie.startsWith("app")); //true
        trie.insert("app");
        System.out.println(trie.search("app")); //true
    }
}