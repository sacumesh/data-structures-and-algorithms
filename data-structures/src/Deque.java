import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N = 0;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
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

    public void addFirst(Item item) {
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

    public void addLast(Item item) {
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

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = first.item;
        first = first.next;

        if (first == null) last = null;
        else first.prev = null;

        --N;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        Item item = last.item;
        last = last.prev;

        if (last == null) first = null;
        else last.next = null;

        --N;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }


    public static void main(String[] args) {
        Deque<Integer> integers = new Deque<>();

        StdOut.println(integers.isEmpty());

        integers.addFirst(1);;
        StdOut.println(integers.removeFirst());

        integers.addLast(1);
        StdOut.println(integers.removeLast());

        StdOut.println(integers.size());

    }



}
