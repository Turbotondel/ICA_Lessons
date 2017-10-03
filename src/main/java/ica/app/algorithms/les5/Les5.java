package ica.app.algorithms.les5;

import ica.app.algorithms.les4.sort.*;

public class Les5 {
    public static void main(String[] args) {
        String[] strings = new String[]{"y", "v", "d", "q", "b", "p", "u", "l", "c", "e", "j", "a", "s", "g"};
        SortAlgorithm algorithm = new BubbleSort();
        algorithm.sort(strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        //VRAGEN: ZINVOL OM ÜBERHAUPT EEN TOSTRING() METHODE TE MAKEN VOOR IETS ALS DE SYMBOLCHECKER?
    }
}
