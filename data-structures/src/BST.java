import edu.princeton.cs.algs4.Queue;

import java.util.NoSuchElementException;

public class BST <Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;

        private int count;

        public Node(Key key, Value val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {

        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);

        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;

        x.count = 1 + size(x.left) + size(x.right);
        return x;

    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = root.left;
            else if (cmp > 0) x = root.right;
            else return x.val;
        }


        return null;
    }

    public void delete(Key key) {}

    public Iterable<Key> iterator() {
        Queue<Key> q = new Queue<>();
        inorder(root, q);

        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;

        return x.key;
    }


    public Node floor(Node x, Key key) {

        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;

    }

    public Key ceiling(Key key) {
        Node x =  ceiling(root, key);
        if (x == null) return null;

        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0) return x;
        if (cmp > 0) return floor(x.right, key);

        Node t = floor(x.left, key);
        if (t != null) return t;
        else return x;
    }


    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.count;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);

        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return  1 + size(x.left) + rank(key, x.right);
        else return size(x.left);


    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException();

        Node x = root;
        while (x.right != null)
            x = x.right;

        return x.key;
    }

    private Key min() {
        if (isEmpty()) throw new NoSuchElementException();

        Node x = root;
        while(x.left != null)
            x = x.left;

        return x.key;
    }


//    private Key select(int rank) {
//        if (rank < 0 || rank >= size()) throw new IllegalArgumentException();
//
//    }
//
//    private Key select (int rank)


}
