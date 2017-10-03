package ica.app.algorithms.les4.generics;

public class MemoryCell<T extends Comparable> implements Comparable<MemoryCell<T>> {
    // Private internal data representation
    private T storedValue;

    // Public methods
    public T read() {
        return storedValue;
    }

    public void write(T value) {
        storedValue = value;
    }

    @Override
    public String toString() {
        return "MemoryCell("+ read() +")";
    }

    public int compareTo(MemoryCell<T> other) {
        return storedValue.compareTo(other.read());
    }
}