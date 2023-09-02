public class RandomizedQueue<T> {

    private final static int INIT_CAPACITY = 8;
    private int N;
    private int first;
    private int last;
    private T[] q;

    public RandomizedQueue() {

        q = (T[]) new Object[INIT_CAPACITY];
        first = 0;
        last = 0;
        N = 0;

    }

    public boolean isEmpty() {
        return N == 0;
    }

    private int size() {
        return N;
    }

    public void resize(int capacity) {

        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = q[(first + i) % q.length];

        first = 0;
        last = N;
        q = copy;

    }

    public void enqueue(T item) {
        if (item == null) throw new IllegalArgumentException();


    }
}
