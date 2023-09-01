import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int N = 0;

    private class Node {
        T item;
        Node next;
        Node prev;
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current == null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void addFirst(T item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;

        if (last == null) last = first;
        else oldFirst.prev = first;

        ++N;
    }

    public void addLast(T item) {
        if (item == null) throw new IllegalArgumentException();

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        last.next = null;

        if (first == null) first = last;
        else oldLast.next = last;

        ++N;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        T item = first.item;
        first = first.next;

        if (first == null) last = null;
        else first.prev = null;

        --N;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        T item = last.item;
        last = last.prev;

        if (last == null) first = null;
        else last.next = null;

        --N;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }



}
