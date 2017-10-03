package ica.app.algorithms.les8;

public class Tree<T> {

    private Node<T> root;

    public Tree(T root){
        this.root = new Node<T>(root);
    }

    public Tree(){

    }

    public void setRoot(Node<T> root){
        this.root = root;
    }

    public int computeSize(){
        return root.determineSize();
    }

    public int computeHeight(){
        return root.determineHeight();
    }
}
