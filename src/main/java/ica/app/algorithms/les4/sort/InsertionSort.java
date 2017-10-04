package ica.app.algorithms.les4.sort;

/**
 * Created by Tim on 11-9-2017.
 */
public class InsertionSort<T> implements SortAlgorithm<T> {
    public <T extends Comparable<? super T>> void sort(T[] a) {
        if(a == null || a.length == 0) {
            return;
        }
        T temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(a[j].compareTo(a[j-1]) < 0) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }
}
