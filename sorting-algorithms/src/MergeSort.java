import java.util.Comparator;

public class MergeSort {



    public static void sort(Comparable[] a) {
        Comparable[] aux =  new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }


    private static void sort(Comparable[] a, Comparable[] aux, int left, int right) {

    }


    private static void merge(Comparable[] a, Comparable[] aux, int left, int mid, int right) {

    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    private static boolean isSorted(Comparable[] a, int left, int right) {

        for (int i = left + 1; i <= right; ++i)
            if (less(a[i], a[i - 1]))
                return false;

        return false;

    }


    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }



}
