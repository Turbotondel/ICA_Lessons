package ica.app.algorithms.les8;

public class BinaryNode<T> {
    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode() {
        this(null, null, null);
    }
    public BinaryNode(T value) {
        this(value, null, null);
    }

    public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static <T> int size(BinaryNode<T> t) {
        if (t == null) {
            return 0;
        } else {
            return 1 + size(t.left) + size(t.right);
        }
    }

    public static <T> int height(BinaryNode<T> t) {
        if (t == null) {
            return -1;
        } else {
            return 1 + Math.max(height(t.left), height(t.right));
        }
    }

    public void printPreOrder() {
        System.out.println(value);
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
        System.out.println(value);
    }

    public void printInOrder() {
        if (left != null) {
            left.printPreOrder();
        }
        System.out.println(value);
        if (right != null) {
            right.printPreOrder();
        }
    }

    public BinaryNode<T> duplicate() {
        BinaryNode<T> root = new BinaryNode<T>(value, null, null);
        if (left != null) {
            root.left = left.duplicate();
        }
        if (right != null) {
            root.right = right.duplicate();
        }
        return root;
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public int compareTo(Object o) {
        return 0;
    }

    public String toString() {
        return (right == null && left == null) ? value.toString() : "(" + left.toString() + value + right.toString() + ")";
    }
}
