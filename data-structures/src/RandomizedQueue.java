import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int N;
    private int first;
    private int last;
    private Item[] q;

    public RandomizedQueue() {
        q = (Item[]) new Object[1];
        first = 0;
        last = 0;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int capacity) {

        assert capacity >= N;

        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = q[(first + i) % q.length];

        first = 0;
        last = N;
        q = copy;

    }

    private void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (N == q.length) resize(2 * q.length);

        q[last++] = item;

        if (last == q.length) last = 0;

        ++N;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();

        // random item to remove
        int k = (first + StdRandom.uniformInt(N)) % q.length;

        swap(q, first, k);

        Item item = q[first];
        q[first++] = null;
        --N;

        if (first == q.length) first = 0;

        if (N > 0 && N == q.length / 4) resize(q.length / 2);

        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();

        int i = (first + StdRandom.uniformInt(N)) % q.length;

        return q[i];
    }

    private class RandomizeIterator implements Iterator<Item> {

        private int i = 0;
        private Item[] copy;

        public RandomizeIterator() {
            copy = (Item[]) new Object[q.length];

            copy[0] = q[first];
            for (int k = 1; k < N; ++k) {
                int j = (first + k) % q.length;
                copy[k] = q[j];
                swap(copy, StdRandom.uniformInt(k), k);
            }
        }

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy[i++];
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizeIterator();
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();

        for (int i = 0; i < 10; ++i)
            randomizedQueue.enqueue(i);

        StdOut.println(randomizedQueue.dequeue());

        StdOut.println(randomizedQueue.sample());

        StdOut.println(randomizedQueue.isEmpty());

        StdOut.println(randomizedQueue.size());

    }
}
