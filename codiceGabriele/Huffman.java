package Huffman;

public abstract class Huffman {
    private static int[] huffman = new int[65536];

    public static Node makeHuffmanHeap(int[] caratteri){
        BinaryHeap.getInstance(); //crea un heap binario vuoto
        int n = 0;
        for (int i = 0; i < caratteri.length; i++) {
            if (caratteri[i] != 0) {
                Node x = new Node();
                x.setChar((char)i);
                x.setKey(caratteri[i]);
                BinaryHeap.getInstance().insert(x);
                n++;
            }
        }
        for (int i = 1; i < n; i++) {
            Node z = new Node();
            Node x = BinaryHeap.getInstance().extractMin();
            Node y = BinaryHeap.getInstance().extractMin();
            z.setLeft(x);
            z.setRight(y);
            z.setKey(x.getKey() + y.getKey());
            BinaryHeap.getInstance().insert(z);
        }
        
        
        return BinaryHeap.getInstance().extractMin();
    }

    public static void printHuffmanCode(Node root){
        print(root,"");
    }
    public static long compressedSize(int[] x){
        long sum = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] != 0) {
                int lunghezza = huffman[i];
                int frequenza = x[i];
                sum = sum + lunghezza * frequenza;
            }
        }
        return sum;
    }
    private static void print(Node x, String h){
        if(x.left() == null && x.right() == null){
            System.out.print(x.getChar());
            System.out.print("-->");
            System.out.println(h);
            huffman[(int)x.getChar()] = h.length();
        }
        if (x.left() != null) {
            print(x.left(), h + "0");
        }
        if(x.right() != null) {
            print(x.right(), h + "1"); 
        }
    }

}