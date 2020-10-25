package com.mujio.algorithm.recursion;


import com.mujio.dataStructure.simpleStruct.MyNode;

import java.util.List;

/**
 * @Description: demo
 * @Author: GZY
 * @Date: 2020/5/14 0014
 */

public class MyLinkedList {
    // 递归书写办法
    // 1. 先一般，后特殊（边界）
    // 2. 缩小规模


    // 示例1： 创建 n 个节点的单向链表
    public MyNode createLinkedList(List<MyNode> data) {
        // 3.处理边界
        if (data.isEmpty()){
            return null;
        }
        // 1.假设头节点后面的节点都已经连接好
        MyNode firstNode = new MyNode(data.get(0));

        // 2.将第一个节点的next指针指向n-1已经创建好链表的头节点
        data.remove(0);
        firstNode.setNext(createLinkedList(data));

        // 返回头节点
        return firstNode;
    }


    // 示例2： 将链表反转,传入值为原始链表的头节点
    public MyNode reverseLinkedList(MyNode head) {
        // 4. 处理边界
        if (head == null || head.getNext() == null){
            return head;
        }
        // 1. 假设只剩下head为最后一个未反转的节点，原来的顺序可以记为 1->2->3->4...->null
        // 此时head指向的是2，而反转后应当是2指向head节点，head节点指向null，除了head节点外
        MyNode newHead = reverseLinkedList(head.getNext());
        // 2. 将2节点的指针指向head
        head.getNext().setNext(head);
        // 3. 将head节点指向null
        head.setNext(null);
        return newHead;
    }
}
