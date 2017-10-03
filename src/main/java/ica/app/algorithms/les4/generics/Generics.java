package ica.app.algorithms.les4.generics;

import java.util.ArrayList;

public class Generics {
    public static void main(String[] args) {
        String[] arr = new String[] {"tgr", "dwfdwfd", "f", "fd", "dwfdfffwgfhtg", "hgaa", "fhytre", "aafghbv"};
        MemoryCell<String> cell = new MemoryCell();
        String result = cell.min(arr);
        System.out.println(result);
    }

    public static double totalArea(ArrayList<? extends Shape> arr) {
        int total = 0;
        for (Shape s: arr) {
            if(s != null) {
                total += s.area();
            }
        }
        return total;
    }

    public static <T extends Comparable<? super T>> T findMin(T[ ] a){
        int minIndex = 0;

        for (int i = 1; i < a.length; i++) {
            if( a[i].compareTo(a[minIndex]) < 0){   // <0 kleiner dan
                minIndex = i;
            }
        }
        return a[minIndex];
    }
}
