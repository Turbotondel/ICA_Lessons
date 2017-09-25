package ica.app.les5;

public class HANArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int[] items;
    private int capacity;
    private int size = 0;


    public HANArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.items = new int[DEFAULT_CAPACITY];
    }

    public HANArrayList(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
    }


    public void add(int value) {

        if (size == capacity) {
            int[] tempArray = new int[capacity * 2 + 1];

            for (int i = 0; i < items.length; i++) {
                tempArray[i] = get(i);
            }
            items = tempArray;
            capacity = items.length;
        }

        set(size, value);
        size++;
    }


    public int get(int index) {
        return items[index];
    }

    public void set(int index, int value) {
        items[index] = value;
    }
}