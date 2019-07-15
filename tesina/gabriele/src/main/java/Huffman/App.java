package Huffman;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        
        long startTime1 = System.currentTimeMillis();
        int[] x = TextManipulator.getInstance().frequenzaLettereTesto();
        long endTime1 = System.currentTimeMillis();
        long duration1 = endTime1 - startTime1;
        
        for (int i = 0; i < x.length; i++) {
            if (x[i] != 0) {
                System.out.print("[" + (char)i + "-->");
                System.out.println(x[i] + "]");
            }
        } 

        System.out.println("\nCodice di Huffman calcolato:\n");

        long startTime2 = System.currentTimeMillis();
        Node huffmanRoot = Huffman.getInstance().makeHuffmanTree(x);
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;
        
        
        long startTime3 = System.currentTimeMillis();
        Huffman.getInstance().visitHuffmanTree(huffmanRoot);
        long endTime3 = System.currentTimeMillis();
        long duration3 = endTime3 - startTime3;
        
        System.out.println(""); 
        System.out.println(duration1 + " --> durata lettura del testo da file e attribuzione delle frequeze per ogni carattere"); 
        System.out.println(duration2 + " --> tempo per la creazione dell'albero di Huffman");
        System.out.println(duration3 + " --> tempo per visitare l'albero di Huffman"); 
        System.out.println(TextManipulator.getInstance().textLength() + " --> lunghezza del testo");
        System.out.println(TextManipulator.getInstance().originalSize()+ " --> dimensione originale con codice a 16bit");
        System.out.println(Huffman.getInstance().compressedSize(TextManipulator.getInstance().frequenzaLettereTesto()) + " --> dimensione compressa");
        Huffman.getInstance().compressCode(TextManipulator.getInstance().getText());
        System.out.println(TextManipulator.getInstance().readTextCompressed());
    }
}
