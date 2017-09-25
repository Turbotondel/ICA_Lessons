package ica.app.les5;

public class HANStack<T extends Comparable> {
    HANLinkedList<T> list = new HANLinkedList<T>();

    public T pop() {
        T temp = list.getHeadValue();
        list.removeFirst();
        return temp;
    }

    public void push(T value) {
        list.add(value);
    }

    public T top() throws Exception {
        if (!list.isEmpty()) {
            return list.getHeadValue();
        } else {
            throw new Exception("Missing head value");
        }
    }

    public boolean isEmpty() {
        return (getSize() == 0);
    }

    public int getSize() {
        return list.getSize();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
