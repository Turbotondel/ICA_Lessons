package ica.app.algorithms.les3;

/**
 * Created by Tim on 11-9-2017.
 */
public class InsertionSort implements SortAlgorithm {
    public void sort(int[] a) {
        if(a == null || a.length == 0) {
            return;
        }
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }
}
