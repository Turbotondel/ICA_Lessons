package ica.app.les8;

public class BinaryTree<T extends Comparable> {
    private BinaryNode<T> root;

    public int getLeafCount() {
        return getLeafCount(root);
    }

    private int getLeafCount(BinaryNode<T> root) {
        if (root == null) {
            return 0;
        } else if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        } else {
            return getLeafCount(root.getLeft()) + getLeafCount(root.getRight());
        }
    }

    private int getAllOneNonNulls() {
        return getAllOneNonNulls(root);
    }

    private int getAllOneNonNulls(BinaryNode<T> root) {
        if (root == null) {
            return 0;
        } else if (root.getLeft() == null && root.getRight() != null) {
            return 1 + getLeafCount(root.getRight());
        } else if (root.getLeft() != null && root.getRight() == null) {
            return 1 + getLeafCount(root.getLeft());
        } else {
            return getAllOneNonNulls(root.getLeft()) + getAllOneNonNulls(root.getRight());
        }
    }

    public int getAllTwoNoneNulls() {
        return getAllTwoNoneNulls(root);
    }

    private int getAllTwoNoneNulls(BinaryNode<T> root) {
        if (root == null) {
            return 0;
        } else if (root.getLeft() != null && root.getRight() != null) {
            return 1 + getAllTwoNoneNulls(root.getLeft()) + getAllTwoNoneNulls(root.getRight());
        }
        return getAllTwoNoneNulls(root.getLeft()) + getAllTwoNoneNulls(root.getRight());
    }

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T rootItem) {
        root = new BinaryNode<T>(rootItem, null, null);
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public int size() {
        return BinaryNode.size(root);
    }

    public int height() {
        return BinaryNode.height(root);
    }

    public void printPreOrder() {
        if (root != null) {
            root.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (root != null) {
            root.printPostOrder();
        }
    }

    public void printInOrder() {
        if (root != null) {
            root.printInOrder();
        }
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void merge(T rootItem, BinaryTree<T> t1, BinaryTree<T> t2) {
        if (t1.root == t2.root && t1.root == null) {
            throw new IllegalArgumentException();
        }

        root = new BinaryNode<T>(rootItem, t1.root, t2.root);
        if (this != t1) {
            t1.root = null;
        }
        if (this != t2) {
            t2.root = null;
        }
    }
}
