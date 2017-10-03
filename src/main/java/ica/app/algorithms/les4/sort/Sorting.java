package ica.app.algorithms.les4.sort;

import java.util.Arrays;

/**
 * Created by Tim on 7-9-2017.
 */
public class Sorting {
    public static void main(String[] args) {
        String[] array = new String[] {"b", "c", "e", "d", "a", "f"};
        SortAlgorithm sa = new BubbleSort();
        sa.sort(array);
        System.out.println(Arrays.toString(array));
    }
}