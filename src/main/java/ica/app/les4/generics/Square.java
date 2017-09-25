package ica.app.les4.generics;

public class Square extends Shape implements Comparable<Shape>{
    public int compareTo(Shape o) {
        if(this.area() > o.area()) {
            return 1;
        } else if (this.area() < o.area()) {
            return -1;
        } else {
            return 0;
        }
    }
}
