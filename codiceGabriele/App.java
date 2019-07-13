package Huffman;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        int x = Huffman.makeHuffmanHeap(TextManipulator.getInstance().frequenzaLettereTesto()).getKey();
        System.out.println(x);
    }
}
