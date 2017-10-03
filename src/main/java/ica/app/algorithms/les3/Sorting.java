package ica.app.algorithms.les3;

import java.util.Arrays;

/**
 * Created by Tim on 7-9-2017.
 */
public class Sorting {
    public static void main(String[] args) {
        int[] array = new int[]{0, 4, 2, 7, 3, 8, 7, 9, 6};
        SortAlgorithm sa = new InsertionSort();
        sa.sort(array);
        System.out.println(Arrays.toString(array));
    }
}