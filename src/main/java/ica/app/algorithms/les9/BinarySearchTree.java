package ica.app.algorithms.les9;

import ica.app.algorithms.DuplicateItemException;
import ica.app.algorithms.ItemNotFoundException;
import ica.app.algorithms.les3.QuickSort;
import ica.app.algorithms.les3.SortAlgorithm;

public class BinarySearchTree {
    private BinarySearchNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private BinarySearchNode insert(int value, BinarySearchNode node) {
        if (node == null) {
            node = new BinarySearchNode(value);
        } else if (value < node.getElement()) {
            node.setLeft(insert(value, node.getLeft()));
        } else if (value > node.getElement()) {
            node.setRight(insert(value, node.getRight()));
        } else if (value == node.getElement()) {
            throw new DuplicateItemException(String.valueOf(value));
        }
        return node;
    }

    public void remove(int value) {
        root = remove(value, root);
    }

    private BinarySearchNode remove(int value, BinarySearchNode node) {
        if (node == null) {
            throw new ItemNotFoundException(String.valueOf(value));
        }
        if (value < node.getElement()) {
            node.setLeft(remove(value, node));
        } else if (value > node.getElement()) {
            root.setRight(remove(value, node));
        } else if (node.getLeft() != null && node.getRight() != null) {
            node.setElement(findMin(node.getRight()).getElement());
            node.setRight(removeMin(node.getRight()));
        } else {
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        }
        return node;
    }

    protected BinarySearchNode removeMin(BinarySearchNode node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() != null) {
            node.setLeft(removeMin(node.getLeft()));
            return node;
        } else {
            return node.getRight();
        }
    }

    private BinarySearchNode find(int value, BinarySearchNode node) {
        if (node == null) {
            throw new ItemNotFoundException(String.valueOf(value));
        }
        if (node.getElement() == value) {
            return node;
        } else {
            BinarySearchNode left = find(value, node.getLeft());
            BinarySearchNode right = find(value, node.getRight());
            if (left != null) {
                return left;
            } else {
                return right;
            }
        }
    }

    public BinarySearchNode findMin(BinarySearchNode node) {
        if (node.getLeft() != null) {
            return findMin(node.getLeft());
        }
        return node;
    }

    public BinarySearchNode findMax(BinarySearchNode node) {
        if (node.getRight() != null) {
            return findMin(node.getRight());
        }
        return node;
    }

    public static BinarySearchNode fromSortedArray(int[] input, int start, int end) {
        if (start > end) {
            return null;
        }
        int median = (start + end) / 2;
        BinarySearchNode node = new BinarySearchNode(input[median]);
        node.setLeft(fromSortedArray(input, start, median - 1));
        node.setRight(fromSortedArray(input, median + 1, end));

        return node;
    }

    public static BinarySearchNode fromArray(int[] input) {
        SortAlgorithm algorithm = new QuickSort();
        algorithm.sort(input);
        return fromSortedArray(input, 0, input.length - 1);
    }

    public String toString() {
        return toString(new StringBuilder(), root).toString();
    }

    private static StringBuilder toString(StringBuilder string, BinarySearchNode node) {
        string.append('{');
        if (node != null) {
            string.append(node.getElement());
            toString(string.append(", "), node.getLeft());
            toString(string.append(", "), node.getRight());
        }
        return string.append('}');
    }

    public BinarySearchNode getRoot() {
        return root;
    }

    public void setRoot(BinarySearchNode root) {
        this.root = root;
    }
}
