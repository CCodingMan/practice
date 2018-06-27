package com.ljj.linklist;

/**
 * @Auther: ljj
 * @Date: 2018/6/27 20:42
 * @Description:链表节点
 */
public class Node {
    private Object prev;
    private Object obj;
    private Object next;

    public Node() {
    }

    public Node(Object prev, Object obj, Object next) {
        this.prev = prev;
        this.obj = obj;
        this.next = next;
    }

    public Object getPrev() {
        return prev;
    }

    public void setPrev(Object prev) {
        this.prev = prev;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }
}
