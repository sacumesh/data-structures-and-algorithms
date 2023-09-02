import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {

        int k = Integer.parseInt(args[0].strip());

        RandomizedQueue<String> strings = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            String item =  StdIn.readString();
            strings.enqueue(item);
        }

        for (int i = 0; i < k; i++)
            StdOut.println(strings.dequeue());

    }


}
