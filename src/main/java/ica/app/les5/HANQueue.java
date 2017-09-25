package ica.app.les5;

import java.util.ArrayList;

public class HANQueue<T> {
    ArrayList<T> list;
    private int size = 0;

    public HANQueue() {
        list = new ArrayList<T>();
    }

    public void clear() {
        size = 0;
    }

    public void enqueue(T value) {
        list.add(value);
        size ++;
    }

    public T dequeue(){
        if(isEmpty()) {
            return null;
        }
        T temp = this.getFront();
        list.remove(0);
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFront() {
        if(isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
