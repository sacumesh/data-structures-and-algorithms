import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayLinkedList<T> implements Iterable<T> {

    private T[] s;
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }


    public void push(T item) {
        if (item == null) throw new IllegalArgumentException();

        if (N == s.length) resize(2 * s.length);

        s[++N] = item;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException();

        T item = s[--N];
        // prevent loitering
        s[N] = null;

        // prevent thrashing
        if (N == s.length / 4) resize(s.length / 2);

        return item;
    }



    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    private class ListIterator implements Iterator<T> {
        private int i = 0;

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
        return null;
    }
}
