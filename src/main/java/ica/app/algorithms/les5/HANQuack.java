package ica.app.algorithms.les5;

public class HANQuack<T extends Comparable> {
    HANLinkedList<T> list;
    public HANQuack(){
        list = new HANLinkedList<T>();
    }

    public T Pop(){
        T item = list.get(0);
        list.removeFirst();
        return item;
    }

    public T Top(){
        return list.get(0);
    }

    public void Push(T value){
        list.addFirst(value);
    }

    public int GetSize(){
        return list.getSize();
    }

    public String toString(){
        return list.toString();
    }

    public T Dequeue(){
        T temp =  list.get(list.getSize());
        list.delete(list.getSize());
        return temp;
    }
}
