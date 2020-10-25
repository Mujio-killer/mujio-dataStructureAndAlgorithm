package com.mujio.algorithm.recursion;

import java.util.LinkedHashSet;

class LRUCache {
    private int capacity;
    // 先后顺序利用链表实现
    private MyNode head = new MyNode(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        MyNode temp = head;
        while (temp.next != null) {
            if (temp.key == key) {
                temp.reBuild(head, temp);
                return temp.value;
            }
            temp = temp.next; 
        }
        return -1;
    }
    
    public void put(int key, int value) {
        MyNode temp = head;
        if (head.next != null) {
            head.next = temp;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        if (capacity > 0) {
            capacity--;
            temp.next = new MyNode(key, value);
        } else {
            temp = new MyNode(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));      // 返回  3
        System.out.println(cache.get(4));       // 返回  4

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 class MyNode{
    public int value;
    public int key;
    public MyNode next;

    public MyNode(int key, int value){
        this.key = key;
        this.value = value;
    }
    public MyNode reBuild(MyNode head, MyNode target){
        MyNode temp = target;
        target = target.next;
        temp.next = head;

        return temp;

     }
 }

