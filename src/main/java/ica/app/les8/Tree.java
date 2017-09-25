package ica.app.les8;

import ica.app.les5.HANLinkedList;

public class Tree<T> {
    private T label;
    private Tree<T> parent;
    private Tree<T> nextSibling;
    private Tree<T> firstChild;

    public Tree() {
    }

    public void addChild(Tree<T> t) {
        t.parent = this;
        if (firstChild == null) {
            firstChild = t;
        } else {
            t.nextSibling = firstChild;
            firstChild = t;
        }
    }

    public boolean isLeaf() {
        return firstChild == null;
    }

    public String toString() {
        String s = "[" + label.toString();
        Tree<T> t = firstChild;
        while (t != null) {
            s = s + " " + t.toString();
            t = t.nextSibling;
        }
        return s + " ]";
    }

    public void displayPreorder() {
        displayPreorder(0);
    }

    private void displayPreorder(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.println(" ");
            System.out.println(label.toString());
            Tree<T> t = firstChild;
            while (t != null) {
                t.displayPreorder(indent + 3);
                t = t.nextSibling;
            }
        }
    }

    public void displayPostOrder() {
        displayPostOrder(0);
    }

    private void displayPostOrder(int indent) {
        Tree<T> t = firstChild;
        while (t != null) {
            t.displayPostOrder(indent + 3);
            t = t.nextSibling;
        }
        for (int i = 0; i < indent; i++) {
            System.out.println(" ");
            System.out.println(label.toString());
        }
    }

    public T getLabel() {
        return label;
    }

    public void setLabel(T t) {
        label = t;
    }

    public Tree<T> getParent() {
        return parent;
    }

    public Tree<T> getNextSibling() {
        return nextSibling;
    }

    public Tree<T> getFirstChild() {
        return firstChild;
    }
}
