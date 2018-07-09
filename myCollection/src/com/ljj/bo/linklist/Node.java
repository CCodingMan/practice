package com.ljj.bo.linklist;

/**
 * @Auther: ljj
 * @Date: 2018/6/27 20:42
 * @Description:链表节点
 */
public class Node {
    Node prev;
    Object obj;
    Node next;

    public Node() {
    }

    public Node(Node prev, Object obj, Node next) {
        this.prev = prev;
        this.obj = obj;
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
