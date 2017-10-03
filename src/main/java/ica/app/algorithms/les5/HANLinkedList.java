package ica.app.algorithms.les5;

public class HANLinkedList<T> {

    private int size = 0;
    private Node<T> headerNode = new Node<T>(null);

    public void addFirst(T o) {
        Node<T> newNext = new Node<T>(o);
        newNext.setNext(headerNode.getNext());
        headerNode.setNext(newNext);
        size++;
    }

    public void removeFirst() {
        if(size == 0) return;

        headerNode.setNext(headerNode.getNext().getNext());
        size--;
    }

    public void insert(int index, T o) {
        Node<T> previousNode = getNode(index - 1);
        if(previousNode != null) {
            Node<T> nextNode = previousNode.getNext();
            Node<T> newNode = new Node<T>(o);

            previousNode.setNext(newNode);
            newNode.setNext(nextNode);
            size++;
        }
    }

    public void delete(int index) {
        Node<T> previousNode = getNode(index - 1);
        if(previousNode != null) {
            Node<T> nextNode = previousNode.getNext();
            Node<T> secondNode = null;

            if(nextNode != null) {
                secondNode = nextNode.getNext();
            }

            previousNode.setNext(secondNode);
            size--;
        }
    }

    public T get(int index) {
        Node<T> node = getNode(index);
        T data = null;
        if(node != null) data = node.getData();

        return data;
    }

    private Node<T> getNode(int index) {
        Node<T> n = headerNode;
        for (int i = 0; i <= index; i++) {
            if(n == null) return null;
            n = n.getNext();
        }

        return n;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String s = "[";

        Node<T> n = headerNode.getNext();
        while(n != null) {
            s += n.getData() + ", ";
            n = n.getNext();
        }

        if(s.length() > 2) s = s.substring(0, s.length() - 2);
        s += "]";

        return s;
    }

}
