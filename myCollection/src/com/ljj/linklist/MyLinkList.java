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

    public Object get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("illegal index:"+index);
        }
        Node temp = node(index);
        return temp.obj;
    }

    private Node node(int index) {
        Node temp = null;
        if(first != null){
            if(index < size >> 1){
                temp = first;
                for (int i=0; i<index; i++){
                    temp = temp.next;
                }
            }else{
                temp = last;
                for (int i=size-1; i>index; i--){
                    temp = temp.prev;
                }
            }
        }
        return temp;
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("illegal index:"+index);
        }
        Node temp = node(index);
        if(temp != null){
            Node up = temp.prev;
            Node down = temp.next;
            up.next = down;
            down.prev = up;
            size--;
        }
    }

    public void add(int index, Object obj){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("illegal index:"+index);
        }

        Node node = new Node();
        node.obj = obj;

        if(index == size){
            Node temp = node(index-1);
            if(temp != null){
                temp.next = node;
                node.prev = temp;
                last = node;
                size++;
            }
        }else{
            Node temp = node(index);

            if(temp != null){
                Node up = temp.prev;
                if(up == null){
                    temp.prev = node;
                    node.next = temp;
                    first = node;
                }else{
                    up.next = node;
                    node.prev = up;
                    node.next = temp;
                    temp.prev = node;
                }

                size++;
            }
        }
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
