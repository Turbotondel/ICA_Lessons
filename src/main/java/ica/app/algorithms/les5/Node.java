package ica.app.algorithms.les5;

public class Node<U> {

    private U data;
	
	private Node<U> nextNode;
	private Node<U> previousNode;
	
	public Node(U data) {
		this.data = data;
	}
	
	public Node<U> getNext() {
		return nextNode;
	}
	
	public void setNext(Node<U> n) {
		nextNode = n;
	}
	
	public Node<U> getPrevious(){
		return previousNode;
	}
	
	public void setPrevious(Node<U> previousNode) {
		this.previousNode = previousNode;
	}
	
	public U getData() {
		return data;
	}
}
