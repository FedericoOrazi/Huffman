package Huffman;

public abstract class Huffman {
    
    public BinaryHeap makeHuffmanHeap(int[] caratteri){
        BinaryHeap.getInstance(); //crea un heap binario vuoto
        for (int i = 0; i < caratteri.length; i++) {
            if (caratteri[i] != 0) {
                BinaryHeap.getInstance().insert(new Node(caratteri[i],(char)i));
            }
        }
        for (int i = 0; i < caratteri.length-2; i++) {
            BinaryHeap.getInstance().insert(
                new Node(
                    BinaryHeap.getInstance().extractMax().getKey()+BinaryHeap.getInstance().extractMax().getKey(),
                    ''
                )
            );
        }
    }
}