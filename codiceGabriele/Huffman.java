package Huffman;

public abstract class Huffman {
    
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
}