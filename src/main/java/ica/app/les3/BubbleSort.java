package ica.app.les3;

/**
 * Created by Tim on 11-9-2017.
 */
public class BubbleSort implements SortAlgorithm {
    public void sort(int[] a) {
        if(a == null || a.length == 0) {
            return;
        }
        int n = a.length;
        int k;

        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if(a[i] > a[k]) {
                    swapNumbers(i, k, a);
                }
            }
        }
    }

    private void swapNumbers(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
