package Huffman;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        
        long startTime1 = System.currentTimeMillis();
        int[] x = TextManipulator.getInstance().frequenzaLettereTesto();
        long endTime1 = System.currentTimeMillis();
        long duration1 = endTime1 - startTime1;
        System.out.println(duration1 + " --> durata lettura del testo da file e attribuzione delle frequeze per ogni carattere"); 

        long startTime2 = System.currentTimeMillis();
        Node huffmanRoot = Huffman.makeHuffmanTree(x);
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;
        System.out.println(duration2 + " --> tempo per la creazione dell'albero di Huffman"); 
        
        long startTime3 = System.currentTimeMillis();
        Huffman.visitHuffmanTree(huffmanRoot);
        long endTime3 = System.currentTimeMillis();
        long duration3 = endTime3 - startTime3;
        System.out.println(duration3 + " --> tempo per visitare l'albero di Huffman"); 

        System.out.println(TextManipulator.getInstance().textLength() + " --> text lenght");
        System.out.println(TextManipulator.getInstance().originalSize()+ " --> original size with 16bit code");
        System.out.println(Huffman.compressedSize(TextManipulator.getInstance().frequenzaLettereTesto()) + " --> compressed size");
    }
}
