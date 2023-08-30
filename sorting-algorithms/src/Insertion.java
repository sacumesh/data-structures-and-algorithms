import java.util.Arrays;

public class Insertion {

    public static void main(String[] args) {
        Integer[] a  = {1, 23, 4, 0, 5, 2};
        sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(isSorted(a));
    }

    public static void sort(Comparable a[]) {
        int n = a.length;
        for (int i = 1; i < n; ++i) {

            // loop invariant a[0: i - 1] is sorted;
            assert isSorted(a, 0, i - 1);

            int j = i - 1;
            while (j >= 0 && less(a[j + 1], a[j])){
                swap(a, j + 1, j);
                j = j - 1;
            }

        }
    }

    public static boolean isSorted(Comparable a[]) {
        return isSorted(a, 0, a.length - 1);
    }

    public static boolean isSorted(Comparable a[], int left, int right) {
        for (int i = left + 1; i <= right; i ++)
            if (less(a[i], a[i - 1])) return false;

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
