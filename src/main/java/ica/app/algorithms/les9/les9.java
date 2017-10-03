package ica.app.algorithms.les9;

public class les9 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = new int[]{1, 3, 8, 10, 19, 22, 32};
        tree.setRoot(BinarySearchTree.fromSortedArray(arr, 0, arr.length-1));
        arr = new int[]{32, 22, 19, 10, 8, 3, 1};
        System.out.println(tree.toString());
        tree.setRoot(BinarySearchTree.fromArray(arr));
        System.out.println(tree.toString());

    }
}
