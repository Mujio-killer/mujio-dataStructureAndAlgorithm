package com.mujio.dataStructure.simpleStruct;

import javax.xml.soap.Node;

/**
* @Description: Node 基本数据结构之 单向链表
* @Author: GZY
* @Date: 2020/5/14 0014
*/

public class MyNode {
    // 存储任意类型的数据
    private Object data;
    // 每个节点都存着指向下一个节点的指针（地址）
    private MyNode next;
    // 无参构造
    public MyNode() {
        // 利用全参构造初始化
        this(null,null);
    }

    // 单一参数，只支持传数据
    public MyNode(Object data) {
        this(data,null);
    }

    // 全参构造
    public MyNode(Object data, MyNode next) {
        this.data = data;
        this.next = next;

    }

    // set、get方法
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
    
}