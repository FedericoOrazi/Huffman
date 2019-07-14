package Huffman;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(duration);

        int[] x = TextManipulator.getInstance().frequenzaLettereTesto();
        Node huffmanRoot = Huffman.makeHuffmanHeap(x);   
        Huffman.printHuffmanCode(huffmanRoot);
        System.out.println(TextManipulator.getInstance().textLength() + " --> text lenght");
        System.out.println(TextManipulator.getInstance().originalSize()+ " --> original size with 16bit code");
        System.out.println(Huffman.compressedSize(TextManipulator.getInstance().frequenzaLettereTesto()) + " --> compressed size");
    }
}
