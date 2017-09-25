package ica.app.les4.sort;

/**
 * Created by Tim on 11-9-2017.
 */
public interface SortAlgorithm<T> {
    public <T extends Comparable<? super T>> void sort(T[] a);
}
