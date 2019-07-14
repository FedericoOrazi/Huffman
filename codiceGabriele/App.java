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
        System.out.println(TextManipulator.getInstance().textLength() + " --> text lenght");
        System.out.println(TextManipulator.getInstance().originalSize()+ " --> original size with 16bit code");
        System.out.println(Huffman.compressedSize(TextManipulator.getInstance().frequenzaLettereTesto()) + " --> compressed size");
    }
}
