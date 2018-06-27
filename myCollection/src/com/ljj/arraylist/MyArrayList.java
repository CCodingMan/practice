package com.ljj.arraylist;

/**
 * @Auther: ljj
 * @Date: 2018/6/26 21:55
 * @Description:模仿实现ArrayList
 */
public class MyArrayList<E> {
    private int size;
    private Object[] elementData;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        if(initialCapacity > 0){
            this.elementData = new Object[initialCapacity];
        }else if(initialCapacity == 0){
            this.elementData = new Object[]{};
        }else{
            throw new IllegalArgumentException("Illegal capacity:"+initialCapacity);
        }
    }

    public void add(Object obj){
        ensureCapacity();
        elementData[size++] = obj;
    }

    public Object get(int index){
        checkIndex(index);
        return elementData[index];
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public E remove(int index){
        checkIndex(index);
        E oldValue = elementData(index);
        int numMoved = size - index -1;
        if(numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        this.elementData[--size] = null;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public E elementData(int index){
        return (E)elementData[index];
    }

    public void checkIndex(int index){
        if(index < 0 || index+1 > elementData.length){
            throw new IllegalArgumentException("illegal index:"+index);
        }
    }

    public void ensureCapacity(){
        if(size >= elementData.length){
            Object[] newArray = new Object[size*2+1];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            this.elementData = newArray;
        }
    }
}
