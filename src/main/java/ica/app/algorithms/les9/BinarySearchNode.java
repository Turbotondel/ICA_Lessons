package ica.app.algorithms.les9;

public class BinarySearchNode {
    private int element;
    private BinarySearchNode left;
    private BinarySearchNode right;

    public BinarySearchNode(int element) {
        this.element = element;
        left = null;
        right = null;
    }

    public int getElement() {
        return element;
    }

    public BinarySearchNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchNode left) {
        this.left = left;
    }

    public void setRight(BinarySearchNode right) {
        this.right = right;
    }

    public BinarySearchNode getRight() {
        return right;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public String toString() {
        return String.valueOf(element);
    }
}
