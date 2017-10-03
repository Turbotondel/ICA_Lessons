package ica.app.algorithms.les4.sort;

/**
 * Created by Tim on 11-9-2017.
 */
public class QuickSort<T> implements SortAlgorithm<T> {
    private int number;

    public <T extends Comparable<? super T>> void sort(T[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        number = a.length;
        quicksort(a,0, number - 1);
    }

    private <T extends Comparable<? super T>> void quicksort(T[] a, int low, int high) {
        int i = low, j = high;
        T pivot = a[low + (high - low) / 2];

        while (i <= j) {
            while (a[i].compareTo(pivot) < 0) {
                i++;
            }

            while (a[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(a, low, j);
        if (i < high)
            quicksort(a, i, high);
    }

    private <T extends Comparable<? super T>> void swap(T[] numbers, int i, int j) {
        T temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

//    public <T extends Comparable<? super T>> void sort(T[] a) {
//        if (a == null || a.length == 0) {
//            return;
//        }
//        quicksort(a, 0, a.length - 1);
//    }
//
//    private <T extends Comparable<? super T>> void quicksort(T[] a, int low, int high) {
//        int middle = (low + high) / 2;
//        if (a[middle].compareTo(a[low]) < 0) {
//            swap(a, low, middle);
//        } else if (a[high].compareTo(a[low]) < 0) {
//            swap(a, low, high);
//        } else if (a[high].compareTo(a[middle]) < 0) {
//            swap(a, middle, high);
//        }
//
//        swap(a, middle, high - 1);
//        T pivot = a[high - 1];
//
//        int i, j;
//        for (i = low, j = high - 1; ;) {
//            while(a[++i].compareTo(pivot) < 0) {
//                ;
//            }
//
//            while (pivot.compareTo(a[-- j]) < 0) {
//                ;
//            }
//
//            if(i >= j) {
//                break;
//            }
//            swap(a, i, j);
//        }
//        swap(a, i, high - 1);
//        quicksort(a, low, i - 1);
//        quicksort(a, i + 1, high);
//    }
//
//        private <T extends Comparable<? super T>> void swap (T[]a, int i, int j){
//            T temp = a[i];
//            a[i] = a[j];
//            a[j] = temp;
//        }
}
