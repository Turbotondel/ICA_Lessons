package ica.app.algorithms.les4.generics;

public class MemoryCell<T extends Comparable<T>> implements Comparable<MemoryCell<T>> {

    private T storedValue;

    public static <T extends Comparable> T min(T[] arr) {
        T temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if((arr[i].compareTo(temp)) < 0){
                temp = arr[i];
            }
        }
        return temp;
    }

    public int compareTo(MemoryCell<T> o) {
        return this.read().compareTo(o.storedValue);
    }

    private T read() {
        return storedValue;
    }

    private void write(T value) {
        storedValue = value;
    }
}
