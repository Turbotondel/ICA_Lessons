package ica.app.algorithms.les8;

public interface ApplyBinaryTree<T ,U> {
    U apply(BinaryTree<T> bt);
    U apply(BinaryNode<T> node);
}
