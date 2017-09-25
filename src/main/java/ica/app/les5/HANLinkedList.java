package ica.app.les5;

import java.util.Iterator;

public class HANLinkedList<T> implements Iterable<T> {
    private Link head = new Link();
    private Link tail = null;
    private int size = 0;

    public Link getHead() {
        return head;
    }

    public void setHead(Link head) {
        this.head = head;
    }

    public Link getTail() {
        return tail;
    }

    public void setTail(Link tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return (head == null && tail == null);
    }


    public void add(T value) {
        Link link = new Link();
        link.setValue(value);

        if(isEmpty()) {
            tail = link;
        } else {
            link.setNext(head);
        }
        head = link;
        size++;
    }

    public void insert(T value, int index) {
        Link temp = new Link();
        temp.setValue(value);
        Link curr = head;

        if(index == 0) {
            temp.setNext(head);
            this.head = temp;
        } else {
            for (int i = 1; i < index; i++) {
                curr = curr.getNext();
            }
            temp.setNext(curr.getNext());
            curr.setNext(temp);
        }
        size++;
    }

    public void delete(int index) {
        if (size == 0) {
            return;
        }

        Link curr = head;

        if (index == 0) {
            head = head.getNext();
        } else {
            for (int i = 1; i < index; i++) {
                curr = curr.getNext();
            }
            curr.setNext(curr.getNext().getNext());
        }
        size --;
    }

    public T get(int index) {
        Link curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getValue();
    }

    public void removeFirst() {
        if (size == 0) {
            return;
        }

        if(head == null) {
            return;
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
            }
        }
        size--;
    }

    @Override
    public String toString() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i).toString());
        }
        return super.toString();
    }

    public T getHeadValue() {
        return head.getValue();
    }

    public int getSize() {
        return size;
    }

    public Iterator<T> iterator() {
        return null;
    }

    private class Link {
        private Link next = null;
        private T value = null;

        public Link getNext() {
            return next;
        }

        public void setNext(Link nextLink) {
            next = nextLink;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
