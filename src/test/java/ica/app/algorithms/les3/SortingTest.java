package ica.app.algorithms.les3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


/**
 * Created by Tim on 12-9-2017.
 */
public class SortingTest {
    SortAlgorithm algorithm;
    int[] randomArray;
    int[] reversedArray;
    int[] sameNumbersArray;
    int[] emptyArray;
    int[] alreadySortedArray;
    int[] sortedArray = new int[]{0, 2, 3, 4, 6, 7, 7, 8, 9};
    int[] sortedArray2 = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5};

    @Before
    public void setup() {
        randomArray = new int[]{0, 4, 2, 7, 3, 8, 7, 9, 6};
        reversedArray = new int[]{9, 8, 7, 7, 6, 4, 3, 2, 0};
        sameNumbersArray = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5};
        emptyArray = new int[]{};
        alreadySortedArray = sortedArray;
    }

    @Test
    public void insertionSortTest() {
        algorithm = new InsertionSort();
        algorithm.sort(randomArray);
        algorithm.sort(reversedArray);
        algorithm.sort(sameNumbersArray);
        algorithm.sort(alreadySortedArray);
        assertArrayEquals(randomArray, sortedArray);
        assertArrayEquals(reversedArray, sortedArray);
        assertArrayEquals(sameNumbersArray, sortedArray2);
        assertArrayEquals(alreadySortedArray, sortedArray);
    }

    @Test
    public void mergeSortTest() {
        algorithm = new MergeSort();
        algorithm.sort(randomArray);
        algorithm.sort(reversedArray);
        algorithm.sort(sameNumbersArray);
        algorithm.sort(alreadySortedArray);
        assertArrayEquals(randomArray, sortedArray);
        assertArrayEquals(reversedArray, sortedArray);
        assertArrayEquals(sameNumbersArray, sortedArray2);
        assertArrayEquals(alreadySortedArray, sortedArray);
    }

    @Test
    public void quickSortTest() {
        algorithm = new QuickSort();
        algorithm.sort(randomArray);
        algorithm.sort(reversedArray);
        algorithm.sort(sameNumbersArray);
        algorithm.sort(alreadySortedArray);
        assertArrayEquals(randomArray, sortedArray);
        assertArrayEquals(reversedArray, sortedArray);
        assertArrayEquals(sameNumbersArray, sortedArray2);
        assertArrayEquals(alreadySortedArray, sortedArray);
    }

    @Test
    public void bubbleSortTest() {
        algorithm = new BubbleSort();
        algorithm.sort(randomArray);
        algorithm.sort(reversedArray);
        algorithm.sort(sameNumbersArray);
        algorithm.sort(alreadySortedArray);
        assertArrayEquals(randomArray, sortedArray);
        assertArrayEquals(reversedArray, sortedArray);
        assertArrayEquals(sameNumbersArray, sortedArray2);
        assertArrayEquals(alreadySortedArray, sortedArray);
    }
}