import javax.swing.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<T> implements Iterable<T> {

    private static final int INIT_CAPACITY = 8;
    private T[] q;
    private int first;
    private int last;

    private int N;

    public ResizingArrayQueue() {
        q = (T[]) new Object[INIT_CAPACITY];
        first = 0;
        last = 0;

    }

    public boolean isEmpty() {
        return  N == 0;
    }

    private void resize(int capacity) {

        assert capacity >= N;

        T[] copy = (T[]) new Object[capacity];

        for (int i = 0; i < N; i++)
            copy[i] = q[(first + i) % q.length];

        q = copy;
        first = 0;
        last = N;

    }

    public void push(T item) {
        if (item == null) throw new IllegalArgumentException();

        if (q.length == N) resize(2 * q.length);

        q[last++] = item;

        if (last == q.length) last = 0;

        ++N;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException();

        T item = q[first];
        q[first++] = null;

        if (first == q.length) first = 0;

        N--;

        if (N > 0 && N == q.length / 4) resize(q.length / 2);

        return item;
    }

    private class ListIterator implements Iterator<T> {

        private int i = 0;
        private int n = N;

        @Override
        public boolean hasNext() {
            return i < n;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = q[(first + i) % q.length];
            ++i;
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        ResizingArrayQueue<Integer> integers = new ResizingArrayQueue<>();

        // Test push and pop
        integers.push(1);
        integers.push(2);
        integers.push(3);
        assert integers.pop() == 1;
        assert integers.pop() == 2;
        assert integers.pop() == 3;

        // Test push and pop with resizing
        for (int i = 1; i <= 20; i++) {
            integers.push(i);
        }
        for (int i = 1; i <= 20; i++) {
            assert integers.pop() == i;
        }

        // Test push and pop with push after pop
        integers.push(1);
        integers.push(2);
        assert integers.pop() == 1;
        integers.push(3);
        integers.push(4);
        assert integers.pop() == 2;
        assert integers.pop() == 3;
        assert integers.pop() == 4;

        // Test iterator
        integers.push(1);
        integers.push(2);
        integers.push(3);
        Iterator<Integer> iterator = integers.iterator();
        assert iterator.hasNext();
        assert iterator.next() == 1;
        assert iterator.hasNext();
        assert iterator.next() == 2;
        assert iterator.hasNext();
        assert iterator.next() == 3;
        assert !iterator.hasNext();

        // Test push after pop with iterator
        iterator = integers.iterator();
        assert iterator.hasNext();
        assert iterator.next() == 1;
        assert iterator.hasNext();
        integers.push(4);
        assert iterator.next() == 2;
        assert iterator.next() == 3;
        assert !iterator.hasNext();
    }
}
