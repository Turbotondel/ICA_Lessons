package ica.app.algorithms.les8;

public class Node<T> {
    T val;

    public Node<T> firstChild;
    public Node<T> nextSibling;
    public int height, size;

    public Node(T val) {
        this.val = val;
        height = 0;
        size = 0;
    }

    public void addChild(T a) {
        if (firstChild == null) firstChild = new Node<T>(a);
        else firstChild.addSibling(a);
    }

    private void addSibling(T a) {
        if (nextSibling == null) nextSibling = new Node<T>(a);
        else nextSibling.addSibling(a);
    }

    public int determineSize() {
        size = 1;
        if (firstChild != null) size += firstChild.determineSize();

        int returnSize = size;

        if (nextSibling != null) {
            Node sibling = nextSibling;
            while (sibling != null) {
                returnSize += sibling.determineSize();
                sibling = sibling.nextSibling;
            }
        }

        return returnSize;
    }

    public int determineHeight() {
        if (firstChild != null) {
            height = 1 + firstChild.determineHeight();
        }

        int returnHeight = height;
        if (nextSibling != null) {
            Node sibling = nextSibling;
            while (sibling != null) {
                returnHeight = Math.max(Math.max(returnHeight, height), sibling.determineHeight());
                sibling = sibling.nextSibling;
            }
        }
        return returnHeight;
    }

    public void addChild(Node<T> a) {
        if (firstChild == null) firstChild = a;
        else firstChild.addSibling(a);
    }

    private void addSibling(Node<T> a) {
        if (nextSibling == null) nextSibling = a;
        else nextSibling.addSibling(a);
    }
}

