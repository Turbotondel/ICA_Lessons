package ica.app.algorithms.les3;

/**
 * Created by Tim on 11-9-2017.
 */
public class QuickSort implements SortAlgorithm {
    private int[] numbers;
    private int number;

    public void sort(int[] a) {
        if (a ==null || a.length==0){
            return;
        }
        this.numbers = a;
        number = a.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high-low)/2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }

            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void swap   (int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
