import java.util.Random;

public class StdRandom {

    private final static long seed;

    private final static Random random;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    public static int uniformInt(int n) {
        if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
        return random.nextInt(n);
    }

    private static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void shuffle(Object[] a) {
        if (a == null) throw new IllegalArgumentException();

        for (int i = 1; i < a.length; ++i){
            int n = uniformInt(i);
            swap(a, i, n);
        }
    }




}
