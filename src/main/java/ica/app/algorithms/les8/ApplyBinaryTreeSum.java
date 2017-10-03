//package ica.app.algorithms.les8;
//
//public class ApplyBinaryTreeSum implements ApplyBinaryTree<String, Integer>{
//
//    public Integer apply(BinaryTree bt) {
//        if(bt.getRoot() != null) return apply(bt.getRoot());
//
//        return 0;
//
//    }
//
//    public Integer apply(BinaryNode node) {
//        return node.getValue() + (node.getLeft() == null ? 0 : apply(node.getLeft())) + (node.getRight() == null ? 0 : apply(node.getRight()));
//    }
//}
