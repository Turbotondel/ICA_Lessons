package ica.app.algorithms.les2;

public class Les2 {

    public static void main(String[] args) {
        System.out.println(faculteitNonRecursive(5));
        System.out.println(faculteitRecursive(5));
        System.out.println(somNonRecursive(12));
        System.out.println(somRecursive(12));
        System.out.println(count1sNonRecursive(63));
        System.out.println(count1sRecursive(63));
        System.out.println(reverse("Hello World!"));
    }

    // faculteitsfunctie, niet recursief
    public static int faculteitNonRecursive(int n) {
        int result = n;
        for(int i = n - 1; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    // faculteitsfunctie, recursief
    public static int faculteitRecursive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return faculteitRecursive(n -1) * n;
        }
    }

    //somfunctie, niet recursief
    public static int somNonRecursive(int n) {
        int result = n;
        for(int i = n - 1; i > 0; i--) {
            result += i;
        }
        return result;
    }

    //somfunctie, recursief
    public static int somRecursive(int n) {
        if(n == 1) {
            return 1;
        } else {
            return somRecursive(n - 1) + n;
        }
    }

    //7.23 Write a recursive method that returns the amount of 1s in the binary representation of N. Use the fact that this number equals the number of 1s in the representation of N / 2, plus 1, if N is odd.
    //Count 1s, non-recursive
    public static int count1sNonRecursive(int n) {
        int count;
        for(count = 0; n > 0; count++) {
            n &= n - 1;
        }
        return count;
    }

    public static int count1sRecursive(int n) {
        if(n == 0) {
            return 0;
        } else {
            return count1sRecursive(n/2) + (n%2);
        }
    }

    /*
        Method reverse shown below returns the reverse of a String.
            String reverse( String str )
        a. Implement reverse recursively. Do not worry about the inefficiency of string concatenation.
        b. Implement reverse by having reverse be the driver for a private recursive routine. reverse will create a StringBuffer and pass it to the recursive routine.
     */

    public static String reverse(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }


    //Maak een fractal genaamd de H-tree

}
