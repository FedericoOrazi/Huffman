package Huffman;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        Node huffmanRoot = Huffman.makeHuffmanHeap(TextManipulator.getInstance().frequenzaLettereTesto());
        Huffman.printHuffmanCode(huffmanRoot);
    }
}
