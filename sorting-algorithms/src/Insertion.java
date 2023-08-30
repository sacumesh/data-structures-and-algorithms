import java.util.Arrays;

public class Insertion {

    public static void sort(Comparable a[]) {
        int n = a.length;
        for (int i = 1; i < n; ++i) {
            int j = i - 1;
            while (j >= 0 && less(a[j + 1], a[j])){
                swap(a, j + 1, j);
                j = j - 1;
            }

        }
    }

    public static boolean isSorted(Comparable a[]) {
        for (int i = 1; i < a.length; ++i)
            if (less(a[i], a[i - 1]))
                return false;

        return true;
    }

    public static boolean less(Comparable v, Comparable w) {
        return  v.compareTo(w) < 0;
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
