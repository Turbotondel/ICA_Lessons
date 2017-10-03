package ica.app.algorithms.les5;

public class HANStack<T extends Comparable> {
    private	HANLinkedList<T> list = new HANLinkedList<T>();

    public T pop() {
        T o = list.get(0);
        list.removeFirst();
        return o;
    }

    public T top() {
        return list.get(0);
    }

    public void push(T o) {
        list.addFirst(o);
    }

    public int getSize() {
        return list.getSize();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }
}
