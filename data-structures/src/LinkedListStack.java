import javax.swing.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<T> implements Iterable<T> {


    private Node head = null;
    private int N = 0;

    private class Node {
        T item;
        Node next;
    }

    private class ListIterator implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null ;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();

            T item = current.item;
            current = current.next;
            return item;
        }
    }

    void push(T item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
    }

    T pop() {
        T item = head.item;
        head = head.next;
        return  item;
    }


    int size() {
        return N;
    }

    public boolean isEmpty() {
        return head == null;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
