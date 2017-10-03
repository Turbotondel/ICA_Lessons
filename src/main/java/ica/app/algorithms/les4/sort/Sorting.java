package ica.app.algorithms.les4.sort;

import ica.app.algorithms.les4.generics.MemoryCell;

import java.util.Arrays;

/**
 * Created by Tim on 7-9-2017.
 */
public class Sorting {
    public static void main(String[] args) {
        MemoryCell<String> cell1 = new MemoryCell<String>();
        MemoryCell<String> cell2 = new MemoryCell<String>();
        MemoryCell<String> cell3 = new MemoryCell<String>();
        MemoryCell<String> cell4 = new MemoryCell<String>();
        MemoryCell<String> cell5 = new MemoryCell<String>();

        cell1.write("d");
        cell2.write("c");
        cell3.write("s");
        cell4.write("h");
        cell5.write("q");
        MemoryCell[] cells = new MemoryCell[]{cell1, cell2, cell3, cell4, cell5};


        SortAlgorithm sa = new BubbleSort();
        sa.sort(cells);
        System.out.println(Arrays.toString(cells));
    }
}
