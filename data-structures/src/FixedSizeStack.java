import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class FixedSizeStack<T> implements Iterable<T> {
    private T[] s;
    private int N = 0;

    public FixedSizeStack(int capacity) {
        s = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(T item) {
        if (item == null) throw new IllegalArgumentException();
        if (N == s.length) throw new StackOverflowError();
        s[N++] = item;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException();
        T item = s[--N];

        // prevent loitering
        s[N] = null;
        return item;
    }

    private class ListIterator implements Iterator<T> {

        int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();

            return s[i++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
}
