package com.ljj.linklist;

/**
 * @Auther: ljj
 * @Date: 2018/6/27 20:42
 * @Description:linkList简单实现
 */
public class MyLinkList {
    private Node first;
    private Node last;
    private int size;

    public MyLinkList() {
    }

    public MyLinkList(Node first, Node last) {
        this.first = first;
        this.last = last;
    }

    public int size(){
        return this.size;
    }

    public void add(Object obj){
        Node node = new Node();
        if(first == null){
            node.setPrev(null);
            node.setObj(obj);
            node.setNext(null);

            last = node;
            first = node;
        }else{
            node.setPrev(last);
            node.setObj(obj);
            node.setNext(null);

            last.setNext(node);

            last = node;
        }
        size++;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
