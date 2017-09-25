package ica.app.les3;

/**
 * Created by Tim on 11-9-2017.
 */
public class MergeSort implements SortAlgorithm {
    public void sort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int[] tmpArray = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center, right);
        }
    }

    private void merge(int[] a, int[] tmp, int left, int center, int right) {
        for (int i = left; i <= right; i++) {
            tmp[i] = a[i];
        }

        int i = left;
        int j = center + 1;
        int k = left;
        while (i <= center && j <= right) {
            if (tmp[i] <= tmp[j]) {
                a[k] = tmp[i];
                i++;
            } else {
                a[k] = tmp[j];
                j++;
            }
            k++;
        }
        while (i <= center) {
            a[k] = tmp[i];
            k++;
            i++;
        }
    }
}
