import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<T> implements Iterable<T> {

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

        assert capacity >= N;

        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = q[(first + i) % q.length];

        first = 0;
        last = N;
        q = copy;

    }

    public void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void enqueue(T item) {
        if (item == null) throw new IllegalArgumentException();

        if (N == q.length) resize(2 * q.length);

        q[last++] = item;

        if (last == q.length) last = 0;

        ++N;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        // random item to remove
        int k = (first + StdRandom.uniformInt(N)) % q.length;

        swap(q, first, k);

        T item = q[first];
        q[first++] = null;
        --N;

        if (first == q.length) first = 0;

        if (N > 0 && N == q.length / 4) resize(q.length / 2);

        return item;
    }

    public T sample() {
        if (isEmpty()) throw new NoSuchElementException();

        int i = (first + StdRandom.uniformInt(N)) % q.length;

        return q[i];
    }

    private void shuffle(Object[] a, int size, int first) {
        for (int i = 1; i < size; ++i) {
            int k = (first + StdRandom.uniformInt(i)) % q.length;
            swap(a, i, k);
        }
    }

    private class RandomizeIterator implements Iterator<T> {

        private int i = 0;

        public RandomizeIterator() {
            shuffle(q, N, first);
        }

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return q[(first + i++) % q.length];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomizeIterator();
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();

        for (int i = 0; i < 10; ++i)
            randomizedQueue.enqueue(i);

        for (Integer integer: randomizedQueue) {
            System.out.println(integer);
        }
    }
}
