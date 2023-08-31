import java.util.Arrays;

public class Partition {


    public static void main(String[] args) {
        Integer[] a  = {1, 23, 4, 0, 5, 2};
        lomutoPartition(a);

        System.out.println(Arrays.toString(a));

    }


    public static void lomutoPartition(Comparable[] a){
        int n = a.length - 1;
        Comparable pivot = a[n];

        int j = 0;
        for (int k = 0; k < n; ++k ){
            if (less(a[k], pivot))
                swap(a, j++, k);
        }
        swap(a, j, n);
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    private static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
