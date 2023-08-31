import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

    public static void main(String[] args) {
        Integer[] a  = {1, 23, 4, 0, 5, 2};
        sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(isSorted(a));
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux =  new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int left, int right) {

        if (left >= right)  return;

        int mid = (left + right) / 2;
        sort(a, aux, left, mid);
        sort(a, aux, mid + 1, right);
        merge(a, aux, left, mid, right);


    }

    private static void merge(Comparable[] a, Comparable[] aux, int left, int mid, int right) {

        // Invariants
        // The two subarrays a[left:mid] and a[mid+1:right] are individually sorted in order.
        assert isSorted(a, left, mid);
        assert isSorted(a, mid + 1, right);

        for (int i = left; i <= right; ++i)
            aux[i] = a[i];

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; ++k) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > right)
                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }

        // post condition a[left:right] is sorted
        assert isSorted(a, left, right);

    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a, int left, int right) {

        for (int i = left + 1; i <= right; ++i)
            if (less(a[i], a[i - 1]))
                return false;

        return true;

    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }



}
