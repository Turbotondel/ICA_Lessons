package ica.app.algorithms.les4.sort;

/**
 * Created by Tim on 11-9-2017.
 */
public class BubbleSort<T> implements SortAlgorithm<T> {
    public <T extends Comparable<? super T>> void sort(T[] a) {
        if(a == null || a.length == 0) {
            return;
        }
        int n = a.length;
        int k;

        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if(a[i].compareTo(a[k]) > 0) {
                    swapNumbers(i, k, a);
                }
            }
        }
    }

    private <T extends Comparable<? super T>> void swapNumbers(int i, int j, T[] a) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
